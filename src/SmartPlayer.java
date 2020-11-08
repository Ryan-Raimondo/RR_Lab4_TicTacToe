/**
 * Class that will block an opponent from winning and attempt to win when possible.
 */
public class SmartPlayer extends BlockingPlayer{

    /**
     * Constructor for smart player.
     * @param name Name of player.
     * @param mark Mark for player.
     */
    public SmartPlayer(String name, char mark){
        super(name, mark);
    }

    /**
     * Method to check if player can win on next move, and return true if possible.
     * @param row Row to check.
     * @param col Column to check.
     * @return True if value should be blocked
     */
    protected boolean testForWinning(int row, int col) {
        Board testBoard = new Board();
        char tmp;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                tmp = board.getMark(i, j);
                testBoard.putMark(i, j, tmp);
            }
        }
        testBoard.putMark(row, col, mark);
        if (mark == 'X') {
            if (testBoard.xWins())
                return true;
        }else if (mark == 'O') {
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
        boolean winMove = false;
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                if (board.getMark(row, col) == ' ')
                    winMove = testForWinning(row, col);
                if (winMove)
                    break;
            }
            if (winMove)
                break;
        }
        if (!winMove) {
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
        }
        if (!blockMove && !winMove) {
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
