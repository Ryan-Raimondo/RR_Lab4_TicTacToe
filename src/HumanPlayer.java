import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for a human player in a game of tic-tac-toe.
 */
public class HumanPlayer extends Player {

    /**
     * Constructor for human player.
     * @param name Name of player.
     * @param mark Mark for player.
     */
    public HumanPlayer(String name, char mark){
        super(name, mark);
    }


    /**
     * Makes a move by placing a character on the board. Gets user input for where to place mark.
     * @throws IOException Exception from stdin.readLine()
     */
    protected void makeMove() throws IOException {
        BufferedReader stdin;
        stdin = new BufferedReader(new InputStreamReader(System.in));
        int row, col;

        while(true) {
            System.out.print('\n' + name + ", what row should your next " + mark + " be placed in? ");
            String row_input = stdin.readLine();
            while (row_input == null || row_input.equals("")) {
                System.out.print("Please try again: ");
                row_input = stdin.readLine();
            }
            System.out.print('\n' + name + ", what column should your next " + mark + " be placed in? ");
            String col_input = stdin.readLine();
            while (col_input == null || col_input.equals("")) {
                System.out.print("Please try again: ");
                col_input = stdin.readLine();
            }
            row = Integer.parseInt(row_input);
            col = Integer.parseInt(col_input);

            if (row < 0 || row > 2 && col < 0 || col > 2)
                System.out.println("Selected location is outside board dimensions. Please try again.");
            else if (board.getMark(row, col) != ' ')
                System.out.println("Space is already occupied. Please try again.");
            else
                break;
        }
        board.putMark(row, col, mark);
    }

}
