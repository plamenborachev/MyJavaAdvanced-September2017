package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P01StudentsbyGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        HashMap<String, Integer> studentsByGroup = new HashMap<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String name = input[0] + " " + input[1];
            int group = Integer.parseInt(input[2]);
            studentsByGroup.put(name, group);

            input = reader.readLine().split("\\s+");
        }

        studentsByGroup.entrySet().stream()
                .filter(kv -> kv.getValue() == 2)
                .forEach(kv -> System.out.println(kv.getKey()));
    }
}
