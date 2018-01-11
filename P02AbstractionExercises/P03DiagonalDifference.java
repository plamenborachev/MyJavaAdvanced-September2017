package P02AbstractionExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillTheMatrix(scanner, size, matrix);

        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix);

        int sumSecondDiagonal = getSumSecondDiagonal(size, matrix);

        int difference = Math.abs(sumPrimaryDiagonal - sumSecondDiagonal);

        System.out.println(difference);
    }

    private static void fillTheMatrix(Scanner scanner, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < size; col++) {
                matrix[row][col] = tokens[col];
            }
        }
    }

    private static int getSumPrimaryDiagonal(int[][] matrix) {
        int sumPrimaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    sumPrimaryDiagonal += matrix[row][col];
                }
            }
        }
        return sumPrimaryDiagonal;
    }

    private static int getSumSecondDiagonal(int size, int[][] matrix) {
        int sumSecondDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row + col == size - 1) {
                    sumSecondDiagonal += matrix[row][col];
                }
            }
        }
        return sumSecondDiagonal;
    }
}
