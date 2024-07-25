package gameLogic;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{

    private List<Baralho> baralhos = new ArrayList<>();

    public Dealer() { // Inicializado com 6 baralhos
        this.baralhos = initializeDecks();
        getFirstHand();
    }

    public List<Baralho> getBaralhos() {
        return baralhos;
    }

    protected void getFirstHand(){
        this.cardsOfPlayer.add(baralhos.getLast().drawCard()); // Two first cards of dealer
        this.cardsOfPlayer.add(baralhos.getLast().drawCard());
        checkHandValue();
        if(haveBlackJack()){
            System.out.println("Dealer got blackjack");
        }
    }

    protected void dealerGamePlan(){
        while(valueOfHand < 17){
            hit();
        }
    }

    protected void hit(){
        Carta cartaPuxada = baralhos.getLast().drawCard();
        addCardToHand(cartaPuxada);
        numberOfCards+=1;
        checkHandValue();
    }

    private List<Baralho> initializeDecks(){
        List<Baralho> dealerDeck = new ArrayList<>();
        for (int i=0; i<6; i++){
            dealerDeck.add(new Baralho());
        }
        return dealerDeck;
    }

    private boolean haveBlackJack(){
        return cardsOfPlayer.getFirst().getValorDaCarta().value == 11 && cardsOfPlayer.getLast().getValorDaCarta().value == 10
                || cardsOfPlayer.getLast().getValorDaCarta().value == 10 && cardsOfPlayer.getFirst().getValorDaCarta().value == 11; // Caso comece com a soma igual a 21
    }

    @Override
    public String toString(){
        return "value: " + valueOfHand + ", cards: " + cardsOfPlayer;
    }
}
