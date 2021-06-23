package src.personaje;

public enum Especie {
    //HEORES
    ELFO("Elfo"),
    HOBBIT("Hobbit"),
    HUMANO("Humano"),
    //BESTIAS
    ORCO("Orco"),
    TRASGO("Trasgo");

    private String nombre;
    private Especie (String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
}
