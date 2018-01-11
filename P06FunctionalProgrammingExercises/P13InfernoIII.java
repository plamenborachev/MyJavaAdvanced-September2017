package P06FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P13InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> original = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<String> queue = new ArrayDeque<>();

        while(true){
            String commandInput = reader.readLine();

            if (commandInput.equalsIgnoreCase("Forge")) {
                while(queue.size() > 0){
                    String[] queueTokens = queue.remove().split("\\s+");
                    String action = queueTokens[0];
                    int element = Integer.parseInt(queueTokens[1]);
                    int index = Integer.parseInt(queueTokens[2]);
                    if (action.equalsIgnoreCase("remove")){
                        original.set(index, null);
                    } else if (action.equalsIgnoreCase("add")){
                        original.set(index, element);
                    }
                }
                System.out.println(original
                        .stream()
                        .filter(n -> n != null)
                        .collect(Collectors.toList())
                        .toString()
                        .replaceAll("[\\[\\],]", ""));
                break;
            }

            String[] tokens = commandInput.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            int filterParameter = Integer.parseInt(tokens[2]);

            if (command.equalsIgnoreCase("Exclude")){
                if (filterType.equalsIgnoreCase("Sum Left")){
                    for (int i = 0; i < original.size(); i++) {
                        if ((i == 0 && original.get(i) == filterParameter)
                                || (i > 0 && original.get(i - 1) + original.get(i) == filterParameter)){
                            queue.add("remove " + original.get(i) + " " + i);
                        }
                    }
                } else if (filterType.equalsIgnoreCase("Sum Right")){
                    for (int i = 0; i < original.size(); i++) {
                        if ((i == original.size() - 1 && original.get(i) == filterParameter)
                                || (i < original.size() - 1 && original.get(i) + original.get(i + 1) == filterParameter)){
                            queue.add("remove " + original.get(i) + " " + i);
                        }
                    }
                } else if (filterType.equalsIgnoreCase("Sum Left Right")){
                    for (int i = 0; i < original.size(); i++) {
                        if ((i == 0 && original.get(i) + original.get(i + 1) == filterParameter)
                                || (i == original.size() - 1 && original.get(i - 1) + original.get(i) == filterParameter)
                                || (0 < i && i < original.size() - 1 && original.get(i - 1) + original.get(i) + original.get(i + 1) == filterParameter)){
                            queue.add("remove " + original.get(i) + " " + i);
                        }
                    }
                }
            } else if (command.equalsIgnoreCase("Reverse")){
                if (filterType.equalsIgnoreCase("Sum Left")){
                    for (int i = 0; i < original.size(); i++) {
                        if ((i == 0 && original.get(i) == filterParameter)
                                || (i > 0 && original.get(i - 1) + original.get(i) == filterParameter)){
                            queue.add("add " + original.get(i) + " " + i);
                        }
                    }
                } else if (filterType.equalsIgnoreCase("Sum Right")){
                    for (int i = 0; i < original.size(); i++) {
                        if ((i == original.size() - 1 && original.get(i) == filterParameter)
                                || (i < original.size() - 1 && original.get(i) + original.get(i + 1) == filterParameter)){
                            queue.add("add " + original.get(i) + " " + i);
                        }
                    }
                } else if (filterType.equalsIgnoreCase("Sum Left Right")){
                    for (int i = 0; i < original.size(); i++) {
                        if ((i == 0 && original.get(i) + original.get(i + 1) == filterParameter)
                                || (i == original.size() - 1 && original.get(i - 1) + original.get(i) == filterParameter)
                                || (0 < i && i < original.size() - 1 && original.get(i - 1) + original.get(i) + original.get(i + 1) == filterParameter)){
                            queue.add("add " + original.get(i) + " " + i);
                        }
                    }
                }
            }
        }
    }
}
