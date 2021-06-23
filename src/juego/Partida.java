package src.juego;

import src.personaje.vectores.VectorBestia;
import src.personaje.vectores.VectorHeroe;

public class Partida {
    VectorBestia bestias = new VectorBestia(5);
    VectorHeroe heroes = new VectorHeroe(5);
    
    public Partida(){

    }

    private int tirarDado(int cantidad, int min, int max){
        int dado = ToolMR.aleatorio(min, max);
        int resultado = 0;
        if (cantidad > 1) {
            for (int i = 0; i < cantidad; i++) {
                resultado = ToolMR.aleatorio(min, max);
                if (resultado > dado) {
                    dado = resultado;
                }
            }
        }
        return dado;
    }
}
