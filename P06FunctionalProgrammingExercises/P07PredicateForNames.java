package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P07PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= n;
        Consumer<String> print = name -> System.out.println(name);

        for (String name : names) {
            if (checkLength.test(name)){
                print.accept(name);
            }
        }
    }
}
