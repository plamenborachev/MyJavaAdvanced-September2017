package JavaAdvancedExam22Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P03VLogger2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        HashMap<String, TreeSet<String>> vloggersByFollowers = new HashMap<>();
        HashMap<String, TreeSet<String>> vloggersByFollowing = new HashMap<>();

        while (!"Statistics".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String vlogger1 = tokens[0];
            String action = tokens[1];
            String vlogger2 = "";

            if ("joined".equalsIgnoreCase(action)) {
                vloggersByFollowers.putIfAbsent(vlogger1, new TreeSet<>());
                vloggersByFollowing.putIfAbsent(vlogger1, new TreeSet<>());

            } else if ("followed".equalsIgnoreCase(action))
                vlogger2 = tokens[2];

            if (vloggersByFollowers.containsKey(vlogger1) && vloggersByFollowers.containsKey(vlogger2)
                    && !vlogger1.equalsIgnoreCase(vlogger2)
                    && !vloggersByFollowers.get(vlogger2).contains(vlogger1)) {

                vloggersByFollowers.get(vlogger2).add(vlogger1);
                vloggersByFollowing.get(vlogger1).add(vlogger2);

            }
            input = reader.readLine();
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.", vloggersByFollowers.size());
        System.out.println();

        vloggersByFollowers.entrySet().stream()
                .sorted((v1, v2) -> {
                    if (Integer.compare(v2.getValue().size(), v1.getValue().size()) == 0) {
                        return Integer.compare(vloggersByFollowing.get(v1.getKey()).size(), vloggersByFollowing.get(v2.getKey()).size());
                    }
                    return Integer.compare(v2.getValue().size(), v1.getValue().size());
                })
                .limit(1)
                .forEach(v -> {
                    System.out.printf("1. %s : %d followers, %d following",
                            v.getKey(), v.getValue().size(), vloggersByFollowing.get(v.getKey()).size());
                    System.out.println();
                    for (String follower : vloggersByFollowers.get(v)) {
                        System.out.println("*  " + follower);
                    }
                });

//        HashMap<String, TreeSet<String>> sorted = vloggersByFollowers.entrySet().stream()
//                .sorted((v1, v2) -> {
//                    if (Integer.compare(v2.getValue().size(), v1.getValue().size()) == 0) {
//                        return Integer.compare(vloggersByFollowing.get(v1).size(), vloggersByFollowing.get(v2).size());
//                    }
//                    return Integer.compare(v2.getValue().size(), v1.getValue().size());
//                })
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, HashMap::new));

//        int counter = 1;
//        for (Map.Entry<String, TreeSet<String>> vlogger : sorted.entrySet()) {
//            System.out.printf("%d. %s : %d followers, %d following",
//                    counter++, vlogger.getKey(), vlogger.getValue().size(), vloggersByFollowing.get(vlogger.getKey()).size());
//            System.out.println();
//
    }
}

