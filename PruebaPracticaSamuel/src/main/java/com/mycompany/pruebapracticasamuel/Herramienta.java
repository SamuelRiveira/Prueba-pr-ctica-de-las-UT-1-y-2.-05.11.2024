package com.mycompany.pruebapracticasamuel;

public class Herramienta {
    private final String nombreHerramienta;
    private boolean ocupado;
    
    public Herramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
        this.ocupado = false;
    }
    
    public synchronized boolean estaOcupado() {
        return ocupado;
    }
    
    public String getNombre() {
        return nombreHerramienta;
    }

    public synchronized void usar() {
        this.ocupado = true;
    }

    public synchronized void devolver() {
        this.ocupado = false;
    }
}
