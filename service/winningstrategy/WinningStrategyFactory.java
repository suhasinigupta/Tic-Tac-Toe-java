package service.winningstrategy;

public class WinningStrategyFactory{

    public static WinningStrategy getWinningStrategy(WinningStrategyName name , int dimension){
        return switch (name){
            case ORDERONEWINNINGSTRATEGY ->  new OrderOneWinningStrategy(dimension) ;
            default -> null ;
        } ;

    }
}
