package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class P16DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage = 45;
            try {
                damage = Integer.parseInt(input[2]);
            } catch (Exception e) {
            }
            int health = 250;
            try {
                health = Integer.parseInt(input[3]);
            } catch (Exception e) {
            }
            int armor = 10;
            try {
                armor = Integer.parseInt(input[4]);
            } catch (Exception e) {
            }

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }
            dragons.get(type).put(name, new int[3]);
            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;
        }

        for (String type : dragons.keySet()) {
            int totalDamage = 0;
            int totalaHealth = 0;
            int totalArmor = 0;
            for (String dragon : dragons.get(type).keySet()) {
                totalDamage += dragons.get(type).get(dragon)[0];
                totalaHealth += dragons.get(type).get(dragon)[1];
                totalArmor += dragons.get(type).get(dragon)[2];
            }
            double avgDamage = (double) totalDamage / dragons.get(type).size();
            double avgHealth = (double) totalaHealth / dragons.get(type).size();
            double avgArmor = (double) totalArmor / dragons.get(type).size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avgDamage, avgHealth, avgArmor);

            for (String dragon : dragons.get(type).keySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragon,
                        dragons.get(type).get(dragon)[0],
                        dragons.get(type).get(dragon)[1],
                        dragons.get(type).get(dragon)[2]);
            }
        }
    }
}
