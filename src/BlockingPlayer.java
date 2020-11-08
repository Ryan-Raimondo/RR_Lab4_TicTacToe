/**
 * Class for a player that will block the opponent from winning when possible.
 */
public class BlockingPlayer extends RandomPlayer {

    /**
     * Random generator.
     */
    protected RandomGenerator random;

    /**
     * Constructor for blocking player.
     * @param name Name of player.
     * @param mark Mark for player.
     */
    public BlockingPlayer(String name, char mark){
        super(name, mark);
    }

    /**
     * Method to check if opponent can win on next move, and block them.
     * @param row Row to check.
     * @param col Column to check.
     * @return True if value should be blocked
     */
    protected boolean testForBlocking(int row, int col) {
        char oppMark = opponent.getMark();
        Board testBoard = new Board();
        char tmp;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                tmp = board.getMark(i, j);
                testBoard.putMark(i, j, tmp);
            }
        }
        testBoard.putMark(row, col, oppMark);
        if (oppMark == 'X') {
            if (testBoard.xWins())
                return true;
        }else if (oppMark == 'O') {
            if (testBoard.oWins())
                return true;
        }
        return false;
    }


    /**
     * Makes a move by placing a character on the board. Gets user input for where to place mark.
     */
    @Override
    public void makeMove() {
        int row = 0, col = 0;
        RandomGenerator random = new RandomGenerator();
        boolean blockMove = false;
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                if (board.getMark(row, col) == ' ')
                    blockMove = testForBlocking(row, col);
                if (blockMove)
                    break;
            }
            if (blockMove)
                break;
        }
        if (!blockMove) {
            while (true) {
                row = random.discrete(0, 2);
                col = random.discrete(0, 2);
                if (board.getMark(row, col) == ' ')
                    break;
            }
        }
        board.putMark(row, col, mark);
    }
}
