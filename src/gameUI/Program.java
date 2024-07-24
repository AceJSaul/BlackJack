package gameUI;

import gameLogic.Baralho;
import gameLogic.Carta;

public class Program {

    public static void main(String[] args){

        Baralho baralho = new Baralho();
        Carta cartaPuxada = baralho.drawCard();
        System.out.println(cartaPuxada);
        System.out.println(cartaPuxada.getValorDaCarta().value);


    }
}
