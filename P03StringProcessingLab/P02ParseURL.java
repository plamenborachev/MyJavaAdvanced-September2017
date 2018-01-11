package P03StringProcessingLab;

import java.util.Scanner;

public class P02ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("://");

        if (input.length == 2){

            String protocol = input[0];

            String[] serverResources = input[1].split("/", 2);

            String server = serverResources[0];
            String resources = serverResources[1];

            System.out.println("Protocol = " + protocol);
            System.out.println("Server = " + server);
            System.out.println("Resources = " + resources);


        } else {
            System.out.println("Invalid URL");
        }
    }
}
