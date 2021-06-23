package src.personaje.vectores;

import src.juego.ToolMR;
import src.personaje.bestias.Bestia;
import src.personaje.bestias.Orco;
import src.personaje.bestias.Trasgo;

public class VectorBestia {
    private Bestia[] ejercitoBestias;
    private final String[] nombres = {"PAL", "TRO", "MOT", "TAL", "REP", "YEK", "ZUP", "QUI"};
    private int cantidad;

    public VectorBestia(int cantidad){
        this.cantidad = cantidad;
        ejercitoBestias = new Bestia[cantidad];
        llenarEjercito();
    }

    private void llenarEjercito(){
        for (int i = 0; i < ejercitoBestias.length; i++) {
            int random = ToolMR.aleatorio(0, 1);
            switch (random) {
                case 0 -> {ejercitoBestias[i] = new Orco(VectorPersonaje.generarNombre(nombres));}
                case 1 -> {ejercitoBestias[i] = new Trasgo(VectorPersonaje.generarNombre(nombres));}
            }
        }
    }

    public Bestia[] getLuchadores(){
        Bestia[] luchadores = new Bestia[this.getCantVivos()];
        int contador = 0;
        for (int i = 0; i < luchadores.length || contador < this.getCantVivos(); i++) {
            if (ejercitoBestias[i].getVida() > 0) {
                luchadores[contador] = ejercitoBestias[i];
                contador++;
            }
        }
        return luchadores;
    }

    public int getCantVivos(){
        return VectorPersonaje.getCantVivos(ejercitoBestias);
    }

    public void mostrarBestias(){
        VectorPersonaje.mostrarEjercitos(ejercitoBestias, "BESTIAS");
    }

    public Bestia seleccionar(int indice){
        return ejercitoBestias[indice];
    }

    public void quitarMuerto(){
        VectorPersonaje.eliminarVacios(ejercitoBestias);
    }

    public int getCantidad(){
        return this.cantidad;
    }
}
