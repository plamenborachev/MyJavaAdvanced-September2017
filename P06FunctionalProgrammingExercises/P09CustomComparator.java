package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P09CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = (x, y) -> {
            if (x % 2 == 0 && y % 2 != 0) {
                return -1;
            } else if (x % 2 != 0 && y % 2 == 0) {
                return 1;
            }
            return x.compareTo(y);
        };

        numbers.stream()
                .sorted(comparator)
                .forEach(n -> System.out.print(n + " "));
    }
}


