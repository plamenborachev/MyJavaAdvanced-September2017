package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class P14PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        LinkedHashMap<String, LinkedHashMap<String, Long>> countriesCitiesPopulation = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesByPopulation = new LinkedHashMap<>();


        while (!input.equals("report")) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            if (!countriesCitiesPopulation.containsKey(country)) {
                countriesCitiesPopulation.put(country, new LinkedHashMap<>());
                countriesByPopulation.put(country, 0L);
            }
            countriesCitiesPopulation.get(country).put(city, population);
            countriesByPopulation.put(country, countriesByPopulation.get(country) + population);
            input = reader.readLine();
        }

        countriesCitiesPopulation.entrySet().stream()
                .sorted((c1, c2) -> countriesByPopulation.get(c2.getKey()).compareTo(countriesByPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)\n", country.getKey(), countriesByPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city -> {
                        System.out.format("=>%s: %d\n", city.getKey(), city.getValue());
                    });
                });
    }
}
