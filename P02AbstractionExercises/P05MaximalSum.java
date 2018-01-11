package P02AbstractionExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];

        fillTheMatrix(scanner, rows, cols, matrix);

        int maxSum = 0;
        int initialRow = 0;
        int initialCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    initialRow = row;
                    initialCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(matrix, initialRow, initialCol);
    }

    private static void fillTheMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col];
            }
        }
    }

    private static void printMatrix(int[][] matrix, int initialRow, int initialCol) {
        for (int row = initialRow; row < initialRow + 3; row++) {
            for (int col = initialCol; col < initialCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
