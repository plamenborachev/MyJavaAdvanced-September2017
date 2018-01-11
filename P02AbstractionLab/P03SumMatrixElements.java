package P02AbstractionLab;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            int[] inputRow = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = inputRow[col];
                sum += matrix[row][col];
            }
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
}
