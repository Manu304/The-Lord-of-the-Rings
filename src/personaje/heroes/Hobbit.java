package src.personaje.heroes;

import src.personaje.Especie;
import src.personaje.Personaje;
import src.personaje.bestias.Trasgo;

public class Hobbit extends Heroe {

    public Hobbit(String nombre) {
        super(nombre, 200, Especie.HOBBIT);
    }

    @Override
    public int atacar(int potencia, Personaje defensor) {
        if (defensor instanceof Trasgo) {
            System.out.println(this.getNombre() + " tuvo miedo del Trasgo, su ataque se reduce 5 puntos");
            return potencia - 5;
        } else {
            return potencia;
        }
    } 
    
}
