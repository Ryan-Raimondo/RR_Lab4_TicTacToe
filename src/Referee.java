import java.io.IOException;

/**
 * Class for representing the Referee within a game of Tic-Tac-Toe. The Referee controls the flow of the game.
 * Part of Lab Assignment 2, Exercise 4.
 *
 * @author Ryan Raimondo
 * @version 1.0
 * @since September 25, 2020
 */
public class Referee {

    /**
     * The Player using 'X' as their mark.
     */
    private Player xPlayer;

    /**
     * The Player using 'O' as their mark.
     */
    private Player oPlayer;

    /**
     * The Board that the referee is watching over, and the Players are playing on.
     */
    private Board board;

    /**
     * Basic setter to assign oPlayer.
     * @param oPlayer Player to assign to oPlayer.
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Basic setter to assign xPlayer.
     * @param xPlayer Player to assign to xPlayer.
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    /**
     * Basic setter to assign board.
     * @param board Board ti assign to the Referee.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Sets the opponents of both players, and
     * @throws IOException Exception from stdin.readLine()
     */
    public void runTheGame() throws IOException {
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);

        board.display();
        // Play until player wins or game is tied.
        while(true){
            xPlayer.play();
            oPlayer.play();
        }

    }

}
