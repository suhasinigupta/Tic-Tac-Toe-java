import controller.GameController;
import model.*;
import service.winningstrategy.OrderOneWinningStrategy;
import service.winningstrategy.WinningStrategy;
import service.winningstrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
          System.out.println("Welcome to TIC TAC TOE Game");
        System.out.println("Please enter the dimension of board") ;
        Scanner sc=new Scanner(System.in) ;

        int dimension=sc.nextInt() ;
        int id=1 ;
        List<Player> playersList=new ArrayList<>() ;
        System.out.println("Do You require bot :Y or N" );
        String status=sc.next();
        if (status.equalsIgnoreCase("Y")){
            Player bot=new Bot(id++, "CHITTI",'B', BotDifficultyLevel.HARD) ;
            playersList.add(bot) ;
        }
        while(id < dimension){
            System.out.println("Enter the name of player") ;
            String name=sc.next() ;
            System.out.println("Enter the symbol of player") ;
            char c=sc.next().charAt(0) ;
            playersList.add(new Player(id++, name,c, PlayerType.HUMAN)) ;
        }
        GameController controller=new GameController() ;
        Game game= controller.createGame(playersList,dimension, WinningStrategyName.ORDERONEWINNINGSTRATEGY) ;
        play(playersList,controller, dimension, game) ;
        System.out.println("Do you want to replay: Y or N") ;
        String res= sc.next() ;

    }

    public static void play(List<Player> playersList, GameController controller, int dimension, Game game) {
        Collections.shuffle(playersList) ;
        int idx=-1 ;
        while(game.getGamestatus().equals(GameStatus.IN_PROGRESS)){
            game.getCurrentBoard().displayBoard();
            idx++ ;
            idx=idx%playersList.size() ;
            Move move= controller.makeMove(game,playersList.get(idx)) ;
            Player winner=controller.checkWinner(game, move) ;
            game.getMove().add(move) ;
            //  game.getBoards().add(game.getCurrentBoard()) ;
            if(winner != null){
                System.out.println("Winner is: "+winner.getName()) ;
            }
            if(game.getMove().size()==dimension*dimension){
                System.out.println("Game is DRAW") ;
                break ;
            }

        }
        System.out.println("Final Board Status: ") ;
        controller.displayBoard(game);
        System.out.println("Do you want to replay: Y or N") ;
        Scanner sc=new Scanner(System.in) ;
        String res= sc.next() ;
        while(res.equalsIgnoreCase("Y")){
            play(playersList,controller,dimension, controller.playagain(game)) ;
        }
    }
}
