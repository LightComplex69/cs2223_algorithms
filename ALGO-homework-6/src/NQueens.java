import java.util.Arrays;

public class NQueens {

    public boolean isLegalPosition(int[] BOARD, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (BOARD[j] != 0) {
                    // checks same row or diagonal
                    if (BOARD[i] == BOARD[j] || Math.abs(BOARD[i] - BOARD[j]) == j - i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void nextLegalPosition(int[] BOARD, int n) {
        System.out.println("I no work.");
    }

    public void allSolutions() {
        int[] BOARD;

        for (int n = 4; n <= 36; n++) {
            BOARD = new int[n];
            System.out.println("There are " + solve(BOARD, n) + " solutions to the " + n + "-Queens problem");
        }
    }

    private int solve(int[] BOARD, int n) {
        int solutions = 0;
        int row = 0;

        while (row >= 0) {
            if (row == n) {
                solutions++;
                row--;
            } else {
                boolean solFound = false;
                int col = BOARD[row] + 1;

                while (col <= n) {
                    BOARD[row] = col;

                    if (isLegalPosition(BOARD, n)) {
                        solFound = true;
                        row++;
                        break;
                    } else {
                        col++;
                    }
                }

                if (!solFound) {
                    BOARD[row] = 0;
                    row--;
                }
            }
        }

        return solutions;
    }
}
