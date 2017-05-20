/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class.ArbolAvl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jhon
 */
public class ArbolAvl {

    public NodoDobleAvl raiz;

    /*Método que construye el árbol avl usando recorrido inorden
    y el método de insertar un dato al árbol*/
    public void construyeAvl(List<DatoNodo> r) {
        if (r != null) {
            for (int i = 0; i < r.size(); i++) {

                DatoNodo dato;
                dato = r.get(i);
                insertarDatoEnAvl(dato.getDato(), dato.getId());
            }
        }
    }

    //Para cuántos nodos tiene el árbol
    public int CountNodos(NodoDobleAvl r) {
        int count = 1;
        if (r == null) {
            return 0;
        }
        if (r.ld != null) {
            count += CountNodos(r.ld);
        }
        if (r.li != null) {
            count += CountNodos(r.li);
        }
        return count;

    }

    public void insertarDatoEnAvl(Object d, int id) {
        int aux;
        NodoDobleAvl x; //nodo para dato a insertar
        NodoDobleAvl p; //para recorrer el árbol buscando dónde insertar el nuevo dato
        NodoDobleAvl q; //Apunta hacia el padre de p
        NodoDobleAvl pivote; //Dirección del dato que posiblemente quede desbalanceado como consecuencia de la inserción
        NodoDobleAvl padrePivote; //Dirección del dato que es padre de pivote
        x = new NodoDobleAvl(d, id);
        if (raiz == null) {
            raiz = x;
            return;
        }
        p = raiz; //se empieza buscando por la raíz
        q = null; //la raiz no tiene padre
        pivote = raiz;
        padrePivote = null; //la raiz no tiene padre
        while (p != null) {

            if (p.retornaId() == id) { //condición para verificar que no hayan datos repetidos
                return;
            }
            if (p.retornaFb() != 0) {
                pivote = p;
                padrePivote = q;
            }
            q = p;
            if (compara(p.retornaId(), id) > 0) { //Si el dato que hay en p es mayor al dato d entonces
                p = p.retornaLi();
            } else { //para saber si se va por la lina izquierda o la liga derecha de p
                p = p.retornaLd();
            }
        }
        if (compara(q.retornaId(), id) > 0) { //si el dato que hay en q es mayor que el dato d entonces
            q.asignaLi(x); //conecta a x como hijo izquierdo de q
        } else {
            q.asignaLd(x); //conecta a x como hijo derecho de q
        }
        aux = pivote.retornaFb();
        if (compara(pivote.retornaId(), id) > 0) { //Si el dato que hay en pivote es mayor que el dato d entonces
            pivote.asignaFb(aux + 1); //Se recalcula el factor de balance de pivote
            q = pivote.retornaLi();
        } else {
            pivote.asignaFb(aux - 1);
            q = pivote.retornaLd();
        }
        p = q;
        while (p != x) { //para recalcular factores de balance en toda la trayectoria desde pivote hasta x
            if (compara(p.retornaId(), id) > 0) { //Si el dato que hay en p es mayor que el dato de entonces
                p.asignaFb(1);
                p = p.retornaLi();
            } else {
                p.asignaFb(-1);
                p = p.retornaLd();
            }
        }
        if (Math.abs(pivote.retornaFb()) < 2) { //retorna si el arbol con x insertado queda balanceado
            return;
        }

        if (pivote.retornaFb() == 2) {
            if (q.retornaFb() == 1) { //Corresponde a una rotación a la derecha
                unaRotacionALaDerecha(pivote, q);
            } else { //Corresponde a doble rotación a la derecha
                q = dobleRotacionALaDerecha(pivote, q);
            }
        } else if (q.retornaFb() == -1) { //Corresponde a una rotación a la derecha
            unaRotacionALaIzquierda(pivote, q);
        } else { //Corresponde a doble rotación a la derecha
            q = dobleRotacionALaIzquierda(pivote, q);
        }
        if (padrePivote == null) {
            raiz = q;
            return;
        }
        if (pivote == padrePivote.retornaLi()) {//Pega la nueva raíz del árbol rebalanceado al dato q
            padrePivote.asignaLi(q);
        } else {
            padrePivote.asignaLd(q);
        }

    }

    //p: Dirección del dato con factor de balance no permitido, ya sea +2 ó -2
    //q: Dirección del hijo derecho si fb de p es -2 o dirección del hijo izquierdo si fb de p es 2
    public void unaRotacionALaDerecha(NodoDobleAvl p, NodoDobleAvl q) { //Se realiza cuando fb de p = 2 y fb de q = 1

        p.asignaLi(q.retornaLd()); //el hijo derecho de q será hijo izquierdo de p
        q.asignaLd(p); //el hijo derecho de q será p
        p.asignaFb(0);
        q.asignaFb(0);
    }

    public void unaRotacionALaIzquierda(NodoDobleAvl p, NodoDobleAvl q) { //Se realiza cuando fb de p = -2 y fb de q = -1

        p.asignaLd(q.retornaLi()); //El hijo izquierdo de q será el nuevo hijo derecho de p
        q.asignaLi(p); //p será el nuevo hijo izquierdo de q
        p.asignaFb(0);
        q.asignaFb(0);
    }

    //r: Es el hijo izquierdo de q cuando fb de q = 1 o es el hijo derecho de q cuando fb de q = -1
    public NodoDobleAvl dobleRotacionALaDerecha(NodoDobleAvl p, NodoDobleAvl q) { //Se realiza cuando fb de p = 2 y fb de q = -1

        NodoDobleAvl r;
        r = q.retornaLd(); //r es el hijo derecho de q
        q.asignaLd(r.retornaLi()); //el hijo izquierdo de r será el nuevo hijo derecho de q
        r.asignaLi(q); //El nuevo hijo izquierdo de r será q
        p.asignaLi(r.retornaLd()); //El anterior hijo derecho de r será el nuevo hijo izquierdo de p
        r.asignaLd(p); //el nuevo hijo derecho de r será p
        //Se recalculan factores de balance según sea el caso
        switch (r.retornaFb()) {
            case 0:
                p.asignaFb(0);
                q.asignaFb(0);
                break;
            case 1:
                p.asignaFb(-1);
                q.asignaFb(0);
                break;
            case -1:
                p.asignaFb(0);
                q.asignaFb(1);
        }
        r.asignaFb(0);
        return r;
    }

    public NodoDobleAvl dobleRotacionALaIzquierda(NodoDobleAvl p, NodoDobleAvl q) { //Se realiza cuando fb de p = -2 y fb de q = 1

        NodoDobleAvl r;
        r = q.retornaLi(); //r es hijo izquierdo de q
        q.asignaLi(r.retornaLd()); //el hijo derecho de r es el nuevo hijo izquierdo de q
        r.asignaLd(q); //el nuevo hijo derecho de r será q
        p.asignaLd(r.retornaLi()); //el anterior hijo izquierdo de r será el nuevo hijo derecho de p
        r.asignaLi(p); //el nuevo hijo izquierdo de r será p
        switch (r.retornaFb()) {
            case 0:
                p.asignaFb(0);
                q.asignaFb(0);
                break;
            case 1:
                p.asignaFb(0);
                q.asignaFb(-1);
                break;
            case -1:
                p.asignaFb(1);
                q.asignaFb(0);
        }
        r.asignaFb(0);
        return r;
    }

    public static boolean esNumero(String cadena) { //La idea de este método es aberiguar si el dato que se ingresa es un número o no
        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int compara(int num1, int num2) {

        if (num1 == num2) { //Los datos son iguales
            return 0;
        } else if (num1 < num2) { //el dato 1 es menor que el dato 2
            return -1;
        } else {
            return 1; //el dato 1 es mayor que el dato 2
        }

    }

    public List<Object> generarLista() {
        List<Object> lista = new ArrayList<Object>();
        obtenerLista(raiz, lista);
        return lista;
    }

    private void obtenerLista(NodoDobleAvl r, List<Object> list) {
        if (r != null) {
            list.add(r.dato);
            obtenerLista(r.ld, list);
            obtenerLista(r.li, list);
        }

    }

    public Object getObject(int id) {
        NodoDobleAvl nodo = consultar(raiz, id);
        if (nodo == null) {
            return null;
        } else {
            return nodo.dato;
        }
    }

    public NodoDobleAvl getLastNode(NodoDobleAvl r) {
        if (r != null) {
            if (r.ld == null) {
                return r;
            } else {
                return getLastNode(r.ld);
            }
        }
        return null;

    }

    public void removeNodo(int id) {
        ConsultarNodoConPadre(raiz, raiz, id);
    }

    private void ConsultarNodoConPadre(NodoDobleAvl nodo, NodoDobleAvl padre, int id) {
        if (nodo != null) {
            if (nodo.id == id) {
                //tiene dos hijos
                if (nodo.ld != null && nodo.li != null) {
                    NodoDobleAvl replace = (NodoDobleAvl) getLastNode(nodo.li);
                    NodoDobleAvl newNode = new NodoDobleAvl(replace.dato, replace.id);
                    removeNodo(replace.id);
                    newNode.asignaLd(nodo.retornaLd());
                    newNode.asignaLi(nodo.retornaLi());
                   
                    if(padre.ld==nodo)
                    {
                        padre.asignaLd(newNode);
                    }
                    else
                        padre.asignaLi(newNode);
                    
                    
                } //nodo no tiene hijos
                else if (nodo.ld == null && nodo.li == null) {
                    if(padre.ld==nodo)
                    {
                        padre.asignaLd(null);
                    }
                    else
                        padre.asignaLi(null);
                } else if (nodo.ld != null) {
                    nodo = nodo.ld;
                } else if (nodo.li != null) {
                    nodo = nodo.li;
                }

            } else if (id > nodo.id  ) {
                ConsultarNodoConPadre(nodo.ld, nodo, id);
            } else {
                ConsultarNodoConPadre(nodo.li, nodo, id);
            }

        }

    }

    private NodoDobleAvl consultar(NodoDobleAvl r, int id) {
        if (r != null) {
            if (r.id == id) {
                return r;
            } else if (r.id > id) {
                return consultar(r.ld, id);
            } else {
                return consultar(r.ld, id);
            }

        } else {
            return null;
        }

    }

    /*  public int compara(String cadena1, String cadena2){

        long num1,num2;
        if(esNumero(cadena1) && esNumero(cadena2)){ //pregunto si los dos datos son números para hacer su respectiva comparación
            num1 = Long.parseLong(cadena1);
            num2 = Long.parseLong(cadena2);
            if(num1 == num2){ //Los datos son iguales
                return 0;
            }else{
                if(num1 < num2){ //el dato 1 es menor que el dato 2
                    return -1;
                }else{
                    return 1; //el dato 1 es mayor que el dato 2
                }
            }
            
        }else{ //Si los dos datos no son números, se comparan como un string normal
        return cadena1.compareToIgnoreCase(cadena2); //utilizo comparteToIgnoreCase para no diferenciar de mayúsculas
        }
    }*/
}
