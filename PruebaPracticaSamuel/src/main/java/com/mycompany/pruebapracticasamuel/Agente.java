package com.mycompany.pruebapracticasamuel;

public class Agente implements Runnable {
    private final String nombreAgente;
    private final Thread nombreActividad;

    public Agente(String nombreAgente, Thread nombreActividad) {
        this.nombreAgente = nombreAgente;
        this.nombreActividad = nombreActividad;
    }

    @Override
    public void run() {
        System.out.println(nombreAgente + "realiza la actividad");
        nombreActividad.start();
    }
}
