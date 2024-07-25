package gameLogic;

import gameLogic.enums.CardValue;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected int numberOfCards;
    protected int valueOfHand;
    protected List<Carta> cardsOfPlayer = new ArrayList<>();


    //Getters
    public int getNumberOfCards() {
        return numberOfCards;
    }

    public int getValueOfHand() {
        return valueOfHand;
    }

    public List<Carta> getCardsOfPlayer() {
        return cardsOfPlayer;
    }

    protected void checkHandValue(){
        int handValue = 0;
        boolean isAWorth11 = true;
        short playerCardsContainsA = 0; // Quantity of Ace cards // Quantidade de Ás
        for (Carta carta : cardsOfPlayer){
            handValue += carta.getValorDaCarta().value;
            if (handValue > 10){
                isAWorth11 = false;
            }
            if (carta.getValorDaCarta() == CardValue.A){
                playerCardsContainsA +=1;
            }
        }
        if (!isAWorth11 && playerCardsContainsA > 1){
            handValue-=10;
        }
        valueOfHand = handValue;
    }

    protected void addCardToHand(Carta carta){
        cardsOfPlayer.add(carta);
        checkHandValue();
    }

    protected void hit(Baralho baralho){
        Carta cartaPuxada = baralho.drawCard();
        addCardToHand(cartaPuxada);
        numberOfCards+=1;
    }

    protected void clearDeck(){
        cardsOfPlayer.clear();
    }

}
