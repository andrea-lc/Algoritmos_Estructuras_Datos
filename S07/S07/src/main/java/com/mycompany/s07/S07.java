package com.mycompany.s07;

import java.util.Scanner;

public class S07 {

    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        ListaEnlazada lista= new ListaEnlazada();
                
        while(true){
            System.out.println("1) Insertar al inicio");
            System.out.println("2) Insertar al final");
            System.out.println("3)Insertar por posicion");
            System.out.println("4)Eliminar al inicio");
            System.out.println("5)Eliminar al final");
            System.out.println("6)Eliminar por posicion");
            System.out.println("7) Mostrar lista");
            System.out.println("Escoge una opcion: ");
            int opcion= scan.nextInt();
            int dato;
            int posicion;
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el numero a ingresar");
                    dato= scan.nextInt();
                    lista.insertarInicio(dato);
                    lista.mostrarLista();
                    break;
                case 2:
                    System.out.println("Ingrese el numero a ingresar");
                    dato= scan.nextInt();
                    lista.insertarFinal(dato);
                    lista.mostrarLista();
                    break; 
                case 3:
                    System.out.println("Ingrese el numero a ingresar");
                    dato= scan.nextInt();
                    System.out.println("Ingrese la posicion");
                    posicion= scan.nextInt();
                    lista.insertarValor(dato,posicion);
                    lista.mostrarLista();
                    break;   
                case 4:
                    lista.eliminarInicio();
                    lista.mostrarLista();
                    break; 
                case 5:
                    lista.eliminarFinal();
                    lista.mostrarLista();
                    break;
                case 6:
                    System.out.println("Que posicion desea eliminar");
                    posicion= scan.nextInt();
                    lista.eliminarValor(posicion);
                    lista.mostrarLista();
                    break;
                case 7: 
                    lista.mostrarLista();
                default:
                    System.out.println("No hay esa opcion");
            }
        }       
    }
}