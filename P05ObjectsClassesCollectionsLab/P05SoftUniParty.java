package P05ObjectsClassesCollectionsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class P05SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        TreeSet<String> vipGuests = new TreeSet<>();
        TreeSet<String> regularGuests = new TreeSet<>();

        while(!input.equals("PARTY")){
            if (input.charAt(0) >=48 && input.charAt(0) <= 57){
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
            input = reader.readLine();
        }

        while(!input.equals("END")){
            if (vipGuests.contains(input)){
                vipGuests.remove(input);
            } else if(regularGuests.contains(input)){
                regularGuests.remove(input);
            }
            input = reader.readLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        if (!vipGuests.isEmpty()){
            for (String vip : vipGuests) {
                System.out.println(vip);
            }
        }
        if (!regularGuests.isEmpty()){
            for (String regular : regularGuests) {
                System.out.println(regular);
            }
        }
    }
}
