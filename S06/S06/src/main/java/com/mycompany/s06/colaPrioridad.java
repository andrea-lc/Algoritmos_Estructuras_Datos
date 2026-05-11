package com.mycompany.s06;

public class colaPrioridad {
    int[] datos;           // arreglo para guardar valores
    int[] prioridades;     // arreglo para guardar prioridades
    int tamanio;           // cantidad de elementos
    int capacidad;         // tamaño maximo

    public colaPrioridad(int capacidad) {
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.prioridades = new int[capacidad];
        this.tamanio = 0;
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

    public void enqueue(int valor, int prioridad) {
        if (tamanio == capacidad) {
            System.out.println("❌ Cola llena");
            return;
        }

        // 🔍 Buscar la posición donde insertar (de mayor a menor prioridad)
        int pos = 0;
        while (pos < tamanio && prioridades[pos] >= prioridad) {
            pos++;
        }
        // 👉 'pos' es donde debe ir el nuevo elemento

        // 🔄 Desplazar elementos a la derecha para hacer espacio
        for (int i = tamanio; i > pos; i--) {
            datos[i] = datos[i - 1];
            prioridades[i] = prioridades[i - 1];
        }

        // 💾 Insertar el nuevo elemento en su posición ordenada
        datos[pos] = valor;
        prioridades[pos] = prioridad;
        tamanio++;
    }

    // ➖ Quitar el primero (siempre el de mayor prioridad)
    public int dequeue() {
        if (tamanio == 0) {
            System.out.println("❌ Cola vacía");
            return -1;
        }
        int valorSacado = datos[0];  // El de mayor prioridad está en [0]
        
        // 🔄 Desplazar todos a la izquierda
        for (int i = 0; i < tamanio - 1; i++) {
            datos[i] = datos[i + 1];
            prioridades[i] = prioridades[i + 1];
        }
        tamanio--;
        return valorSacado;
    }

    public boolean isempty() {
        return tamanio == 0;
    }
}
