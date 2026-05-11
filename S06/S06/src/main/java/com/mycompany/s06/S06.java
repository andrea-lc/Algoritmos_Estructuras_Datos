/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.s06;

/**
 *
 * @author admin
 */
public class S06 {

    public static void main(String[] args) {
        colaArreglo cola = new colaArreglo(5);
        System.out.println("Cola vacia");
        cola.mostrar();

        System.out.println("Cola con elementos");
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.mostrar();


        System.out.println("Cola despues de un dequeue");
        cola.dequeue();
        cola.mostrar();

        System.out.println("Elemento de la frente: " + cola.front());
        

    
    }
}
