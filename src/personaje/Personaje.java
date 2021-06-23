package src.personaje;

import src.juego.ToolMR;
import src.personaje.bestias.Orco;

public class Personaje {
    private String nombre;
    private int vida, armadura;
    private Especie especie;


    public Personaje(String nombre, int vida, Especie especie) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = ToolMR.aleatorio(50, 70);
        this.especie = especie;
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
        return nombre + "      " + vida + "       " + armadura + ToolMR.espacios(9) + especie;
    }
    
    //No.   NOMBRE      VIDA    ARMADURA     ESPECIE
    //1     TROCRA      350       70         HUMANO
    //2     POMROC      150       50          TRASGO
    //3     PROGTRA     123       66          HUMANO  
}