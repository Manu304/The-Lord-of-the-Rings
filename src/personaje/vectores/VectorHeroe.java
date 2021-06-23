package src.personaje.vectores;

import src.juego.ToolMR;
import src.personaje.heroes.Elfo;
import src.personaje.heroes.Heroe;
import src.personaje.heroes.Hobbit;
import src.personaje.heroes.Humano;

public class VectorHeroe {
    private final String[] nombres = {"MOR", "KRY", "PET", "HOL", "TRE", "LOP", "QUE", "KYT"};
    private Heroe[] ejercitoHeroes;

    public VectorHeroe(int cantidad){
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

    public void mostrarHeroes(){
        VectorPersonaje.mostrarEjercitos(ejercitoHeroes, "HEORES");
    }
    /*
    public void mostrarHeroes(){
        System.out.println(ToolMR.margenes(16) + "EJERCITO DE HEROES" + ToolMR.margenes(16));
        System.out.println("No.   NOMBRE      VIDA    ARMADURA     ESPECIE");
        System.out.println(ToolMR.margenes(50));
        for (int i = 0; i < ejercitoHeroes.length; i++) {
            System.out.println((i+1) + "     " + ejercitoHeroes[i]);
        }
        System.out.println(ToolMR.margenes(50));
    }
    */

    public Heroe seleccionar(int indice){
        return ejercitoHeroes[indice];
    }
    
    public void quitarMuerto(){
        VectorPersonaje.eliminarVacios(ejercitoHeroes);
    }
}
