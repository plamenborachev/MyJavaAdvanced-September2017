package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P03StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        LinkedHashMap<String, Integer> studentsByAge = new LinkedHashMap<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String name = input[0] + " " + input[1];
            int age = Integer.parseInt(input[2]);
            studentsByAge.put(name, age);

            input = reader.readLine().split("\\s+");
        }

        studentsByAge.entrySet().stream()
                .filter(kv -> kv.getValue() >= 18 && kv.getValue() <= 24)
                .forEach(kv -> System.out.println(kv.getKey() + " " + kv.getValue()));


    }
}
