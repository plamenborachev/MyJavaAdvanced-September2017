package p04_highscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Player> players = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!"osu!".equals(input)){
            String[] duelTokens = input.split("<->");
            String[] player1Tokens = duelTokens[0].split(" ");
            String player1Name = player1Tokens[1];
            long player1Score = Long.parseLong(player1Tokens[0]);
            String[] player2Tokens = duelTokens[1].split(" ");
            String player2Name = player2Tokens[0];
            long player2Score = Long.parseLong(player2Tokens[1]);

            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);

            Duel duelPlayer1 = new Duel(player2Name, player1Score - player2Score);
            Duel duelPlayer2 = new Duel(player1Name, player2Score - player1Score);

            players.putIfAbsent(player1Name, player1);
            players.get(player1Name).addDuel(duelPlayer1);

            players.putIfAbsent(player2Name, player2);
            players.get(player2Name).addDuel(duelPlayer2);

            input = reader.readLine();
        }

        players.values().stream()
                .sorted((p1, p2) -> Long.compare(p2.getDuels().stream().mapToLong(Duel::getScore).sum(),
                        p1.getDuels().stream().mapToLong(Duel::getScore).sum()))
                .forEach(player -> {
                    System.out.println(String.format("%s - (%d)", player.getName(), player.getTotalScore()));
                    player.getDuels().stream()
                            .forEach(duel -> System.out.println(String.format("*   %s <-> %d",
                                    duel.getOpponent(), duel.getScore())));
                });

    }
}

class Player{
    private String name;
    private List<Duel> duels;

    Player(String name) {
        this.name = name;
        this.duels = new LinkedList<>();
    }

    String getName() {
        return this.name;
    }

    void addDuel(Duel duel){
        this.duels.add(duel);
    }

    List<Duel> getDuels() {
        return Collections.unmodifiableList(this.duels);
    }

    long getTotalScore(){
        return this.duels.stream().mapToLong(Duel::getScore).sum();
    }
}

class Duel{
    private String opponent;
    private long score;

    Duel(String opponent, long score) {
        this.opponent = opponent;
        this.score = score;
    }

    String getOpponent() {
        return this.opponent;
    }

    long getScore() {
        return this.score;
    }
}
