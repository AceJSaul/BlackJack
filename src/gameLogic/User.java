package gameLogic;

public class User extends Player{

    private double aposta;
    private double balance;

    public User(double balance) {
        this.balance = balance;
    }

    public double getAposta() {
        return aposta;
    }

    public double getBalance() {
        return balance;
    }

    public void setAposta(double amount){
        if(amount > balance){
            throw new GameLogicException("Saldo insuficiente");
        }
        if(amount <= 0){
            throw new GameLogicException("Aposta não pode ser nula ou negativa");
        }

        this.aposta = amount;
        this.balance -= aposta;
    }

    public void successfulAposta(){
        balance += aposta*2;
        aposta = 0;
    }

    public void failedAposta(){
        aposta = 0;
    }

    @Override
    public String toString(){
        return ("value: " + getValueOfHand() + ", cards: " + cardsOfPlayer);
    }
}
