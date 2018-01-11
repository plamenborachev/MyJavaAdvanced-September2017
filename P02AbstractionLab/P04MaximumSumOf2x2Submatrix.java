package P02AbstractionLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputRow = scanner.nextLine().split(", ");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(inputRow[col]);
            }
        }

        int[][] submatrix = new int[2][2];

        int bestSum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > bestSum){
                    bestSum = sum;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            submatrix[i][j] = matrix[row + i][col + j];
                        }
                    }
                }
            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(submatrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println(bestSum);
    }
}
