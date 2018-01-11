package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class P10CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        TreeMap<Character, Integer> symbolCount = new TreeMap<>();

        for (Character ch: input.toCharArray()) {
            if (!symbolCount.containsKey(ch)){
                symbolCount.put(ch, 0);
            }
            symbolCount.put(ch, symbolCount.get(ch) + 1);
        }

        for (Character ch: symbolCount.keySet()) {
            System.out.println(ch + ": " + symbolCount.get(ch) + " time/s");
        }
    }
}
