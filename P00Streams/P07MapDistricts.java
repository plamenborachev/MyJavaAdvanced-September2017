//D:\SoftUni\4.JavaAdvanced-September2017\Docs\07. Java-Advanced-Stream-API-Lab.pdf

package P00Streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;



public class P07MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        int bound = Integer.parseInt(reader.readLine());

        HashMap<String, List<Integer>> cities = new HashMap<>();

        for (String item: input) {
            String[] tokens = item.split(":");
            String city = tokens[0];
            int districtPopulation = Integer.parseInt(tokens[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(districtPopulation);
        }

        cities.entrySet()
                .stream()
                .filter(getFilterByPopulationPredicate(bound))
                .sorted(getSortByDistrictPopulationComparator())
                .forEach(getPrintMapEntryConsumer());
    }

    //    Print all cities with population greater than a given.
    private static Predicate<Map.Entry<String,List<Integer>>> getFilterByPopulationPredicate(int bound) {
        return kv -> kv.getValue().stream()
                .mapToInt(Integer::valueOf)
                .sum() >= bound;
    }

    //    Sort cities and districts by descending population
    private static Comparator<Map.Entry<String,List<Integer>>> getSortByDistrictPopulationComparator() {
        return (kv1, kv2) ->
                Integer.compare(
                        kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        kv1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    //    print top 5 districts for a given city
    private static Consumer<Map.Entry<String,List<Integer>>> getPrintMapEntryConsumer() {
        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream()
                    .sorted((s1, s2) -> s2.compareTo(s1))
                    .limit(5)
                    .forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }


}
