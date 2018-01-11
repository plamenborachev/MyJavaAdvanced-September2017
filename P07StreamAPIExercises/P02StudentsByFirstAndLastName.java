package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P02StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        LinkedList<String> studentsByName = new LinkedList<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String firstName = input[0];
            String lastName = input[1];

            studentsByName.add(firstName + " " + lastName);

            input = reader.readLine().split("\\s+");
        }

        studentsByName.stream()
                .filter(student -> (student.split("\\s+")[0].compareTo(student.split("\\s+")[1]) < 0))
                .sorted()
                .forEach(student -> System.out.println(student));
    }
}
