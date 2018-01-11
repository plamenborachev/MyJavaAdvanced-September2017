package P10JavaAdvancedRetakeExam03May2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P04FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine().trim();

        Map<String, TreeMap<String, ArrayList<String>>> teams = new HashMap<>();

        while (!"Season End".equalsIgnoreCase(input)) {
            String[] inputTokens = input.split(" result ");
            String[] teamsNames = inputTokens[0].trim().split(" - ");
            String teamA = teamsNames[0];
            String teamB = teamsNames[1];
            int[] result = Arrays.stream(inputTokens[1].trim().split(":"))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int teamAScore = result[0];
            int teamBScore = result[1];

            fillMap(teams, teamA, teamB, teamAScore, teamBScore);
            fillMap(teams, teamB, teamA, teamBScore, teamAScore);

            input = reader.readLine().trim();
        }

        String[] teamsStatsNeeded = reader.readLine().split(", ");

        for (int i = 0; i < teamsStatsNeeded.length; i++) {
            String currentTeam = teamsStatsNeeded[i];

            for (Map.Entry<String, ArrayList<String>> opponent: teams.get(currentTeam).entrySet()) {
                for (String result: teams.get(currentTeam).get(opponent.getKey())) {
                    System.out.println(currentTeam + " - " + opponent.getKey() + " -> " + result);
                }
            }
        }
    }

    private static void fillMap(Map<String, TreeMap<String, ArrayList<String>>> teams, String teamA, String teamB, int teamAScore, int teamBScore) {
        teams.putIfAbsent(teamA, new TreeMap<>());
        teams.get(teamA).putIfAbsent(teamB, new ArrayList<>());
        teams.get(teamA).get(teamB).add(teamAScore + ":" + teamBScore);
    }
}
