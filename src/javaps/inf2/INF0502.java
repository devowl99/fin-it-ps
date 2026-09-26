package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0502 {

    static Deque<Character> stack;

    static String solution(String str) {

        stack = new ArrayDeque<>();
        for (char c: str.toCharArray()) {
            if (c != ')') stack.push(c);
            else { // )
                while (stack.peek() != '(') stack.pop();
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
