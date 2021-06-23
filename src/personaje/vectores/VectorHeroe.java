package src.personaje.vectores;

import src.juego.ToolMR;
import src.personaje.heroes.Elfo;
import src.personaje.heroes.Heroe;
import src.personaje.heroes.Hobbit;
import src.personaje.heroes.Humano;

public class VectorHeroe {
    private final String[] nombres = {"heroe1", "heroe2", "heroe3", "heroe4", "heroe5"};
    private Heroe[] ejercitoHeroes;

    public VectorHeroe(int cantidad){
        ejercitoHeroes = new Heroe[cantidad];
        llenarEjercito();
    }

    private void llenarEjercito(){
        for (int i = 0; i < ejercitoHeroes.length; i++) {
            int random = ToolMR.aleatorio(0, 2);
            switch (random) {
                case 0 -> {ejercitoHeroes[i] = new Elfo(nombres[i]);}
                case 1 -> {ejercitoHeroes[i] = new Hobbit(nombres[i]);}
                case 2 -> {ejercitoHeroes[i] = new Humano(nombres[i]);}
                default -> {ejercitoHeroes[i] = new Humano(nombres[i]);}
            }
        }
    }
    
    public void quitarMuerto(){
        VectorPersonaje.eliminarVacios(ejercitoHeroes);
    }
}
