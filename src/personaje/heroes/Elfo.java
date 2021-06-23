package src.personaje.heroes;

import src.personaje.Especie;
import src.personaje.Personaje;
import src.personaje.bestias.Orco;

public class Elfo extends Heroe {

    public Elfo(String nombre) {
        super(nombre, 250, Especie.ELFO);
    }

    @Override
    public int atacar(int potencia, Personaje defensor) {
        if (defensor instanceof Orco) {
            System.out.println(this.getNombre() + " ha usado rabia, su ataque aumenta a: " + rabia(potencia));
            return rabia(potencia);
        }else{
            return potencia;
        }
    }

    private int rabia(int base){
        return base + 10;
    }
    
    
}
