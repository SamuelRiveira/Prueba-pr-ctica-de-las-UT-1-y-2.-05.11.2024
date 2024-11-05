package com.mycompany.pruebapracticasamuel;

public class PruebaPracticaSamuel {

    public static void main(String[] args) {
        
        Herramienta[] herramienta = new Herramienta[3];
        herramienta[0] = new Herramienta("taladro");
        herramienta[1] = new Herramienta("destornillador");
        herramienta[2] = new Herramienta("alicates");
        
        
        Thread hiloActividad1 = new Thread(new Actividad(("A1"), herramienta));
        Thread hiloActividad2 = new Thread(new Actividad(("A2"), herramienta));
        Thread hiloActividad3 = new Thread(new Actividad(("A3"), herramienta));
        
        Thread agente1 = new Thread(new Agente("Agente1", hiloActividad1));
        Thread agente2 = new Thread(new Agente("Agente1", hiloActividad1));
        Thread agente3 = new Thread(new Agente("Agente1", hiloActividad2));
        Thread agente4 = new Thread(new Agente("Agente1", hiloActividad3));
        agente1.start();
    }
}
