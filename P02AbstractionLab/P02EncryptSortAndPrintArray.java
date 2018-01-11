package P02AbstractionLab;

import java.util.Arrays;
import java.util.Scanner;

public class P02EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String[] names = new String[num];

        for (int i = 0; i < num; i++) {
            String name = scanner.nextLine();
            names[i] = name;
        }

        int[] encryptedNames = encryptArray(names);

        Arrays.sort(encryptedNames);

        printArray(encryptedNames);
    }

    private static int[] encryptArray(String[] names) {
        int[] encryptedNames = new int[names.length];

        for (int i = 0; i < names.length; i++) {
            int encryptedName = 0;

            for (char ch: names[i].toCharArray()) {
                if (ch == 65 || ch == 97 || ch == 69 || ch == 101 || ch == 73 || ch == 105 || ch == 79 || ch == 111 || ch == 95 || ch == 117){
                    encryptedName += ch * names[i].length();
                } else {
                    encryptedName += ch / names[i].length();
                }
            }
            encryptedNames[i] = encryptedName;
        }
        return encryptedNames;
    }

    private static void printArray(int[] encryptedNames) {
        for (int encryptedName: encryptedNames) {
            System.out.println(encryptedName);
        }
    }
}
