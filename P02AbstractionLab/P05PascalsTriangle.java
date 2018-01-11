package P02AbstractionLab;

import java.math.BigInteger;
import java.util.Scanner;

public class P05PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        BigInteger[][] pascalTriangle = new BigInteger[n][n];

        for (int row = 0; row < n; row++) {
            pascalTriangle[row][0] = BigInteger.ONE;
            pascalTriangle[row][row] = BigInteger.ONE;

            if (row > 1) {
                for (int col = 1; col < row; col++) {
                    pascalTriangle[row][col] = pascalTriangle[row - 1][col - 1].add(pascalTriangle[row - 1][col]);
                }
            }

            for (int column = 0; column <= row; column++) {
                System.out.print(pascalTriangle[row][column] + " ");
            }
            System.out.println();
        }
    }
}
