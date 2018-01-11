package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class P09StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        LinkedHashMap<String, ArrayList<Integer>> studentsByMarks = new LinkedHashMap<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String facultyNumber = input[0];
            studentsByMarks.putIfAbsent(facultyNumber, new ArrayList<>());
            for (int i = 1; i < input.length; i++) {
                studentsByMarks.get(facultyNumber).add(Integer.parseInt(input[i]));
            }
            input = reader.readLine().split("\\s+");
        }

        studentsByMarks.entrySet().stream()
                .filter(kv -> (kv.getKey().endsWith("14") || kv.getKey().endsWith("15")))
                .forEach(kv -> System.out.println(kv.getValue().toString().replaceAll("[\\[\\],]", "")));
    }
}
