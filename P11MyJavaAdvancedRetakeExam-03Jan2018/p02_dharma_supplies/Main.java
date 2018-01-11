package p02_dharma_supplies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int islandPartsCount = 0;

        while (!"Collect".equals(input)) {
            sb.append(input);
            islandPartsCount++;
            input = reader.readLine();
        }

        String islandParts = sb.toString();

        String cratePattern = "\\[.*?\\]";
        Pattern crateRegex = Pattern.compile(cratePattern);
        Matcher cratesMatcher = crateRegex.matcher(islandParts);

        int totalCrates = 0;

        while (cratesMatcher.find()) {
            totalCrates++;
        }

        int n = totalCrates / islandPartsCount;

        List<Integer> foods = new ArrayList<>();
        List<Integer> drinks = new ArrayList<>();

        String pattern = "\\[((#[a-z]*)|(#[0-9]*))([a-zA-Z0-9\\s]+)\\1?\\]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(islandParts);

        while (matcher.find()) {
            String tag = matcher.group(1).substring(1);
            String body = matcher.group(4);
            if (matcher.group(2) == null && tag.length() == n) {
                int currentAmountOfFood = 0;
                List<Character> uniqueChars = new ArrayList<>();
                for (int i = 0; i < body.length(); i++) {
                    if (!uniqueChars.contains(body.charAt(i))) {
                        uniqueChars.add(body.charAt(i));
                    }
                }
                for (Character ch : uniqueChars) {
                    currentAmountOfFood += (int) ch;
                }
                foods.add(currentAmountOfFood * tag.length());
            }
            if (matcher.group(3) == null && tag.length() == n) {
                int sumOfTheSupplyBodyAscciCodes = 0;
                for (int i = 0; i < body.length(); i++) {
                    sumOfTheSupplyBodyAscciCodes += (int) body.charAt(i);
                }
                int sumOfTheSupplyTagAscciCodes = 0;
                for (int i = 0; i < tag.length(); i++) {
                    sumOfTheSupplyTagAscciCodes += (int) tag.charAt(i);
                }
                int currentAmountOfDrinks = sumOfTheSupplyBodyAscciCodes * sumOfTheSupplyTagAscciCodes;
                drinks.add(currentAmountOfDrinks);
            }
        }

        if (foods.size() + drinks.size() > 0) {
            System.out.println(String.format("Number of supply crates: %d", foods.size() + drinks.size()));
            int foodAmount = 0;
            for (Integer foodNumber : foods) {
                foodAmount += foodNumber;
            }
            System.out.println(String.format("Amount of food collected: %d", foodAmount));
            int drinkAmount = 0;
            for (Integer drinkNumber : drinks) {
                drinkAmount += drinkNumber;
            }
            System.out.println(String.format("Amount of drinks collected: %d", drinkAmount));
        } else {
            System.out.println("No supplies found!");
        }
    }
}
