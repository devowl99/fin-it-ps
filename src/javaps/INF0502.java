package javaps;

import java.io.*;
import java.util.*;

public class INF0502 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static Deque<Character> stack;

    public static void main(String[] args) throws IOException {

        str = br.readLine();
        stack = new ArrayDeque<>();

        char former = ' ';
        for (char x: str.toCharArray()){
//            if (x == '('){
//                stack.push(x);
//                former = x;
//            }
//            else if (x== ')'){
//                if (former == '('){
//                    while (stack.peek() != '(') stack.pop();
//                }
//                stack.pop();
//            }
//            else stack.push(x);

            if (x == ')'){
                while (stack.pop() != '(') {}
            }
            else stack.push(x);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            char c = stack.pop();
            if (c != '(' && c != ')'){
                sb.append(c);
            }
        }
        System.out.println(sb.reverse());
    }
}
