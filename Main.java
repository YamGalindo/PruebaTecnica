package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
        ArrayList<Producto> arrayProducto = new ArrayList<Producto>();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        boolean running = true;

        while (running) {
            menu.inicio();
            int dato = sc.nextInt();

            switch (dato) {
                case (1):
                    menu.gestionCliente(sc, arrayCliente, arrayProducto);
                    break;
                case (2):
                    menu.gestionProducto(sc, arrayProducto);
                    break;
                case (3):
                    menu.editarCliente(sc, arrayCliente);
                    break;
                case (4):
                    menu.consultarCliente(sc, arrayCliente);
                    break;
                case (5):
                    menu.consultaClientes(arrayCliente);
                    break;
                case (6):
                    System.out.println("Buen dia");
                    running = false;
                    break;
            }
        }

    }
}
