package com.mycompany.s08;

public class ListaEnlazada {
    //puntero que siempre apuntara al primer nodo de la lista
    Nodo cabeza;

    //crea la lista pero vacia
    public ListaEnlazada() {
        this.cabeza = null;
    }

    public int cantidadElementos(){
        Nodo actual = cabeza;
        int contador = 0;
        while (actual!=null) {
            actual = actual.siguiente;
            contador++;
        }
        return contador;
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
        //verifica que la posicion no sea mayor a la cantidad de elementos de la lista  
        if (posicion>=(cantidadElementos()-1)) {
            System.out.println("Posicion fuera de rango");
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

        if(cabeza==null){
            System.out.println("Lista vacia :(");
            return;
        }

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
        
        //verifica que la posicion no sea mayor a la cantidad de elementos de la lista  
        if (posicion>=(cantidadElementos()-1)) {
            System.out.println("Posicion fuera de rango");
            return;
        }
        
        if(cabeza==null){
            System.out.println("Lista vacia :(");
            return;
        }
        //busca el nodo anterior al nodo a eliminar 
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
        public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        Nodo siguiente = null;
        
        while (actual != null) {
            
            siguiente = actual.siguiente;  // Guardar el siguiente 2
            actual.siguiente = anterior;   // Invertir el enlace
            anterior = actual;             // Mover anterior al actual 1
            actual = siguiente;            // Mover al siguiente nodo
        }
        
        cabeza = anterior;  // Actualizar la cabeza
    }
    public boolean tieneCiclo() {
        if (cabeza == null) return false;
        
        Nodo lento = cabeza;
        Nodo rapido = cabeza;
        
        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;          // Avanza 1 paso
            rapido = rapido.siguiente.siguiente;  // Avanza 2 pasos
            
            if (lento == rapido) {
                return true;  // Ciclo detectado
            }
        }
        return false;
    }
    public ListaEnlazada fusionar(ListaEnlazada lista1, ListaEnlazada lista2) {
        ListaEnlazada resultado = new ListaEnlazada();
        Nodo p1 = lista1.cabeza;
        Nodo p2 = lista2.cabeza;
        
        // Recorrer ambas listas comparando valores
        while (p1 != null && p2 != null) {
            if (p1.dato <= p2.dato) {
                resultado.insertarFinal(p1.dato);  // Usamos tu método existente
                p1 = p1.siguiente;
            } else {
                resultado.insertarFinal(p2.dato);
                p2 = p2.siguiente;
            }
        }
        
        // Agregar elementos restantes de lista1 (si los hay)
        while (p1 != null) {
            resultado.insertarFinal(p1.dato);
            p1 = p1.siguiente;
        }
        
        // Agregar elementos restantes de lista2 (si los hay)
        while (p2 != null) {
            resultado.insertarFinal(p2.dato);
            p2 = p2.siguiente;
        }
        
        return resultado;
    }
}
