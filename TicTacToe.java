import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    
    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    // Initialize the board with empty spaces
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current state of the board
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Start the game loop
    private static void playGame() {
        boolean gameOngoing = true;
        while (gameOngoing) {
            printBoard();
            playerMove();
            gameOngoing = !checkWin() && !isBoardFull();
            if (gameOngoing) {
                switchPlayer();
            }
        }
        printBoard();
        if (checkWin()) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("The game is a draw!");
        }
    }

    // Handle player move
    private static void playerMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        boolean validMove = false;

        while (!validMove) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                validMove = true;
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
    }

    // Switch to the other player
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Check if the current player has won
    private static boolean checkWin() {
        // Check rows, columns, and diagonals
        return (checkRows() || checkColumns() || checkDiagonals());
    }

    // Check if a row is complete
    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check if a column is complete
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Check if either diagonal is complete
    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Check if the board is full (i.e., the game is a draw)
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}