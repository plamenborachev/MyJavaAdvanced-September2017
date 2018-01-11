package P01IntroToJavaExercises;

import java.util.Scanner;

public class P13BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int blur = Integer.parseInt(scanner.nextLine());
        String[] matrixSize = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);

        long[][] matrix = new long[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Long.parseLong(inputTokens[col]);
            }
        }

        String[] blurCoordinates = scanner.nextLine().split(" ");
        int blurRow = Integer.parseInt(blurCoordinates[0]);
        int blurCol = Integer.parseInt(blurCoordinates[1]);

        for (int row = blurRow - 1; row <= blurRow + 1 ; row++) {
            for (int col = blurCol - 1; col <= blurCol + 1; col++) {
                if (0 <= row && row < matrix.length && 0 <= col && col < matrix[0].length){
                    matrix[row][col] += blur;
                }
            }
        }

        for (long[] row : matrix) {
            for (long element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
