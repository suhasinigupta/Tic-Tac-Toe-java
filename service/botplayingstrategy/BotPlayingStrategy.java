package service.botplayingstrategy;

import model.Board;
import model.Move;
import model.Player;

public interface BotPlayingStrategy {

    Move makeMove(Board board, Player player) ;
}
