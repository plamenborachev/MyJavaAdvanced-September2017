package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        while (!input.equalsIgnoreCase("JOKER")) {

            String[] inputTokens = input.split(": ");
            String name = inputTokens[0];
            String[] cards = inputTokens[1].split(", ");
            HashSet<String> uniqueCards = new HashSet<>(Arrays.asList(cards));

            if (!players.containsKey(name)) {
                players.put(name, uniqueCards);
            } else {
                for (String card : uniqueCards) {
                    players.get(name).add(card);
                }
            }
            input = reader.readLine();
        }

        for (String player : players.keySet()) {
            int totalValue = 0;

            for (String card: players.get(player)) {
                String powerString = card.substring(0, card.length() - 1);
                int power = findCardPower(powerString);
                int typeMultiplier = findTypeMultiplier(card.charAt(card.length() - 1));
                int cardValue = power * typeMultiplier;
                totalValue += cardValue;
            }

            System.out.println(player + ": " + totalValue);
        }
    }

    private static int findCardPower(String powerString) {
        int cardPower = 0;
        try {
            cardPower = Integer.parseInt(powerString);
        } catch (NumberFormatException e) {
            if (powerString.equalsIgnoreCase("J")) {
                cardPower = 11;
            } else if (powerString.equalsIgnoreCase("Q")) {
                cardPower = 12;
            } else if (powerString.equalsIgnoreCase("K")) {
                cardPower = 13;
            } else if (powerString.equalsIgnoreCase("A")) {
                cardPower = 14;
            }
        }
        return cardPower;
    }

    private static int findTypeMultiplier(char c) {
        int typeMultiplier = 0;
        if (c == 'S') {
            typeMultiplier = 4;
        } else if (c == 'H') {
            typeMultiplier = 3;
        } else if (c == 'D') {
            typeMultiplier = 2;
        } else if (c == 'C') {
            typeMultiplier = 1;
        }
        return typeMultiplier;
    }
}
