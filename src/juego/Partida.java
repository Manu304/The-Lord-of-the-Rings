package src.juego;

import src.personaje.bestias.Bestia;
import src.personaje.heroes.Heroe;
import src.personaje.vectores.VectorBestia;
import src.personaje.vectores.VectorHeroe;

public class Partida {
    private VectorBestia bestias;
    private VectorHeroe heroes;
    
    public Partida(VectorBestia bestias, VectorHeroe heroes){
        this.bestias = bestias;
        this.heroes = heroes;
        peleas();
    }

    public void peleas(){
        int contadorRound = 1;
        while (bestias.getCantVivos() > 0 && heroes.getCantVivos() > 0) {
            System.out.println("\n" + ToolMR.margenes(20) + "ROUND " + contadorRound + ToolMR.margenes(20));
            rondaPelea();
            System.out.println(ToolMR.margenes(5) + "DATOS DE PERSONAJES LUEGO DEL ROUND" + contadorRound + ToolMR.margenes(5));
            bestias.mostrarBestias();
            heroes.mostrarHeroes();
            contadorRound++;
        }
        if (bestias.getCantVivos() == 0) {
            System.out.println("\nEl ejercito de bestias ha perdido contra los heroes!\n");
        }else{
            System.out.println("\nEl ejercito de heroes ha perdido contra las bestias!\n");
        }
    }

    private void rondaPelea(){
        Heroe[] disponiblesHeroe = heroes.getLuchadores();
        Bestia[] disponiblesBestia = bestias.getLuchadores();
        for (int i = 0; i < cantPersonajesLuchar(); i++) {
            pelea(disponiblesHeroe[i], disponiblesBestia[i]);
        }
    }

    private int cantPersonajesLuchar(){
        int cantidad;
        if (bestias.getCantVivos() == heroes.getCantVivos()) {
            cantidad = bestias.getCantVivos();
        }else if (bestias.getCantVivos() > heroes.getCantVivos()) {
            cantidad = heroes.getCantVivos();
        }else{
            cantidad = bestias.getCantVivos();
        }
        return cantidad;
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

    private void pelea(Heroe heroe, Bestia bestia){
        String datoHeroe = heroe.getNombre() + "(Vida: " + heroe.getVida() + ")";
        String datoBestia = bestia.getNombre() + "(Vida: " + bestia.getVida() + ")";
        int dadoHeore = tirarDado(2, 0, 100);
        System.out.println("\n" + datoHeroe + " ha tirado sus dos dados. Su ataque será de: " + dadoHeore);

        bestia.setVida(heroe.atacar(dadoHeore, bestia), heroe);
        if (bestia.getVida() != 0) {
            int dadoBestia = tirarDado(1, 0, 90);
            System.out.println(datoBestia + " ha tirado sus dos dados. Su ataque será de: " + dadoBestia);
            heroe.setVida(bestia.atacar(dadoBestia, heroe), bestia);
        }
    }
}
