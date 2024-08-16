package com.clau.gastosapp.objetos;

import java.text.DecimalFormat;

public class Mes {
    private String mes;
    private String descripcion;
    private String estado;
    private Double totalGastos;
    private String idMes;


    public Mes() {
    }

    public Mes(String mes, String descripcion,  Double totalGastos,String estado , String idMes) {
        this.mes = mes;
        this.descripcion = descripcion;
        this.estado = estado;
        this.totalGastos = totalGastos;
        this.idMes = idMes;
    }

    public String getIdMes() {
        return idMes;
    }

    public void setIdMes(String idMes) {
        this.idMes = idMes;
    }

    // Getters
    public String getMes() {
        return mes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public Double getTotalGastos() {
        // Redondear a dos decimales
        return Math.round(totalGastos * 100.0) / 100.0;}

    // Setters
    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTotalGastos(Double totalGastos) {
        this.totalGastos = totalGastos;
    }

    public void setId(String id) {
        this.descripcion = id;
    }

    @Override
    public String toString() {
        return "Mes{" +
                "mes='" + mes + '\'' +
                ", totalGastos=" + totalGastos +
                '}';
    }
}
