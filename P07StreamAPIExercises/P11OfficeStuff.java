package P07StreamAPIExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class P11OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine()
                    .replaceAll("\\|", "")
                    .split(" - ");
            String company = input[0];
            Integer amount = Integer.parseInt(input[1]);
            String product = input[2];

            companies.putIfAbsent(company, new LinkedHashMap<>());
            companies.get(company).putIfAbsent(product, 0);
            companies.get(company).put(product, companies.get(company).get(product) + amount);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> company : companies.entrySet()) {
            System.out.print(company.getKey() + ": ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> product : company.getValue().entrySet()) {
                sb.append(product.getKey() + "-" + product.getValue() + ", ");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            System.out.print(sb.toString());
            System.out.println();
        }
    }
}
