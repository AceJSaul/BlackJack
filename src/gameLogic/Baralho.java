package gameLogic;

import gameLogic.enums.CardValue;
import gameLogic.enums.Naipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

    private List<Carta> cartas = new ArrayList<>();

    public Baralho() {
        baralhoInitializer();
        shuffleCards();
    }

    public Baralho(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public List<Carta> getCartas() {
        return cartas;
    }


    public void shuffleCards(){
        Collections.shuffle(cartas);
    }

    public Carta drawCard(){
        if(cartas.isEmpty()){
            throw new GameLogicException("Sem mais cartas nesse baralho");
        }
        Carta cartaPuxada = cartas.getLast();
        cartas.removeLast();
        return cartaPuxada;
    }

    private void baralhoInitializer(){
        for (Naipe naipe : Naipe.values()){
            for (CardValue cardValue : CardValue.values()){
                cartas.add(new Carta(cardValue, naipe));
            }
        }
    }
}
