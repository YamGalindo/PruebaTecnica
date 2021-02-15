package com.company;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

    public void inicio() {

        System.out.println("Bienvenido al gestor de cliente y productos.");
        System.out.println("1. Gestionar clientes.");
        System.out.println("2. Gestionar producto.");
        System.out.println("3. Editar cliente.");
        System.out.println("4. Consultar cliente especifico.");
        System.out.println("5. Lista clientes.");
        System.out.println("6. Finalizar programa.");



    }

    public void gestionCliente(Scanner scanner, ArrayList Cl, ArrayList pr) {

        System.out.println("1. Agregar cliente.");
        System.out.println("2. Eliminar cliente.");
        String caso = scanner.next();

        switch (caso) {
            case ("1"):
                Cl.add(agregarCliente(scanner, pr ));
                break;
            case ("2"):
                removerCliente(scanner, Cl);
                break;

        }

    }

    public void gestionProducto(Scanner scanner, ArrayList<Producto> pr) {

        System.out.println("1. Agregar producto.");
        System.out.println("2. Eliminar producto.");
        String caso = scanner.next();
        switch (caso) {
            case ("1"):
                pr.add(agregarProducto(scanner, pr ));
                break;
            case ("2"):
                removerProducto(scanner, pr);
                break;

        }

    }


    public Cliente agregarCliente(Scanner scanner, ArrayList<Producto> pr) {

        String nombre;
        String tipoDocumento;
        int documento;
        String nProducto;
        boolean agregar = true;
        boolean posible = false;

        System.out.println("Ingrese nombre:");
        nombre = scanner.next();

        System.out.println("Tipo de documento: CC, CE, TI, PASS");
        tipoDocumento = scanner.next();

        System.out.println("Numero de documento:");
        documento = scanner.nextInt();

        Cliente clientetmp = new Cliente(documento, nombre, tipoDocumento);

        System.out.println("Lista de productos disponibles");

        for(int i= 0; i < pr.size(); i++) {
            System.out.println(pr.get(i).getNombre());
        }

        while (agregar){

            System.out.println("Ingrese nombre de producto que desea agregar");
            System.out.println("Si no desea agregar producto ingrese termino.");
            nProducto = scanner.next();
            for(int i= 0; i < pr.size(); i++) {
                if(pr.get(i).getNombre().equals(nProducto)){
                    posible = true;
                }
            }

            if(nProducto.equals("termino")){
                agregar = false;
                break;
            }

            if(posible == true) {
                Producto producto = new Producto(nProducto);
                clientetmp.agregarProducto(producto);
                posible = false;
            }else{
                System.out.println("El producto no existe en la tienda.");
            }

            System.out.println("Si ya acabo ingrese termino.");

        }

        return clientetmp;

    }

    public void removerCliente(Scanner scanner, ArrayList<Cliente> Cl) {
        boolean buscando = true;
        int documento;

        while (buscando) {
            System.out.println("Numero documento: ");
            documento = scanner.nextInt();
            if(documento == -1)break;
             for (int i = 0; i < Cl.size(); i++) {

                if (Cl.get(i).getDocumento() == documento) {
                    Cl.remove(i);
                    buscando = false;
                    System.out.println("Usuario borrado con exito.");
                    break;
                }

            }
            if(buscando)System.out.println("Por favor ingrese documento valido, si ya termino ingrese -1.");

        }


    }

    public void editarCliente(Scanner scanner, ArrayList<Cliente> cl) {
        int documento;
        int respuesta;
        boolean existe = false;
        String tmp;
        int tmpD;
        int posicion = 0;

        while(true) {
            System.out.println("Ingrese documento de cliente a editar, si ya acabo ingrese -1:");
            documento = scanner.nextInt();
            if(documento == -1){
                break;
            }

            for (int i = 0; i < cl.size(); i++) {
                if (cl.get(i).getDocumento() == documento) {
                    existe = true;
                    posicion = i;
                }
            }
            if(existe){
                System.out.println("Que valor desea modificar: 1. nombre 2. documento");
                respuesta = scanner.nextInt();

                switch (respuesta){
                    case(1):
                        System.out.println("Ingrese nuevo nombre:");
                        tmp = scanner.next();
                        cl.get(posicion).setNombre(tmp);
                        break;
                    case(2):
                        System.out.println("Ingrese nuevo documento:");
                        tmpD = scanner.nextInt();
                        cl.get(posicion).setDocumento(tmpD);
                        break;
                }
            }else{
                System.out.println("El usuario no existe.");
            }
        }

    }

    public Producto agregarProducto(Scanner scanner, ArrayList<Producto> pr) {

        String nombre;
        System.out.println("Ingrese nombre:");
        nombre = scanner.next();

        Producto productotmp = new Producto(nombre);

        return productotmp;

    }

    public int removerProducto(Scanner scanner, ArrayList<Producto> pr) {
        boolean buscando = true;
        String nombre;

        while (buscando) {
            System.out.println("Nombre producto:");
            nombre = scanner.next();
            if(nombre.equals("termino"))break;
            for (int i = 0; i < pr.size(); i++) {

                if (pr.get(i).getNombre().equals(nombre)) {
                    pr.remove(i);
                    buscando = false;
                    System.out.println("Producto borrado con exito.");
                    break;
                }
            }
            if(buscando)System.out.println("Por favor ingrese producto valido, si ya termino ingrese termino");
        }
        return -1;
    }

    public void consultaClientes(ArrayList<Cliente> cl){

        for(int i= 0; i < cl.size(); i++) {
            System.out.println("Nombre: " + cl.get(i).getNombre());
            System.out.println("Documento: " + cl.get(i).getDocumento());
            cl.get(i).getAllProductos();
            System.out.println("-------------------");

        }

    }

    public void consultarCliente(Scanner scanner, ArrayList<Cliente> cl){
        String tipoD;
        int documento;
        boolean existe = false;


        while(true) {
            System.out.println("Ingrese tipo de documento: ");
            tipoD = scanner.next();
            System.out.println("Ingrese numero documento: ");
            documento = scanner.nextInt();

            for (int i = 0; i < cl.size(); i++) {
                if ((cl.get(i).getDocumento() == documento) && (cl.get(i).getTipoDocumento().equals(tipoD))) {
                    existe = true;
                    System.out.println(cl.get(i).getNombre());
                    cl.get(i).getAllProductos();

                }
            }
            if(existe){
                break;
            }else{
                System.out.println("Datos no coinciden");
            }
        }
    }

}
