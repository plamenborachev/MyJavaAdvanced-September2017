package P02AbstractionExercises;

import java.util.Scanner;

public class P04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];

        fillTheMatrix(scanner, rows, cols, matrix);

        int squaresCount = getSquaresCount(matrix);

        System.out.println(squaresCount);
    }

    private static void fillTheMatrix(Scanner scanner, int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col];
            }
        }
    }

    private static int getSquaresCount(String[][] matrix) {
        int squaresCount = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1])
                        && matrix[row][col].equals(matrix[row + 1][col])
                        && matrix[row][col].equals(matrix[row + 1][col + 1])) {
                    squaresCount++;
                }

            }
        }
        return squaresCount;
    }
}
