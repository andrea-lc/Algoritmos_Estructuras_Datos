package com.mycompany.s06;

public class colaLista {
    //puntero que siempre apuntara al primer nodo de la lista
    Nodo cabeza;

    //crea la lista pero vacia
    public colaLista() {
        this.cabeza = null;
    }

    public void mostrarLista(){
    
        Nodo actual = cabeza;
        //verifica si la lista esta vacia
        if (actual==null) {
            System.out.println("Lista vacia :(");
            return;         
        }
        // recorre la lista hasta que el ultimo nodo contenga null
        while(actual!=null){
            System.out.print(actual.dato +" -> ");
            if (actual.siguiente==null){
                System.out.println("null");
            }
            actual = actual.siguiente;
            
        }
    }


    public void insertar(int dato){       
        Nodo nuevoNodo= new Nodo(dato);
        Nodo actual = cabeza;
        //actualiza el puntero hasta que llegue al ultimo nodo
        while(actual.siguiente!=null){
            actual = actual.siguiente;
        }
        actual.siguiente= nuevoNodo;
    }


    public void eliminar(){
        //verifica que la lista este vacia
        if(cabeza==null){
            System.out.println("Lista vacia :(");
            return;
        }
        //remplaza el nodo inicial por el siguiente nodo y el nodo inicial se pierde
        cabeza = cabeza.siguiente;
    }
    
    public boolean isempty() {
        Nodo actual = cabeza;
        if (actual==null) {
            System.out.println("Lista vacia :(");
            return true;         
        }
        return false;
    }

    public int front() {
        return cabeza.dato;
    }
}

