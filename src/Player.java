import java.io.*;

/**
 * Class for representing a player within a game of Tic-Tac-Toe.
 * Part of Lab Assignment 2, Exercise 4.
 *
 * @author Ryan Raimondo
 * @version 1.0
 * @since January 30, 2019
 */
abstract class Player {
    /**
     * Name of the player
     */
    protected String name;

    /**
     * Board object the player is playing on.
     */
    protected Board board;

    /**
     * Name of the opponent of the Player.
     */
    protected Player opponent;

    /**
     * The mark that the Player is using. 'X' or 'O'.
     */
    protected char mark;

    /**
     * Constructor for Player object.
     * @param name Player name
     * @param mark Mark that Player uses.
     */
    public Player(String name, char mark){
        this.name = name;
        this.mark = mark;
    }


    /**
     * Basic getter for getting Player mark.
     * @return mark Player is using.
     */
    public char getMark() {
        return mark;
    }

    /**
     * Basic getter for getting Player name.
     * @return name Player is using.
     */
    public String getName() {
        return name;
    }

    /**
     * Basic getter for getting Board the Player is using.
     * @return Board Player is using.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Basic getter for getting Player's opponent.
     * @return opponent the Player is playing against.
     */
    public Player getOpponent() {
        return opponent;
    }


    protected void setOpponent(Player opponent){
        this.opponent = opponent;
    }

    /**
     * Sets the Board that the Player is playing on.
     * @param theBoard The Board the Player is using.
     */
    protected void setBoard(Board theBoard){
        this.board = theBoard;
    }


    /**
     * Method to check if game is over, or if player can make a move.
     * @throws IOException Exception from stdin.readLine()
     */
    protected void play() throws IOException {
        if (board.isFull() || board.oWins() || board.xWins()) {
            System.out.print("THE GAME IS OVER: ");
            char winningMark = ' ';

            if (board.isFull()){
                System.out.println("The game has ended in a tie!");
                System.exit(0);
            }
            else if (board.oWins())
                winningMark = 'O';
            else if (board.xWins())
                winningMark = 'X';

            if (mark == winningMark)
                System.out.println(name + " is the winner!");
            else
                System.out.println(opponent.name + " is the winner!");
            System.out.println("Game Ended ...");
            System.exit(0);
        }
        else{
            makeMove();
            board.display();
        }
    }

    /**
     * Abstract method for making a move. Implemented in sub-classes.
     * @throws IOException IOException in human player stdin.
     */
    abstract void makeMove() throws IOException;

}
