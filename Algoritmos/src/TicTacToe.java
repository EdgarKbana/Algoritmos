public class TicTacToe {
    public static String analyzeBoard(String[][] board) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("X")) {
                    countX++;
                } else if (board[i][j].equals("O")) {
                    countO++;
                }
            }
        }
        if (countX < countO || countX > countO + 1) {
            return "Nulo";
        }
        boolean xWins = checkWin(board, "X");
        boolean oWins = checkWin(board, "O");

        if (xWins && oWins) {
            return "O"; // Ambos ganaron
        } else if (xWins) {
            return "X"; // X ganó
        } else if (oWins) {
            return "O"; // O ganó
        } else if (countX + countO == 9) {
            return "Empate"; // Empate
        } else {
            return "Nulo"; // No hay ganador y la matriz no está llena
        }
    }

    private static boolean checkWin(String[][] board, String player) {
        // Comprobar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if ((board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) ||
                    (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))) {
                return true;
            }
        }
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }

    public static void main(String[] args) {
        String[][] board = {
                {"X", "O", "X"},
                {"O", "X", ""},
                {"", "O", "X"}
        };

        System.out.println(analyzeBoard(board));
    }
}
