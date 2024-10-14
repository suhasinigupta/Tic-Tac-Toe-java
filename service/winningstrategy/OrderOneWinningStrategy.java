package service.winningstrategy;

import model.Board;
import model.Cell;
import model.Move;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{

    private List<HashMap<Character, Integer>> rowmap;
    private List<HashMap<Character, Integer>> colmap ;
    private List<HashMap<Character, Integer>> firstdiagnol ;
    private List<HashMap<Character, Integer>> secdiagnol ;
    private HashMap<Character,Integer> cormap ;
    private int dimension ;

    public OrderOneWinningStrategy(int dimension){
        rowmap=new ArrayList<>() ;
        colmap=new ArrayList<>() ;
        firstdiagnol=new ArrayList<>() ;
        secdiagnol=new ArrayList<>() ;
        this.dimension=dimension;
        cormap=new HashMap<>() ;
        for(int i=0; i<dimension; i++){
            rowmap.add(new HashMap<>()) ;
            colmap.add(new HashMap<>()) ;
            firstdiagnol.add(new HashMap<>()) ;
            secdiagnol.add(new HashMap<>()) ;
        }
    }
    public Player checkWinner(Board board , Move move) {
        Cell cell=move.getCell() ;
        int i= cell.getRow();
        int j=cell.getCol() ;
        char sym= move.getPlayer().getSymbol() ;
             if  ( checkAndUpdateRowWinner(i,sym) || checkAndUpdateColWinner(j,sym) ||
                        checkfirstdiagWinner(i,j,sym) || checkAndUpdateSecdiagWinner(i,j,sym) ||
                        checkAndUpdateCornerWinner(i,j,sym) ) return move.getPlayer() ;

             return null ;
    }

    private boolean checkAndUpdateRowWinner(int i, char sym){
         HashMap<Character, Integer> rm= rowmap.get(i) ;
         rm.put(sym, rm.getOrDefault(sym,0)+1) ;
         return rm.get(sym)==dimension ;

    }
    private boolean checkAndUpdateColWinner(int j, char sym){
        HashMap<Character, Integer> cm= colmap.get(j) ;
        cm.put(sym, cm.getOrDefault(sym,0)+1) ;
        return cm.get(sym)==dimension ;
    }
    private boolean checkfirstdiagWinner(int i, int j, char sym){
        if(i==j){
            HashMap<Character, Integer> rd= firstdiagnol.get(i) ;
            rd.put(sym, rd.getOrDefault(sym,0)+1) ;
            if(rd.get(sym)==dimension) return true ;
        }
        return false ;
    }
    private boolean checkAndUpdateSecdiagWinner(int i, int j, char sym){
         if((i+j)==dimension-1){
             HashMap<Character, Integer> cd= secdiagnol.get(i) ;
             cd.put(sym, cd.getOrDefault(sym,0)+1) ;
             return (cd.get(sym)==dimension);
         }
         return false ;
    }

    private boolean checkAndUpdateCornerWinner(int i, int j, char sym){
        int r=0 ;
        int c=dimension-1 ;
        boolean flag=false ;
        if(i==0 && j==0){
            cormap.put(sym,cormap.getOrDefault(sym,0)+1) ;
            flag=true ;
        }
        else if(i==0 && j==dimension-1){
            cormap.put(sym,cormap.getOrDefault(sym,0)+1) ;
            flag=true ;
        }
        else if(i==dimension-1 && j==0){
            cormap.put(sym,cormap.getOrDefault(sym,0)+1) ;
            flag=true ;
        }
        else if(i==j && i==dimension-1){
            cormap.put(sym,cormap.getOrDefault(sym,0)+1) ;
            flag=true ;
        }
        if(flag) return cormap.get(sym)==4 ;
        return false ;
    }
}
