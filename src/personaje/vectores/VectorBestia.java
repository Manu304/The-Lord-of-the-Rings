package src.personaje.vectores;

import src.juego.ToolMR;
import src.personaje.bestias.Bestia;
import src.personaje.bestias.Orco;
import src.personaje.bestias.Trasgo;

public class VectorBestia {
    private Bestia[] ejercitoBestias;
    private final String[] nombres = {"bestia1", "bestia2", "bestia3", "bestia4", "bestia5"};

    public VectorBestia(int cantidad){
        ejercitoBestias = new Bestia[cantidad];
        llenarEjercito();
    }

    private void llenarEjercito(){
        for (int i = 0; i < ejercitoBestias.length; i++) {
            int random = ToolMR.aleatorio(0, 1);
            switch (random) {
                case 0 -> {ejercitoBestias[i] = new Orco(nombres[i]);}
                case 1 -> {ejercitoBestias[i] = new Trasgo(nombres[i]);}
                default -> {ejercitoBestias[i] = new Trasgo(nombres[i]);}
            }
        }
    }

    public void quitarMuerto(){
        VectorPersonaje.eliminarVacios(ejercitoBestias);
    }
}
