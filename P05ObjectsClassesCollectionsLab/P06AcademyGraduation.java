package P05ObjectsClassesCollectionsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class P06AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, Double> studentsAverageGrade = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String student = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            double sumOfGrades = 0d;

            for (int j = 0; j < grades.length; j++) {
                sumOfGrades += grades[j];
            }
            double averageGrade = sumOfGrades / grades.length;

            studentsAverageGrade.put(student, averageGrade);
        }

        for (String student: studentsAverageGrade.keySet()) {
            System.out.printf("%s is graduated with %s", student, studentsAverageGrade.get(student));
            System.out.println();
        }
    }
}
