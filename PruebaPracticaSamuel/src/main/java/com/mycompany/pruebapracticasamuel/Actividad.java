package com.mycompany.pruebapracticasamuel;

import static java.lang.Math.random;
import java.util.Random;

public class Actividad implements Runnable {
    
    private final String nombreActividad;
    private final Herramienta[] herramienta;
    private final Random random = new Random();
    
    public Actividad(String nombreActividad, Herramienta[] herramienta) {
        this.nombreActividad = nombreActividad;
        this.herramienta = herramienta;
    }

    @Override
    public void run() {
        if (nombreActividad == "A3"){
            try {
                Herramienta[] herramientasSeleccionadas = obtenerHerramientas(3);
                
                int tiempoUso = (random.nextInt(200 - 50) + 1);
                System.out.println(nombreActividad + " usando las Herramientas "
                    + " por " + tiempoUso + " ms.");
                Thread.sleep(tiempoUso);

                // Devuelve los libros
                devolverHerramientas(herramientasSeleccionadas);

                int tiempoDescanso = (random.nextInt(200 - 100) + 1);
                System.out.println(nombreActividad + " descansando por " + tiempoDescanso + " ms.");
                Thread.sleep(tiempoDescanso);
                
            } catch (InterruptedException ex) {}
        }
        else{
            try {
                Herramienta[] herramientasSeleccionadas = obtenerHerramientas(2);
                
                int tiempoUso = (random.nextInt(200 - 50) + 1);
                System.out.println(nombreActividad + " usando las Herramientas "
                    + " por " + tiempoUso + " ms.");
                Thread.sleep(tiempoUso);

                // Devuelve los libros
                devolverHerramientas(herramientasSeleccionadas);

                int tiempoDescanso = (random.nextInt(200 - 100) + 1);
                System.out.println(nombreActividad + " descansando por " + tiempoDescanso + " ms.");
                Thread.sleep(tiempoDescanso);
                
                
            } catch (InterruptedException ex) {}
        }
    }
    
    private synchronized Herramienta[] obtenerHerramientas(int numeroHerramientas) throws InterruptedException {
                
        Herramienta[] seleccionados = new Herramienta[numeroHerramientas];
        
        
        while (true) {
            if (nombreActividad == "A3") {
                int herramienta1Index = 0;
                int herramienta2Index = 1;
                int herramienta3Index = 2;
                
                Herramienta herramienta1 = herramienta[herramienta1Index];
                Herramienta herramienta2 = herramienta[herramienta1Index];
                Herramienta herramienta3 = herramienta[herramienta1Index];
                
                
                if (!herramienta1.estaOcupado() && !herramienta2.estaOcupado()) {
                    herramienta1.usar();
                    herramienta2.usar();
                    seleccionados[0] = herramienta1;
                    seleccionados[1] = herramienta2;
                    System.out.println(nombreActividad + " seleccionó las herramientas "
                            + herramienta1.getNombre() + ", " + herramienta2.getNombre() + " y " + herramienta3.getNombre());
                    return seleccionados;
                } else {
                    System.out.println(nombreActividad + " esperando por las herramientas ");
                    wait();
                }
            }
            
            if (nombreActividad == "A1") {
                int herramienta1Index = 0;
                int herramienta2Index = 1;
                
                Herramienta herramienta1 = herramienta[herramienta1Index];
                Herramienta herramienta2 = herramienta[herramienta1Index];
                
                
                if (!herramienta1.estaOcupado() && !herramienta2.estaOcupado()) {
                    herramienta1.usar();
                    herramienta2.usar();
                    seleccionados[0] = herramienta1;
                    seleccionados[1] = herramienta2;
                    System.out.println(nombreActividad + " seleccionó las herramientas "
                            + herramienta1.getNombre() + " y " + herramienta2.getNombre());
                    return seleccionados;
                } else {
                    System.out.println(nombreActividad + " esperando por las herramientas "
                            + herramienta1.getNombre() + " o " + herramienta2.getNombre());
                    wait();
                }
            }
            
            if (nombreActividad == "A2") {
                int herramienta1Index = 1;
                int herramienta2Index = 2;
                
                Herramienta herramienta1 = herramienta[herramienta1Index];
                Herramienta herramienta2 = herramienta[herramienta1Index];
                
                
                if (!herramienta1.estaOcupado() && !herramienta2.estaOcupado()) {
                    herramienta1.usar();
                    herramienta2.usar();
                    seleccionados[0] = herramienta1;
                    seleccionados[1] = herramienta2;
                    System.out.println(nombreActividad + " seleccionó las herramientas "
                            + herramienta1.getNombre() + " y " + herramienta2.getNombre());
                    return seleccionados;
                } else {
                    System.out.println(nombreActividad + " esperando por las herramientas "
                            + herramienta1.getNombre() + " o " + herramienta2.getNombre());
                    wait();
                }
            }
        }
    }
    
    private synchronized void devolverHerramientas(Herramienta[] herramientasSeleccionadas) {
        if(nombreActividad == "A3"){
            herramientasSeleccionadas[0].devolver();
            herramientasSeleccionadas[1].devolver();
            herramientasSeleccionadas[2].devolver();
            System.out.println(nombreActividad + " devolvió las herramientas " 
                + herramientasSeleccionadas[0].getNombre() + ", " + herramientasSeleccionadas[1].getNombre() + " y " + herramientasSeleccionadas[2].getNombre());
            notifyAll();
        }
        if(nombreActividad == "A2"){
            herramientasSeleccionadas[1].devolver();
            herramientasSeleccionadas[2].devolver();
            System.out.println(nombreActividad + " devolvió las herramientas " 
                + herramientasSeleccionadas[0].getNombre() + " y " + herramientasSeleccionadas[1].getNombre());
            notifyAll();
        }
        if(nombreActividad == "A1"){
            herramientasSeleccionadas[0].devolver();
            herramientasSeleccionadas[1].devolver();
            System.out.println(nombreActividad + " devolvió las herramientas " 
                + herramientasSeleccionadas[0].getNombre() + " y " + herramientasSeleccionadas[1].getNombre());
            notifyAll();
        }
    }
}
