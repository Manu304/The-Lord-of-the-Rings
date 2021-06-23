package src.personaje.vectores;

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

    
}
