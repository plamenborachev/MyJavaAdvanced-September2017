package P01IntroToJavaExercises;

import java.util.Scanner;

public class P03FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numA = scanner.nextInt();
        double numB = scanner.nextDouble();
        double numC = scanner.nextDouble();

        String numAtoHex = Integer.toHexString(numA).toUpperCase();
        String numAtoBinary = Integer.toBinaryString(numA);
        String numBtoString = String.format("%.2f", numB);
        String numCtoString = String.format("%.3f", numC);

        StringBuilder sb = new StringBuilder();
        sb.append("|" + numAtoHex);
        for (int i = 0; i < (10 - numAtoHex.length()); i++) {
            sb.append(" ");
        }
        sb.append("|");
        for (int i = 0; i < (10 - numAtoBinary.length()); i++) {
            sb.append("0");
        }
        sb.append(numAtoBinary + "|");
        for (int i = 0; i < (10 - numBtoString.length()); i++) {
            sb.append(" ");
        }
        sb.append(numBtoString + "|" + numCtoString);
        for (int i = 0; i < (10 - numCtoString.length()); i++) {
            sb.append(" ");
        }
        sb.append("|");

        System.out.println(sb);
    }
}
