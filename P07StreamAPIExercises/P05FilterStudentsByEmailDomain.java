package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P05FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        LinkedHashMap<String, String> studentsByEmail = new LinkedHashMap<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String name = input[0] + " " + input[1];
            String email = input[2];
            studentsByEmail.put(name, email);

            input = reader.readLine().split("\\s+");
        }

        String domain = "@gmail.com";

        studentsByEmail.entrySet().stream()
                .filter(kv -> kv.getValue().contains(domain))
                .forEach(kv -> System.out.println(kv.getKey()));
    }
}
