package src.personaje;

import src.juego.ToolMR;
import src.personaje.bestias.Orco;

public class Personaje {
    private String nombre;
    private int vida, armadura;


    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = ToolMR.aleatorio(50, 70);
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getVida() {
        return vida;
    }


    public void setVida(int danio, Personaje atacante) {
        int defensa = this.armadura;
        if (danio > this.armadura) {
            if (atacante instanceof Orco) {
                defensa -= (int)(defensa*0.10);
            }
            this.vida -= danio - defensa;
        }
    }

    public int atacar(int potencia, Personaje defensor){
        return potencia;
    }

    public int getArmadura() {
        return armadura;
    }
    
    @Override
    public String toString() {
        return nombre + " Vida: " + vida + "Armadura: " + armadura;
    }   
    
}