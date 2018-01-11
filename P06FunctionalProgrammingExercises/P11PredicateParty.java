package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String command = reader.readLine();

        while(!command.equalsIgnoreCase("Party!")){
            String[] tokens = command.split("\\s+");
            String action = tokens[0];
            String option = tokens[1];
            String criteria = tokens[2];

            Predicate<String> startsWith = str -> str.subSequence(0, criteria.length()).equals(criteria);
            Predicate<String> endsWith = str -> str.subSequence(str.length() - criteria.length(), str.length()).equals(criteria);
            Predicate<String> length = str -> str.length() == Integer.parseInt(criteria);

            if (action.equalsIgnoreCase("Double")){
                if (option.equalsIgnoreCase("StartsWith")){
                    for (int i = 0; i < people.size(); i++) {
                        if (startsWith.test(people.get(i))){
                            people.add(i + 1, people.get(i));
                            i++;
                        }
                    }
                } else if (option.equalsIgnoreCase("EndsWith")){
                    for (int i = 0; i < people.size(); i++) {
                        if (endsWith.test(people.get(i))){
                            people.add(i + 1, people.get(i));
                            i++;
                        }
                    }
                } else if (option.equalsIgnoreCase("Length")){

                    for (int i = 0; i < people.size(); i++) {
                        if (length.test(people.get(i))){
                            people.add(i + 1, people.get(i));
                            i++;
                        }
                    }
                }
            } else if (action.equalsIgnoreCase("Remove")){
                if (option.equalsIgnoreCase("StartsWith")){
                    for (int i = 0; i < people.size(); i++) {
                        if (startsWith.test(people.get(i))){
                            people.remove(i);
                            i--;
                        }
                    }
                } else if (option.equalsIgnoreCase("EndsWith")){
                    for (int i = 0; i < people.size(); i++) {
                        if (endsWith.test(people.get(i))){
                            people.remove(i);
                            i--;
                        }
                    }
                } else if (option.equalsIgnoreCase("Length")){
                    for (int i = 0; i < people.size(); i++) {
                        if (length.test(people.get(i))){
                            people.remove(i);
                            i--;
                        }
                    }
                }
            }
            command = reader.readLine();
        }
        if (!people.isEmpty()){
            System.out.println(people.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }
}
