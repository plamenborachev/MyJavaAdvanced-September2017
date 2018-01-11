package P02AbstractionExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P12ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstStarSystem = scanner.nextLine().split(" ");
        String[] secondStarSystem = scanner.nextLine().split(" ");
        String[] thirdStarSystem = scanner.nextLine().split(" ");
        double[] normandyInitialCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        int turns = Integer.parseInt(scanner.nextLine());

        String firstStarSystemName = firstStarSystem[0].toLowerCase();
        double firstStarSystemX = Double.parseDouble(firstStarSystem[1]);
        double firstStarSystemY = Double.parseDouble(firstStarSystem[2]);

        String secondStarSystemName = secondStarSystem[0].toLowerCase();
        double secondStarSystemX = Double.parseDouble(secondStarSystem[1]);
        double secondStarSystemY = Double.parseDouble(secondStarSystem[2]);

        String thirdStarSystemName = thirdStarSystem[0].toLowerCase();
        double thirdStarSystemX = Double.parseDouble(thirdStarSystem[1]);
        double thirdStarSystemY = Double.parseDouble(thirdStarSystem[2]);

        double normandyX = normandyInitialCoordinates[0];
        double normandyY = normandyInitialCoordinates[1];

        checkNormandyLocation(firstStarSystemName, firstStarSystemX, firstStarSystemY, secondStarSystemName, secondStarSystemX, secondStarSystemY, thirdStarSystemName, thirdStarSystemX, thirdStarSystemY, normandyX, normandyY);

        for (int i = 0; i < turns; i++) {
            normandyY++;
            checkNormandyLocation(firstStarSystemName, firstStarSystemX, firstStarSystemY, secondStarSystemName, secondStarSystemX, secondStarSystemY, thirdStarSystemName, thirdStarSystemX, thirdStarSystemY, normandyX, normandyY);
        }

    }

    private static void checkNormandyLocation(String firstStarSystemName, double firstStarSystemX, double firstStarSystemY, String secondStarSystemName, double secondStarSystemX, double secondStarSystemY, String thirdStarSystemName, double thirdStarSystemX, double thirdStarSystemY, double normandyX, double normandyY) {
        if ((firstStarSystemX - 1 <= normandyX && normandyX <= firstStarSystemX + 1)
                &&(firstStarSystemY - 1 <= normandyY && normandyY <= firstStarSystemY + 1)){
            System.out.println(firstStarSystemName);
        } else if ((secondStarSystemX - 1 <= normandyX && normandyX <= secondStarSystemX + 1)
                &&(secondStarSystemY - 1 <= normandyY && normandyY <= secondStarSystemY + 1)){
            System.out.println(secondStarSystemName);
        } else if ((thirdStarSystemX - 1 <= normandyX && normandyX <= thirdStarSystemX + 1)
                &&(thirdStarSystemY - 1 <= normandyY && normandyY <= thirdStarSystemY + 1)){
            System.out.println(thirdStarSystemName);
        } else {
            System.out.println("space");
        }
    }
}
