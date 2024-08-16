package com.clau.gastosapp.objetos;

public class Gasto {
    private String descripcion;
    private String id;
    private double cantidad;
    private String fecha;
    private String imagenUrl;


    public Gasto() {
    }
    public Gasto(String descripcion, double cantidad, String fecha, String imagenUrl) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.imagenUrl = imagenUrl;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getId() {
        return  id;
    }

}
