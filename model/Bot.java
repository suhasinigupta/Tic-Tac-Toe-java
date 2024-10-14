package model;

import service.botplayingstrategy.BotPlayingStrategy;
import service.botplayingstrategy.BotPlayingStrategyFactory;

public class Bot extends Player{

    private BotDifficultyLevel botdifficultylevel ;
    public Bot(int id, String name, char symbol, BotDifficultyLevel difficultylevel){
        super(id,name,symbol,PlayerType.BOT) ;
        this.botdifficultylevel=difficultylevel ;
    }

    @Override
    public Move makeMove(Board board){
          return BotPlayingStrategyFactory.getBotPlayingStrategy().makeMove(board, this);
    }
}
