package src.personaje.vectores;

import src.juego.ToolMR;
import src.personaje.Personaje;

public abstract class VectorPersonaje {

    public static <T> T [] eliminarVacios (T [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i; j++) {
                if (arreglo[j] != null) {
                    int indice = j-1;
                    if (indice >= 0) {
                        T filaAux = arreglo[j];
                        arreglo[j] = arreglo[indice];
                        arreglo[indice] = filaAux;
                    }
                }
            }

        }
        return arreglo;
    }

    public static String generarNombre(String[] palabras){
        int random = ToolMR.aleatorio(1, palabras.length);
        int random2 = ToolMR.aleatorio(1, palabras.length);
        String parte1 = palabras[random-1];
        String parte2 = palabras[random2-1];
        return parte1+parte2;
    }

    public static void mostrarEjercitos(Personaje[] ejercito, String tipo){
        System.out.println();
        System.out.println(ToolMR.margenes(16) + "EJERCITO DE " + tipo + ToolMR.margenes(16));
        System.out.println("No.   NOMBRE      VIDA    ARMADURA     ESPECIE");
        System.out.println(ToolMR.margenes(50));
        for (int i = 0; i < ejercito.length; i++) {
            System.out.println((i+1) + "     " + ejercito[i]);
        }
        System.out.println(ToolMR.margenes(50));
    }

    
}
