package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P12ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> original = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> people = new ArrayList<>(original);

        List<String> filtered = new ArrayList<>();

        while (true) {
            String commandInput = reader.readLine();

            if (commandInput.equalsIgnoreCase("Print")) {
                System.out.println(people
                        .stream()
                        .filter(str -> !str.equalsIgnoreCase(""))
                        .collect(Collectors.toList())
                        .toString()
                        .replaceAll("[\\[\\],]", ""));
                break;
            }

            String[] tokens = commandInput.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            String filterParameter = tokens[2];

            Predicate<String> startsWith = str -> str.subSequence(0, filterParameter.length()).equals(filterParameter);
            Predicate<String> endsWith = str -> str.subSequence(str.length() - filterParameter.length(), str.length()).equals(filterParameter);
            Predicate<String> contains = str -> str.contains(filterParameter);
            Predicate<String> length = str -> str.length() == Integer.parseInt(filterParameter);

            if (command.equalsIgnoreCase("Add filter")) {
                if (filterType.equalsIgnoreCase("Starts with")) {
                    addFilter(people, filtered, startsWith);
                } else if (filterType.equalsIgnoreCase("Ends with")) {
                    addFilter(people, filtered, endsWith);
                } else if (filterType.equalsIgnoreCase("Length")) {
                    addFilter(people, filtered, length);
                } else if (filterType.equalsIgnoreCase("Contains")) {
                    addFilter(people, filtered, contains);
                }
            } else if (command.equalsIgnoreCase("Remove filter")) {
                if (filterType.equalsIgnoreCase("Starts with")) {
                    removeFilter(original, people, filtered, startsWith);
                } else if (filterType.equalsIgnoreCase("Ends with")) {
                    removeFilter(original, people, filtered, endsWith);
                } else if (filterType.equalsIgnoreCase("Length")) {
                    removeFilter(original, people, filtered, length);
                } else if (filterType.equalsIgnoreCase("Contains")) {
                    removeFilter(original, people, filtered, contains);
                }
            }
        }
    }

    private static void removeFilter(List<String> original, List<String> people, List<String> filtered, Predicate<String> predicate) {
        for (int i = 0; i < filtered.size(); i++) {
            if (predicate.test(filtered.get(i))){
                people.set(original.indexOf(filtered.get(i)), filtered.get(i));
            }
        }
    }

    private static void addFilter(List<String> people, List<String> filtered, Predicate<String> predicate) {
        for (int i = 0; i < people.size(); i++) {
            if (!people.get(i).equalsIgnoreCase("") && predicate.test(people.get(i))){
                filtered.add(people.get(i));
                people.set(i, "");
            }
        }
    }
}
