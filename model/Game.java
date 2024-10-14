package model;
import exception.InvalidPlayerSizeException;
import exception.InvalidSymbolsException;
import service.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set ;
import java.util.List ;

public class Game {
    private List<Player> players ;
    private List<Move> moves ;
    private Board currentBoard ;
    private GameStatus gamestatus ;
    private int dimension ;
    private List<Board> boards ;
    private WinningStrategy winningStrategy ;

    private Game(Board currentBoard, List<Player> players , WinningStrategy winningStrategy ){
        this.currentBoard=currentBoard ;
        this.players=players ;
        this.winningStrategy=winningStrategy ;
        moves=new ArrayList<>() ;
        gamestatus=GameStatus.IN_PROGRESS ;
        boards=new ArrayList<>() ;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public int getDimension() {
        return dimension;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public GameStatus getGamestatus() {
        return gamestatus;
    }

    public List<Player> getPlayers() {
        return players;
    }
    public Board getCurrentBoard() {
        return currentBoard;
    }
    public List<Move> getMove() {
        return moves;
    }
    public static Builder builder(){
         return new Builder() ;
    }
    public static class Builder{
        private List<Player> players ;
        private Board currentBoard ;
        private int dimension ;
        private WinningStrategy winningStrategy ;

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy=winningStrategy ;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension=dimension ;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players=players ;
            return this;
        }
        public void checkPlayers(){
             if(players.size() != (this.dimension-1)) {
                 throw new InvalidPlayerSizeException("The size of players is not correct") ;
             }
        }
        public void checkSymbols(){
              Set<Character> set=new HashSet<>() ;
              for(Player ply:players){
                    set.add(ply.getSymbol()) ;
              }
              if(set.size() != players.size()){
                  throw new InvalidSymbolsException("Players should have unique symbols") ;
              }
        }
        public void checkDimension(){
             if(dimension<=2 ) {
                 throw new InvalidSymbolsException("Dimension must be greater than 2") ;
             }
        }
        public void validate(){
              checkDimension();
              checkPlayers() ;
              checkSymbols();
        }

        public Game build(){
            validate() ;
            return new Game(new Board(dimension), players, winningStrategy)  ;
        }


    }

}
