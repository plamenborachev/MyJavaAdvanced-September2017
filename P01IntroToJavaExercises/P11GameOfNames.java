package P01IntroToJavaExercises;

import java.util.Scanner;

public class P11GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPlayers = Integer.parseInt(scanner.nextLine());

        String winner = null;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < countOfPlayers; i++) {
            String playerName = scanner.nextLine();
            int initialScore = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < playerName.length(); j++) {
                if (playerName.toCharArray()[j] % 2 == 0){
                    initialScore += playerName.toCharArray()[j];
                } else {
                    initialScore -= playerName.toCharArray()[j];
                }
            }

            if (initialScore > bestScore) {
                winner = playerName;
                bestScore = initialScore;
            }
        }

        System.out.printf("The winner is %s - %d points", winner, bestScore);
    }
}
