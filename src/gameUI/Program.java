package gameUI;

import gameLogic.Baralho;
import gameLogic.Carta;
import gameLogic.Player;

public class Program {

    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        Carta cartaPuxada = baralho.drawCard();
        System.out.println(cartaPuxada);
        System.out.println(cartaPuxada.getValorDaCarta().value);

    }
}
