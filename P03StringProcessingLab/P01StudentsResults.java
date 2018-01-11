package P03StringProcessingLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" - ");
        String name = input[0];
        double[] results = Arrays.stream(input[1].split(", ")).mapToDouble(Double::parseDouble).toArray();
        double average = (results[0] + results[1] + results[2]) / 3;

        String student = String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", name, results[0], results[1], results[2], average);

        String header = String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");

        System.out.println(header);
        System.out.println(student);
    }
}
