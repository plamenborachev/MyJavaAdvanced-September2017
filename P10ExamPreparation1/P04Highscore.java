package P10ExamPreparation1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P04Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Map<String, Long> playersByScore = new LinkedHashMap<>();
        Map<String, LinkedList<String>> playersDuels = new LinkedHashMap<>();

        while (!"osu!".equalsIgnoreCase(input)) {
            String[] players = input.split("<->");

            String[] tokensPlayer1 = players[0].split("\\s+");
            String[] tokensPlayer2 = players[1].split("\\s+");

            String player1 = tokensPlayer1[1];
            long player1Score = Long.parseLong(tokensPlayer1[0]);

            String player2 = tokensPlayer2[0];
            long player2Score = Long.parseLong(tokensPlayer2[1]);

            fillMaps(playersByScore, playersDuels, player1, player1Score, player2, player2Score);
            fillMaps(playersByScore, playersDuels, player2, player2Score, player1, player1Score);

            input = reader.readLine();
        }

        Map<String, Long> sorted = playersByScore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Long> player : sorted.entrySet()) {
            System.out.println(player.getKey() + " - " + "(" + player.getValue() + ")");
            for (String duel: playersDuels.get(player.getKey())) {
                System.out.println(duel);
            }
        }
    }

    private static void fillMaps(Map<String, Long> playersByScore, Map<String, LinkedList<String>> playersDuels, String player1, long player1Score, String player2, long player2Score) {
        playersByScore.putIfAbsent(player1, 0L);
        playersByScore.put(player1, playersByScore.get(player1) + (player1Score - player2Score));
        playersDuels.putIfAbsent(player1, new LinkedList<>());
        playersDuels.get(player1).add("*   " + player2 + " <-> " + (player1Score - player2Score));
    }
}
