package controller;
import model.Game ;
import model.*;

import java.util.List ;

public class GameController {

    public Game createGame(List<Player> players , int dimension, WinningStrategy winningstrategy){
         return Game.builder().
                 setDimension(dimension).
                 setPlayers(players).
                 setWinningStrategy(winningstrategy).build() ;
    }

    public Move makeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard()) ;

    }

    public Player checkWinner(Move move){
        return null ;
    }

    public GameStatus getGameStatus(Game game){
        return game.getGamestatus() ;
    }

    public void displayBoard(Game game){
           game.getCurrentBoard().displayBoard();
    }

    public void undo(Game game){

    }

    public void replay(Game game){

    }

}
