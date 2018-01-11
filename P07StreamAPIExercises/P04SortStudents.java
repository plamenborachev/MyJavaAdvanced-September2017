package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P04SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        List<String> students = new ArrayList<>();

        while(!"END".equalsIgnoreCase(input)){
            students.add(input);

            input = reader.readLine();
        }

        Comparator<String> comparator = (s1, s2) -> s1.split(" ")[1].compareTo(s2.split(" ")[1]);
        comparator = comparator.thenComparing((s1, s2) -> s2.split(" ")[0].compareTo(s1.split(" ")[0]));

        students.stream()
                .sorted(comparator)
                .forEach(st -> System.out.println(st));
    }
}
