package gameLogic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {

    private User user;
    private Dealer gameDealer;

    public Jogo(User user, Dealer gameDealer) {
        this.user = user;
        this.gameDealer = gameDealer;
    }

    public void startGame(Scanner sc){
        giveUserInitialCards(); // Dá o deck inicial ao user
        boolean isUserMovement = true;
        boolean haveUserStopped = true; // true se o user parar o jogo por stand, e não por passar de 21
        try{
            // Set aposta
            System.out.println("Your balance: " + user.getBalance());
            System.out.print("Aposta: ");
            double amountOfBet = sc.nextDouble();
            user.setAposta(amountOfBet);
            sc.nextLine();
            System.out.println();

            // Show hands
            System.out.println("Dealer Hand: " + showDealerInitalCard());
            System.out.println("Your hand: " + user);

            // User turn
            while(isUserMovement){
                System.out.println("Type \"Hit\" or \"Stand\"");
                String userMove = sc.nextLine();
                if (!isMoveLegal(userMove)){ // Exception handler
                    throw new GameLogicException("Insira um dado válido");
                }

                if (userMove.equalsIgnoreCase("hit")){
                    giveUserCards();
                }
                else{
                    isUserMovement = false;
                }
                // Check if user passed 21
                if (user.getValueOfHand() > 21){
                    haveUserStopped = false;
                    System.out.println("Your hand: " + user);
                    break;
                }

                System.out.println("Your hand: " + user);
            }
            if (haveUserStopped){
                gameDealer.dealerGamePlan();
                System.out.println("Dealer hand " + gameDealer);
            }

            if(playerWon()){
                System.out.println("You won.");
                System.out.println(user.getBalance());
            }
            else{
                System.out.println("You lost.");
                System.out.println("New balance: " + user.getBalance());
            }

        }
        catch(InputMismatchException e){
            throw new GameLogicException("Deve ser um número");
        }
        catch(GameLogicException e){
            System.out.println(e.getMessage());
        }
        finally{
            user.clearDeck();
            gameDealer.clearDeck();
            gameDealer.getFirstHand(); // Reseta a mão do user e do dealer
        }
    }

    private String showDealerInitalCard(){
        Carta firstCart = gameDealer.cardsOfPlayer.getFirst();
        return firstCart + ", ?";
    }

    private void giveUserInitialCards(){
        user.addCardToHand(gameDealer.getBaralhos().getFirst().drawCard());
        user.addCardToHand(gameDealer.getBaralhos().getLast().drawCard());
    }

    private void giveUserCards(){
        user.addCardToHand(gameDealer.getBaralhos().getFirst().drawCard());
    }

    private boolean isMoveLegal(String userMove){
        return(userMove.equalsIgnoreCase("hit") || userMove.equalsIgnoreCase("stand"));
    }

    private boolean playerWon(){
        if (user.getValueOfHand() <= 21 && user.getValueOfHand() > gameDealer.valueOfHand
        || user.getValueOfHand() <= 21 && gameDealer.valueOfHand > 21){
            user.successfulAposta();
            return true;
        }
        else{
            user.failedAposta();
            return false;
        }
    }
}
