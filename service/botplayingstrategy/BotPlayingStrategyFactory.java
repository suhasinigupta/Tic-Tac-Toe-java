package service.botplayingstrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(){
        return new RandomPlayingStrategy() ;
    }
}
