package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class P15LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        boolean legendaryObtained = false;
        String materialWinner = "";

        while (!legendaryObtained) {
            String input = reader.readLine();
            String[] tokens = input.split("\\s+");

            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (material.equalsIgnoreCase("Shards")
                        || material.equalsIgnoreCase("Fragments")
                        || material.equalsIgnoreCase("Motes")) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);

                    if (keyMaterials.get(material) >= 250) {
                        materialWinner = material;
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        legendaryObtained = true;
                        break;
                    }
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, quantity);
                    } else {
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                    }
                }
            }
        }

        if (materialWinner.equalsIgnoreCase("Shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (materialWinner.equalsIgnoreCase("Fragments")) {
            System.out.println("Valanyr obtained!");
        } else if (materialWinner.equalsIgnoreCase("Motes")) {
            System.out.println("Dragonwrath obtained!");
        }

        keyMaterials.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        for (String junk : junkMaterials.keySet()) {
            System.out.println(junk + ": " + junkMaterials.get(junk));
        }
    }
}
