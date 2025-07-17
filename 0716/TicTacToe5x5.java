import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    static void printBoard(char[][] board) {
        System.out.println("\n=== 5x5 井字遊戲 ===");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    static char checkWinner(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - 5; j++) {
                // 橫向
                if (board[i][j] != EMPTY &&
                    board[i][j] == board[i][j+1] &&
                    board[i][j+1] == board[i][j+2] &&
                    board[i][j+2] == board[i][j+3] &&
                    board[i][j+3] == board[i][j+4]) {
                    return board[i][j];
                }
                // 垂直
                if (board[j][i] != EMPTY &&
                    board[j][i] == board[j+1][i] &&
                    board[j+1][i] == board[j+2][i] &&
                    board[j+2][i] == board[j+3][i] &&
                    board[j+3][i] == board[j+4][i]) {
                    return board[j][i];
                }
            }
        }
        // 對角線 ↘
        for (int i = 0; i <= SIZE - 5; i++) {
            for (int j = 0; j <= SIZE - 5; j++) {
                if (board[i][j] != EMPTY &&
                    board[i][j] == board[i+1][j+1] &&
                    board[i+1][j+1] == board[i+2][j+2] &&
                    board[i+2][j+2] == board[i+3][j+3] &&
                    board[i+3][j+3] == board[i+4][j+4]) {
                    return board[i][j];
                }
            }
        }
        // 對角線 ↙
        for (int i = 4; i < SIZE; i++) {
            for (int j = 0; j <= SIZE - 5; j++) {
                if (board[i][j] != EMPTY &&
                    board[i][j] == board[i-1][j+1] &&
                    board[i-1][j+1] == board[i-2][j+2] &&
                    board[i-2][j+2] == board[i-3][j+3] &&
                    board[i-3][j+3] == board[i-4][j+4]) {
                    return board[i][j];
                }
            }
        }
        return EMPTY;
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;

        while (true) {
            printBoard(board);
            System.out.printf("玩家 %c 請輸入 row col: ", currentPlayer);
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (!placePiece(board, row, col, currentPlayer)) continue;

            char winner = checkWinner(board);
            if (winner != EMPTY) {
                printBoard(board);
                System.out.printf("\n 玩家 %c 獲勝！\n", winner);
                break;
            }
            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("\n🤝 平手！");
                break;
            }
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
    }
}