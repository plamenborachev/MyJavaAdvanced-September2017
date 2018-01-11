package P02AbstractionExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[matrixSize][matrixSize];
        int initialCell = 1;

        if (pattern.equals("A")) {
            fillMatrixA(matrixSize, matrix, initialCell);
        } else if (pattern.equals("B")) {
            fillMatrixB(matrixSize, matrix, initialCell);
        }

        printMatrix(matrix);
    }

    private static void fillMatrixA(int matrixSize, int[][] matrix, int initialCell) {
        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                matrix[row][col] = initialCell;
                initialCell++;
            }
        }
    }

    private static void fillMatrixB(int matrixSize, int[][] matrix, int initialCell) {
        for (int col = 0; col < matrixSize; col++) {
            if (col %2 == 0){
                for (int row = 0; row < matrixSize; row++) {
                    matrix[row][col] = initialCell;
                    initialCell++;
                }
            } else {
                for (int row = matrixSize - 1; row >= 0; row--) {
                    matrix[row][col] = initialCell;
                    initialCell++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
