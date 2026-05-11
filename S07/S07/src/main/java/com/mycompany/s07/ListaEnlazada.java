package com.mycompany.s07;

public class ListaEnlazada {
    //puntero que siempre apuntara al primer nodo de la lista
    Nodo cabeza;

    //crea la lista pero vacia
    public ListaEnlazada() {
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
            System.out.print(actual.dato+" -> ");
            if (actual.siguiente==null){
                System.out.println("null");
            }
            actual = actual.siguiente;
            
        }
    }

    public void insertarInicio(int dato){
        //crea el nodo 
        Nodo nuevoNodo = new Nodo(dato);
        //crea una referencia del nuevo nodo al primero nodo que habia y cambia el puntero lol jejejeje
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void insertarFinal(int dato){       
        Nodo nuevoNodo= new Nodo(dato);
        Nodo actual = cabeza;
        //actualiza el puntero hasta que llegue al ultimo nodo
        while(actual.siguiente!=null){
            actual = actual.siguiente;
        }
        actual.siguiente= nuevoNodo;
    }

    public void insertarValor(int dato, int posicion){
        Nodo nuevoNodo = new Nodo(dato);
        Nodo actual= cabeza;
        //verifica que la lista este llena
        if(cabeza==null){
            System.out.println("Lista vacia :(");
            return;
        }
        //si la posicion es 0 entonces debe insertarse al inicio
        if (posicion==0) {
            insertarInicio(dato);
            return;
        }
        //encuentra la posicion del nodo a insertar
        for (int i = 0; i < posicion-1; i++) {                      
            actual = actual.siguiente;          
        }
        //inserta el nuevo nodo en la posicion
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;       
    }

    public void eliminarInicio(){
        //verifica que la lista este vacia
        if(cabeza==null){
            System.out.println("Lista vacia :(");
            return;
        }
        //remplaza el nodo inicial por el siguiente nodo y el nodo inicial se pierde
        cabeza = cabeza.siguiente;
    }


    public void eliminarFinal(){
        Nodo actual= cabeza;
        Nodo anterior = null;

        //busca el ultimo nodo y el nodo anterior a este
        while(actual.siguiente!=null){
            anterior = actual;
            actual = actual.siguiente;       
        }
        //elimina el ultimo nodo haciendo que el nodo anterior apunte a null
        anterior.siguiente = null;
    }

    public void eliminarValor(int posicion){
        Nodo actual= cabeza;
        Nodo anterior = null;
        
        
        if(cabeza==null){
            System.out.println("Lista vacia :(");
            return;
        }
        //busca el nodo que contiene el valor a eliminar y el nodo anterior a este
        for(int i=0; i< posicion-1; i++){
            anterior = actual;
            actual = actual.siguiente;  
        }
        
        if(actual.siguiente==null){
            eliminarInicio();
            return;
        }
        
        
        anterior.siguiente = actual.siguiente;
        
    }
}
