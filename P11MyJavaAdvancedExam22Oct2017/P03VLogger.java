package JavaAdvancedExam22Oct2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P03VLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Map<String, ArrayList<String>> vloggersByFollowers = new HashMap<>();
        Map<String, ArrayList<Integer>> vloggersByNumberFollowersAndFollowing = new HashMap<>();

        while (!"Statistics".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String vlogger1 = tokens[0];
            String action = tokens[1];
            String vlogger2 = "";

            if ("joined".equalsIgnoreCase(action)) {
                vloggersByFollowers.putIfAbsent(vlogger1, new ArrayList<>());
                vloggersByNumberFollowersAndFollowing.putIfAbsent(vlogger1, new ArrayList<>());
                vloggersByNumberFollowersAndFollowing.get(vlogger1).add(0);
                vloggersByNumberFollowersAndFollowing.get(vlogger1).add(0);

            } else if ("followed".equalsIgnoreCase(action))
                vlogger2 = tokens[2];

            if (vloggersByFollowers.containsKey(vlogger1) && vloggersByFollowers.containsKey(vlogger2)
                    && !vlogger1.equalsIgnoreCase(vlogger2)
                    && !vloggersByFollowers.get(vlogger2).contains(vlogger1)) {

                vloggersByFollowers.get(vlogger2).add(vlogger1);
                vloggersByNumberFollowersAndFollowing.get(vlogger1)
                        .set(1, vloggersByNumberFollowersAndFollowing.get(vlogger1).get(1) + 1);
                vloggersByNumberFollowersAndFollowing.get(vlogger2)
                        .set(0, vloggersByNumberFollowersAndFollowing.get(vlogger2).get(0) + 1);
            }
            input = reader.readLine();
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.", vloggersByFollowers.size());
        System.out.println();

//        Comparator<Map.Entry<String, ArrayList<Integer>>> byAmount =
//                Comparator.comparing();

        vloggersByNumberFollowersAndFollowing.entrySet().stream()
                .sorted((v2, v1) -> {
            if (v1.getValue().get(0) < v2.getValue().get(0)){
                return -1;
            } else if (v1.getValue().size() > v2.getValue().size()){
                return 1;
            }
            return 0;
//            else if (v1.getValue().size() == v2.getValue().size()){
//                if (v1.getValue().get(1) < v2.getValue().get(1)){
//                    return -1;
//                } else if (v1.getValue().get(1) > v2.getValue().get(1)){
//                    return 1;
//                }
//            }
                })
//                .limit(1)
                .forEach(v -> {
                    int counter = 1;
                    System.out.printf("%d. %s : %d followers, %d following",
                            counter, v.getKey(), v.getValue().get(0), v.getValue().get(1));
                    counter++;
                    System.out.println();
                });


    }
}
