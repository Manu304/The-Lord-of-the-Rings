package src.personaje.vectores;

import src.juego.ToolMR;
import src.personaje.heroes.Elfo;
import src.personaje.heroes.Heroe;
import src.personaje.heroes.Hobbit;
import src.personaje.heroes.Humano;

public class VectorHeroe {
    private final String[] nombres = {"MOR", "KRY", "PET", "HOL", "TRE", "LOP", "QUE", "KYT"};
    private Heroe[] ejercitoHeroes;
    private int cantidad;

    public VectorHeroe(int cantidad){
        this.cantidad = cantidad;
        ejercitoHeroes = new Heroe[cantidad];
        llenarEjercito();
    }

    private void llenarEjercito(){
        for (int i = 0; i < ejercitoHeroes.length; i++) {
            int random = ToolMR.aleatorio(0, 2);
            
            switch (random) {
                case 0 -> {ejercitoHeroes[i] = new Elfo(VectorPersonaje.generarNombre(nombres));}
                case 1 -> {ejercitoHeroes[i] = new Hobbit(VectorPersonaje.generarNombre(nombres));}
                case 2 -> {ejercitoHeroes[i] = new Humano(VectorPersonaje.generarNombre(nombres));}
            }
        }
    }

    public Heroe[] getLuchadores(){
        Heroe[] luchadores = new Heroe[this.getCantVivos()];
        int contador = 0;
        for (int i = 0; i < luchadores.length || contador < this.getCantVivos(); i++) {
            if (ejercitoHeroes[i].getVida() > 0) {
                luchadores[contador] = ejercitoHeroes[i];
                contador++;
            }
        }
        return luchadores;
    }

    public int getCantVivos(){
        return VectorPersonaje.getCantVivos(ejercitoHeroes);
    }

    public void mostrarHeroes(){
        VectorPersonaje.mostrarEjercitos(ejercitoHeroes, "HEORES");
    }

    public Heroe seleccionar(int indice){
        return ejercitoHeroes[indice];
    }
    
    public void quitarMuerto(){
        VectorPersonaje.eliminarVacios(ejercitoHeroes);
    }

    public int getCantidad(){
        return this.cantidad;
    }
}
