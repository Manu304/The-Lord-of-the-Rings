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
                System.out.println(this.nombre + " ha sido atacado por un Orco, su armadura se redujo temporalmente a: " + defensa);
            }
            if (danio - defensa < this.vida) {
                this.vida -= (danio - defensa);
                System.out.println(atacante.getNombre() + " ha golpeado a " + this.getNombre() + " con potencia de: " + danio);
            }else{
                System.out.println("\n" + atacante.getNombre() + " ha matado a " + this.nombre + "!\n");
                this.vida = 0;
            }    
        }else{
            System.out.println("El ataque de " + atacante.getNombre() + " fue absorvido por la armadura de " + this.getNombre());
        }
    }

    public int atacar(int potencia, Personaje defensor){
        return potencia;
    }

    public int getArmadura() {
        return armadura;
    }

    
    
    @Override
    public int hashCode() {
        return this.vida;
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