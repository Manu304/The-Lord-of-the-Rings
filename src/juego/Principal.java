package src.juego;

import src.personaje.bestias.Bestia;
import src.personaje.bestias.Orco;
import src.personaje.bestias.Trasgo;
import src.personaje.heroes.Elfo;
import src.personaje.heroes.Heroe;
import src.personaje.heroes.Hobbit;
import src.personaje.vectores.VectorBestia;
import src.personaje.vectores.VectorHeroe;

public class Principal {
    public static void main(String[] args) {
        Principal juego = new Principal();
        /*
        Heroe[] heroes = new Heroe[2];
        Bestia[] bestias = new Bestia[2];
        heroes[0] = new Hobbit("hernesto");
        heroes[1] = new Elfo("Elfo");
        bestias[0] = new Orco("Oco");
        bestias[1] = new Trasgo("Trasgo");
        System.out.println(bestias[1].getVida() + " vida del trasgo");
        System.out.println(bestias[1].getArmadura() + " armadura del trasgo");
        heroes[0].atacar(100, bestias[1]);
        bestias[1].setVida(heroes[0].atacar(100, bestias[1]), heroes[0]);
        System.out.println(bestias[1].getVida() + " vida luego del ataque");
        */
    }

    private Partida partida;
    private VectorBestia ejercitoBestias;
    private VectorHeroe ejercitoHeroes;

    public Principal(){
        menuPrincipal();
    }

    public void menuPrincipal(){
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println();
            System.out.println(ToolMR.margenes(18) + "MENU PRINCIPAL" + ToolMR.margenes(18));
            System.out.println("1) Jugar \n2) Generar nuevos ejercitos \n3) Mostrar Ejercitos actuales \n4) Salir");
            opcion = ToolMR.getEntero("una opción");
            switch (opcion) {
                case 1 -> {nuevaPartida();}
                case 2 -> {generarEjercitos();}
                case 3 -> {mostrarEjercitos();}
                case 4 -> {salir = true; System.out.println("\nVuelve a luchar de nuevo pronto!\n");}
                default -> {System.out.println("\nUps, esa opción no existe :c\n");}
            }
        }
    }

    private void nuevaPartida(){
        compruebaEjercitos();
        if (ejercitoBestias != null) {
            partida = new Partida(ejercitoBestias, ejercitoHeroes);
        }else{
            System.out.println("\nNo se puede jugar si no se tienen ejercitos para hacerlo!\n");
        }
    }

    private void mostrarEjercitos(){
        compruebaEjercitos();
        if (ejercitoBestias != null) {
            ejercitoBestias.mostrarBestias();
            ejercitoHeroes.mostrarHeroes();
        } else {
            System.out.println("\nNo hay nada para mostrar!\n");
        }
    }

    private void generarEjercitos(){
        System.out.println("\n" + ToolMR.margenes(15) + "GENERANDO EJERCITOS" + ToolMR.margenes(15));
        int cantidad = ToolMR.getEntero("la cantidad de miembros para los ejercitos");
        ejercitoBestias = new VectorBestia(cantidad);
        ejercitoHeroes = new VectorHeroe(cantidad);
    }

    private void compruebaEjercitos(){
        if (ejercitoBestias == null || ejercitoHeroes == null) {
            System.out.println("\nNo hay ejercitos para mostrar. Desea generarlos? \n1) Si \n2) No");
            int opcion = ToolMR.getEntero("una opción");
            if (opcion == 1) {
                generarEjercitos();
            }
        }
    }
}