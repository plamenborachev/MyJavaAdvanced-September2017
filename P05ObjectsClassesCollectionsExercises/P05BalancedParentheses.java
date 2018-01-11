package P05ObjectsClassesCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P05BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        ArrayDeque<Character> stack= new ArrayDeque<>();

        boolean isBalanced = true;

        for (char para: input.toCharArray())
        {
            switch (para)
            {
                case '[':
                case '(':
                case '{':
                    stack.push(para);
                    break;
                case '}':
                    if (stack.isEmpty()){
                        isBalanced = false;
                    } else if (stack.pop() != '{'){
                        isBalanced = false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty()){
                        isBalanced = false;
                    } else if (stack.pop() != '('){
                        isBalanced = false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()){
                        isBalanced = false;
                    } else if (stack.pop() != '['){
                        isBalanced = false;
                    }
                    break;
            }
            if (!isBalanced){
                break;
            }
        }
        System.out.println(isBalanced ? "YES" : "NO");
    }
}
