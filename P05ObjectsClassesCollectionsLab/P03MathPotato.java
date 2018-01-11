package P05ObjectsClassesCollectionsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P03MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] children = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < children.length; i++) {
            queue.offer(children[i]);
        }

        int cycle = 1;

        while(queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number){
        if(number <= 1){
            return  false;
        }
        for (int devisor = 2; devisor <= Math.sqrt(number) ; devisor++) {
            if (number % devisor == 0){
                return false;
            }
        }
        return true;
    }
}
