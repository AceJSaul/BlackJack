package gameUI;

import gameLogic.*;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Dealer gameDealer = new Dealer();
        User gamePlayer = new User(500);
        Jogo newGame = new Jogo(gamePlayer, gameDealer);
        boolean wantToPlay = true;

        while (wantToPlay){
            try{
                newGame.startGame(sc);
                System.out.println();
                sc.nextLine();
                System.out.println("Want to play again? (y/n)");
                char userResponse = sc.nextLine().toLowerCase().charAt(0);

                if(userResponse != 'y'){
                    wantToPlay = false;
                }
                System.out.println();
            }
            catch(GameLogicException e){
                System.out.print(e.getMessage());
            }

        }
    }
}
