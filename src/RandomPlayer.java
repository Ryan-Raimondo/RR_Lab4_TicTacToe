/**
 * Class for representing a random player in tic-tac-toe.
 */
public class RandomPlayer extends Player {


    /**
     * Constructor for random player.
     * @param name Name of player.
     * @param mark Mark for player.
     */
    public RandomPlayer(String name, char mark){
        super(name, mark);
    }

    /**
     * Method to check if game is over, or if player can make a move.
     */
    protected void play(){
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
     * Makes a move by placing a character on the board. Gets user input for where to place mark.
     */
    protected void makeMove() {
        int row, col;
        RandomGenerator random = new RandomGenerator();

        while(true) {
            row = random.discrete(0,2);
            col = random.discrete(0,2);
            if( board.getMark(row, col) == ' ')
                break;
        }
        board.putMark(row, col, mark);
    }
}

