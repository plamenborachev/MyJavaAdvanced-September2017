package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class P08WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        LinkedHashMap<String, ArrayList<Integer>> studentsByMarks = new LinkedHashMap<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String name = input[0] + " " + input[1];
            studentsByMarks.putIfAbsent(name, new ArrayList<>());
            for (int i = 2; i < input.length; i++) {
                studentsByMarks.get(name).add(Integer.parseInt(input[i]));
            }

            input = reader.readLine().split("\\s+");
        }

        studentsByMarks.entrySet().stream()
                .filter(e-> e.getValue().stream().filter(k -> k <= 3).collect(Collectors.toList()).size() >= 2)
                .forEach(s -> System.out.println(s.getKey()));
    }
}
