package p03_the_dharma_initiative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] stationNames = {"Hydra", "Arrow", "Flame", "Pearl", "Orchid"};
        String[] stationPurposes = {
                "Zoological Research.",
                "Development of defensive strategies, and Intelligence gathering.",
                "Communication.",
                "Psychological Research and/or Observation.",
                "Space-time manipulation research, disguised as a Botanical station."
        };

        Map<String, Station> stations = new LinkedHashMap<>();

        for (int i = 0; i < stationNames.length; i++) {
            Station station = new Station(stationNames[i], stationPurposes[i]);
            stations.putIfAbsent(stationNames[i], station);
        }

        String input = reader.readLine();

        while (!"Recruit".equals(input)) {
            String[] recruitTokens = input.split(":");
            String personName = recruitTokens[0];
            int facilityNumber = Integer.parseInt(recruitTokens[1]);
            String stationName = recruitTokens[2];

            if (stations.containsKey(stationName)) {
                Recruit recruit = new Recruit(personName, facilityNumber);
                stations.get(stationName).addRecruit(recruit);
            }

            input = reader.readLine();
        }

        String command = reader.readLine();

        if ("DHARMA Initiative".equals(command)) {
            stations.values().stream()
                    .sorted((r1, r2) -> {
                        if (Integer.compare(r2.numberOfRecruits(), r1.numberOfRecruits()) == 0) {
                            return r1.getName().compareTo(r2.getName());
                        }
                        return Integer.compare(r2.numberOfRecruits(), r1.numberOfRecruits());
                    })
                    .forEach(s -> System.out.println(String.format("The %s has %d DHARMA recruits in it.",
                            s.getName(), s.numberOfRecruits()))
                    );
        } else {
            if (!stations.containsKey(command)){
                System.out.println("DHARMA Initiative does not have such a station!");
            } else {
                System.out.println(stations.get(command.toString()));
            }

        }
    }
}

class Station {
    private String name;
    private String purpose;
    private List<Recruit> recruits;

    public Station(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
        this.recruits = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    void addRecruit(Recruit recruit) {
        this.recruits.add(recruit);
    }

    int numberOfRecruits() {
        return this.recruits.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The %s station: %s", this.name, this.purpose))
                .append(System.lineSeparator());
        if (this.recruits.size() == 0){
            sb.append("No recruits.");
        } else {
            this.recruits.stream()
                    .sorted((r1, r2) -> Integer.compare(r2.getFacilityNumber(), r1.getFacilityNumber()))
                    .forEach(recruit -> sb.append(String.format("###%s - %d",
                            recruit.getName(), recruit.getFacilityNumber())).append(System.lineSeparator()));
        }
        return sb.toString().trim();
    }
}

class Recruit {
    private String name;
    private int facilityNumber;

    public Recruit(String name, int facilityNumber) {
        this.name = name;
        this.facilityNumber = facilityNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getFacilityNumber() {
        return this.facilityNumber;
    }
}
