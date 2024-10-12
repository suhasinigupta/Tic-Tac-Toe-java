package service.botplayingstrategy;

import exception.GameOverException;
import model.*;

public class RandomPlayingStrategy implements BotPlayingStrategy{
       public Move makeMove(Board board, Player player){
            int dim=board.getDimension() ;
            for(int i=0; i<dim; i++){
                for(int j=0; j<dim; j++){
                    if(board.getMatrix().get(i).get(j).getCellstate()== CellState.EMPTIED){
                        Cell cell= board.getMatrix().get(i).get(j) ;
                        cell.setCellstate(CellState.FILLED);
                        cell.setPlayer(player);
                        return new Move(cell,player) ;
                    }
                }
            }
            throw new GameOverException("There is no more empty cell in the board") ;
       }
}
