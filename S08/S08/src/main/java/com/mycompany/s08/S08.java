package com.mycompany.s08;

import java.util.Scanner;

public class S08 {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        ListaEnlazada lista= new ListaEnlazada();
        ListaEnlazada lista2= new ListaEnlazada();
        lista2.insertarFinal(2);
        lista2.insertarFinal(4);
        lista2.insertarFinal(6);
        lista2.insertarFinal(8);
                
        while(true){
            System.out.println("1) Insertar al inicio");
            System.out.println("2) Insertar al final");
            System.out.println("3)Insertar por posicion");
            System.out.println("4)Eliminar al inicio");
            System.out.println("5)Eliminar al final");
            System.out.println("6)Eliminar por posicion");
            System.out.println("7)Invertir lista");
            System.out.println("8)Detectar ciclo");
            System.out.println("9)Fusionar listas");
            System.out.println("10) Mostrar lista");
            System.out.println("Escoge una opcion: ");
            int opcion= scan.nextInt();
            int dato;
            int posicion;
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el numero a ingresar");
                    dato= scan.nextInt();
                    lista.insertarInicio(dato);
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break;
                case 2:
                    System.out.println("Ingrese el numero a ingresar");
                    dato= scan.nextInt();
                    lista.insertarFinal(dato);
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break; 
                case 3:
                    System.out.println("Ingrese el numero a ingresar");
                    dato= scan.nextInt();
                    System.out.println("Ingrese la posicion");
                    posicion= scan.nextInt();
                    lista.insertarValor(dato,posicion);
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break;   
                case 4:
                    lista.eliminarInicio();
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break; 
                case 5:
                    lista.eliminarFinal();
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break;
                case 6:
                    System.out.println("Que posicion desea eliminar");
                    posicion= scan.nextInt();
                    lista.eliminarValor(posicion);
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break;
                case 7:
                    lista.invertir();  
                    System.out.println("Estado de lista: ");
                    lista.mostrarLista();
                    break; 
                case 8: 
                    boolean tieneCiclo = lista.tieneCiclo();
                    System.out.println(tieneCiclo ? "La lista TIENE ciclo" : "La lista NO tiene ciclo");
                    break;
                    
                case 9: 
                        System.out.println("Fusionando listas ordenadas...");
                        ListaEnlazada resultado = new ListaEnlazada();
                        resultado = lista.fusionar(lista, lista2);
                        System.out.print("Lista 1: ");
                        lista.mostrarLista();
                        System.out.print("Lista 2: ");
                        lista2.mostrarLista();
                        System.out.print("Resultado fusionado: ");
                        resultado.mostrarLista(); 
                    break;           
                case 10: 
                    lista.mostrarLista();
                default:
                    System.out.println("No hay esa opcion");
            }

        } 
        
    }
}