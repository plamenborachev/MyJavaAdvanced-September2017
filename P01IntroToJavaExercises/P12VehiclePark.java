package P01IntroToJavaExercises;

import java.util.ArrayList;
import java.util.Scanner;

public class P12VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputVehicles = scanner.nextLine().split(" ");

        ArrayList<String> vehicles = new ArrayList<>();

        for (int i = 0; i < inputVehicles.length; i++) {
            vehicles.add(inputVehicles[i]);
        }

        String request = scanner.nextLine();

        int vehiclesSold = 0;

        while(!request.equals("End of customers!")){
            String[] requestTokens = request.split(" ");

            String vehicleType = requestTokens[0];
            String numberOfSeats = requestTokens[2];

            String vehicleWanted = vehicleType.toLowerCase().charAt(0) + numberOfSeats;

            boolean vehicleIsSold = false;

            for (int i = 0; i < vehicles.size(); i++) {
                String currentVehicle = vehicles.get(i);
                if (currentVehicle.equals(vehicleWanted)){
                    int price = currentVehicle.charAt(0) * Integer.parseInt(currentVehicle.substring(1));
                    System.out.printf("Yes, sold for %d$", price);
                    System.out.println();
                    vehicleIsSold = true;
                    vehiclesSold++;
                    vehicles.remove(currentVehicle);
                    break;
                }
            }

            if (!vehicleIsSold){
                System.out.println("No");
            }

            request = scanner.nextLine();
        }

        System.out.println("Vehicles left:" + vehicles.toString().replace('[', ' ').replace(']', ' '));
        System.out.printf("Vehicles sold: %d", vehiclesSold);
    }
}
