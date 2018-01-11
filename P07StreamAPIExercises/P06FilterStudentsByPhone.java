package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P06FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        LinkedHashMap<String, String> studentsByPhone = new LinkedHashMap<>();

        while(!"END".equalsIgnoreCase(input[0])){
            String name = input[0] + " " + input[1];
            String phone = input[2];
            studentsByPhone.put(name, phone);

            input = reader.readLine().split("\\s+");
        }

        studentsByPhone.entrySet().stream()
                .filter(kv -> (kv.getValue().startsWith("02") || kv.getValue().startsWith("+3592")))
                .forEach(kv -> System.out.println(kv.getKey()));
    }
}
