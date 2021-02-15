package com.company;


import java.util.ArrayList;

public class Cliente {

    private int documento;
    private String nombre;
    private String tipoDocumento;
    private ArrayList<Producto> pr;


    public Cliente(int documento, String nombre, String tipoDocumento) {
        this.documento = documento;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.pr = new ArrayList<Producto>();

    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void agregarProducto(Producto producto){
        this.pr.add(producto);
    }

    public Producto getProducto(int pos){
        return this.pr.get(pos);
    }
    public void getAllProductos(){
        for (int i = 0;i <this.pr.size(); i++) System.out.println(this.pr.get(i).getNombre());
    }

}

