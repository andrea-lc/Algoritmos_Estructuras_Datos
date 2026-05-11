package com.mycompany.s06;
public class colaArreglo {
    int[] datos;           // arreglo para guardar los elementos
    int frente;            // indice del primer elemento
    int fin;               // indice del ultimo elemento
    int tamanio;           // cantidad de elementos actuales
    int capacidad;         // tamaño maximo del arreglo

    public colaArreglo(int capacidad) {
        this.capacidad = capacidad;  // Guarda el tamaño máximo
        this.datos = new int[capacidad];  // Crea el arreglo vacío
        this.frente = 0;    // Empieza en la posición 0
        this.fin = -1;      // Aún no hay elementos, así que fin está "antes del inicio"
        this.tamanio = 0;   // La cola empieza vacía
    }
    public void mostrar() {
        if (tamanio == 0) {
            System.out.println("(vacío)");
            return;
        }

        for (int i = 0; i < capacidad; i++) {
            System.out.print( datos[i] + " ");
        }
        System.out.println("\n");
    }

    public void enqueue(int valor) {
        if (tamanio == capacidad) {
            return;  // cola llena
        }
        fin++;
        datos[fin] = valor;
        tamanio++;   
    }

    public void dequeue() {
        if (tamanio == 0) {
            System.out.println("Cola vacia");
            return;
        }
                
        // DESPLAZAR todos los elementos una posicion a la izquierda
        for (int i = 0; i < tamanio - 1; i++) {
            datos[i] = datos[i + 1];
        }
        
        // Limpiar la ultima posicion 
        datos[fin] = 0;
        
        // Actualizar contadores
        fin--;
        tamanio--;
        }

    public boolean isempty() {
        return tamanio == 0;
    }

    public int front() {
        if (tamanio == 0) {
            return -1;
        }
        return datos[frente];
    }
}
