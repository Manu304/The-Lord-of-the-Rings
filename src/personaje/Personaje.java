package src.personaje;

import src.juego.ToolMR;

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


    public void setVida(int vida) {
        this.vida = vida;
    }


    public int getArmadura() {
        return armadura;
    }


    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    
}