package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P12AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int counter = 1;
        HashMap<String, Integer> resources = new HashMap<>();
        String resource = "";

        while(!input.equals("stop")){
            if (counter % 2 != 0){
                resource = input;
            } else {
                Integer quantity = Integer.parseInt(input);
                if (!resources.containsKey(resource)){
                    resources.put(resource, quantity);
                } else {
                    resources.put(resource, resources.get(resource) + quantity);
                }
            }
            counter++;
            input = reader.readLine();
        }

        for (String item: resources.keySet()) {
            System.out.println(item + " -> " + resources.get(item));
        }
    }
}
