package gameLogic;

import gameLogic.enums.CardValue;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private int numberOfCards;
    private int valueOfHand;
    private List<Carta> cardsOfPlayer = new ArrayList<>();

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public List<Carta> getCardsOfPlayer() {
        return cardsOfPlayer;
    }

    private void checkHandValue(){
        int handValue = 0;
        boolean isAWorth11 = true;
        boolean playerCardsContainsA = false;
        for (Carta carta : cardsOfPlayer){
            handValue += carta.getValorDaCarta().value;
            if (carta.getValorDaCarta().value == 11){
                isAWorth11 = false;
            }
            if (carta.getValorDaCarta() == CardValue.A){
                playerCardsContainsA = true;
            }
        }
        if (!isAWorth11 && playerCardsContainsA){
            handValue-=10;
        }
        valueOfHand = handValue;
    }

    private void addCardToHand(Carta carta){
        cardsOfPlayer.add(carta);
    }

    protected Carta hit(Baralho baralho){
        Carta cartaPuxada = baralho.drawCard();
        addCardToHand(cartaPuxada);
        numberOfCards+=1;
        checkHandValue();

        return cartaPuxada;
    }

    protected boolean stand(){
        return true;
    }
}
