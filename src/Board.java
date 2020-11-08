/**
 * Board class for use with Game.java. Stores state of board, and contains logic for checking board state, as well as
 * displaying board in text.
 * Part of Lab Assignment 2, Exercise 4.
 *
 * @author Ryan Raimondo
 * @version 1.0
 * @since September 25, 2020
 */
public class Board implements Constants {
	/**
	 * Character array to represent the state of a 3x3 board.
	 */
	private char theBoard[][];
	/**
	 * A count of total marks made on the board.
	 */
	private int markCount;

	/**
	 * Constructor for Board object. Creates a 3x3 character array to represent a tic-tac-toe board.
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * Copy constructor to copy another board's state to new one/
	 * @param b Board to copy from.
	 */
	public Board(Board b){
		this.theBoard = b.theBoard;
	}

	/**
	 * Gets the mark at a specified row/column.
	 * @param row The row to check.
	 * @param col The column to check.
	 * @return Char of mark at specified position.
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Places a mark on the Board at the specified row/column.
	 * @param row Row to place mark.
	 * @param col Column to place mark.
	 * @param mark Mark to place. 'X' or 'O'.
	 */
	public void putMark(int row, int col, char mark){
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Checks to see if the boards is full (if there are 9 marks).
	 * @return True if full, false if not full.
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks if X has won on the board.
	 * @return True if X has won, false if not.
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks if O has won on the board.
	 * @return True if O has won, false if not.
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the state of the board in console.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Clears the entire board, setting ever position to blank (space character).
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks the state of the board for a winner.
	 * @param mark The mark to check for a winner.
	 * @return True if mark won, false if not.
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Used as part of display, displays the headers of each column in console.
	 */
	private void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Used as part of display, adds hyphens to create a row.
	 */
	private void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Used as part of display, adds spaces and lines to form the boxes within the grid.
	 */
	private void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
