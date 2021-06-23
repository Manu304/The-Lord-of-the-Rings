package src.personaje.heroes;

import src.personaje.Personaje;
import src.personaje.bestias.Trasgo;

public class Hobbit extends Heroe {

    public Hobbit(String nombre) {
        super(nombre, 200);
    }

    @Override
    public int atacar(int potencia, Personaje defensor) {
        if (defensor instanceof Trasgo) {
            return potencia - 5;
        } else {
            return potencia;
        }
    } 
    
}
