package P10JavaAdvancedRetakeExam03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P03ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[][] board = new String[8][8];

        for (int i = 0; i < board.length; i++) {
            board[i] = reader.readLine().split("\\|");
        }

        String start = reader.readLine();
        int startRow = Integer.parseInt(start.charAt(0) + "");
        int startCol = Integer.parseInt(start.charAt(1) + "");

        String move = reader.readLine();

        ArrayList<String> takenPieces = new ArrayList<>();
        int invalidMoves = 0;
        int boardOutMoves = 0;

        while (!"END".equalsIgnoreCase(move)) {
            String[] moveTokens = move.split(" -> ");
            String currPos = moveTokens[0];
            int currRow = Integer.parseInt(currPos.charAt(0) + "");
            int currCol = Integer.parseInt(currPos.charAt(1) + "");
            String nextPos = moveTokens[1];
            int nextRow = Integer.parseInt(nextPos.charAt(0) + "");
            int nextCol = Integer.parseInt(nextPos.charAt(1) + "");

            if ((Math.abs(currRow - nextRow) == 2
                    && Math.abs(currCol - nextCol) == 1)
                    || ((Math.abs(currRow - nextRow) == 1
                    && Math.abs(currCol - nextCol) == 2))) {
                if (0 <= nextCol && nextCol <= 7 && 0 <= nextRow && nextRow <= 7) {
                    if (!" ".equalsIgnoreCase(board[nextRow][nextCol])) {
                        takenPieces.add(board[nextRow][nextCol]);
                    }
                } else {
                    boardOutMoves++;
                }
            } else {
                invalidMoves++;
            }
            move = reader.readLine();
        }

        System.out.println("Pieces take: " + takenPieces.toString().replaceAll("[\\[\\]]", ""));
        System.out.println("Invalid moves: " + invalidMoves);
        System.out.println("Board out moves: " + boardOutMoves);
    }
}
