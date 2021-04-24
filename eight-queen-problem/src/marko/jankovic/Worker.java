package marko.jankovic;

public class Worker {
    public boolean solve(int[] board) {
        for (int i = 0; i < board.length; i++) {
            if (checkRow(board)) {
                return false;
            } else if (checkDiagonal(board)) {
                return false;
            } else if (checkRDiagonal(board)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] == board[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonal(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i + board[i] == j + board[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkRDiagonal(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i] - i == board[j] - j && i != j) {
                    return true;
                }
            }
        }
        return false;
    }
}
