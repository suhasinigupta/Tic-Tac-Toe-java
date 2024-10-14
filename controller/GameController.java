package controller;
import model.Game ;
import model.*;
import service.winningstrategy.WinningStrategy;
import service.winningstrategy.WinningStrategyFactory;
import service.winningstrategy.WinningStrategyName;

import java.util.List ;

public class GameController {

    public Game createGame(List<Player> players , int dimension, WinningStrategyName name){
         return Game.builder().
                 setDimension(dimension).
                 setPlayers(players).
                 setWinningStrategy(WinningStrategyFactory.getWinningStrategy(name,dimension)).build() ;
    }

    public Move makeMove(Game game, Player player){
        return player.makeMove(game.getCurrentBoard()) ;

    }

    public Player checkWinner(Game game ,Move move){

        return game.getWinningStrategy().checkWinner(game.getCurrentBoard(),move) ;
    }

    public GameStatus getGameStatus(Game game){
        return game.getGamestatus() ;
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().displayBoard();
    }

    public void undo(Game game){

    }

    public Game replay(Game game){
        return null ;
    }

    public Game playagain(Game game){
        return Game.builder().
                setDimension(game.getDimension()).
                setPlayers(game.getPlayers()).
                setWinningStrategy(game.getWinningStrategy()).build() ;
    }
}
