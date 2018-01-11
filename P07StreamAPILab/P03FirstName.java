package P07StreamAPILab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class P03FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> letters = Arrays.stream(reader.readLine().split("\\s+"))
                .map(s -> s.toLowerCase())
                .collect(Collectors.toList());

        Optional<String> first = names.stream()
                .filter(s -> letters.contains(String.valueOf(s.charAt(0)).toLowerCase()))
                .sorted()
                .findFirst();

        if (first.isPresent()){
            System.out.println(first.get());
        } else {
            System.out.println("No match");
        }
    }
}
