package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P04TruckTourFromVideo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPumps = Integer.parseInt((reader.readLine()));
        ArrayDeque<String> allPumps = new ArrayDeque<>();

        for (int i = 0; i < numberOfPumps; i++) {
            allPumps.addLast(reader.readLine());
        }
        int counter = 0;
        while(true){
            long ourFuel = 0L;
            boolean found = true;

            for (String petrolPump: allPumps) {
                long currentFuel = Long.parseLong(petrolPump.split("\\s+")[0]);
                long distance = Long.parseLong(petrolPump.split("\\s+")[1]);
                ourFuel += currentFuel;
                if (ourFuel < distance){
                    found = false;
                    break;
                }
                ourFuel -= distance;
            }

            if (found){
                System.out.println(counter);
                break;
            }
            allPumps.addLast(allPumps.pop());
            counter++;
        }
    }
}
