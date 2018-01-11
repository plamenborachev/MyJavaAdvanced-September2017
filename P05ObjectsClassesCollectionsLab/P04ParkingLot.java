package P05ObjectsClassesCollectionsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P04ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(", ");

        HashSet<String> parking = new HashSet<>();

        while (!input[0].equals("END")) {
            String direction = input[0];
            String carNumber = input[1];

            if (direction.equals("IN")) {
                parking.add(carNumber);
            } else if (direction.equals("OUT")) {
                parking.remove(carNumber);
            }
            input = reader.readLine().split(", ");
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }
    }
}
