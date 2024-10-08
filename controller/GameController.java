package controller;
import model.Game ;
import model.*;
import service.WinningStrategy ;
import java.util.List ;

public class GameController {

    public Game createGame(List<Player> players , int dimension, WinningStrategy winningstrategy){
         return null ;
    }

    public Move makeMove(Game game, Player player){
        return null ;
    }

    public Player checkWinner(Move move){
        return null ;
    }

    public GameStatus getGameStatus(Game game){
        return null ;
    }

    public void displayBoard(Game game){

    }

    public void undo(Game game){

    }

    public void replay(Game game){

    }

}
