package gameLogic;

import gameLogic.enums.CardValue;
import gameLogic.enums.Naipe;

public class Carta {

    private final CardValue valorDaCarta;
    private final Naipe naipeDaCarta;

    public Carta(CardValue valorDaCarta, Naipe naipeDaCarta) {
        this.valorDaCarta = valorDaCarta;
        this.naipeDaCarta = naipeDaCarta;
    }

    public CardValue getValorDaCarta() {
        return valorDaCarta;
    }

    protected Naipe getNaipeDaCarta() {
        return naipeDaCarta;
    }

    private String cardNumberValue(){
        String cardValor;
        if(valorDaCarta.value != 11 && valorDaCarta.value != 0){
            cardValor = String.valueOf(valorDaCarta.value);
        }
        else{
            cardValor = String.valueOf(valorDaCarta.name().charAt(0));
        }
        return cardValor;
    }

    @Override
    public String toString(){
        return cardNumberValue()+" DE "+ naipeDaCarta;
    }
}
