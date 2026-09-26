package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0501 {

    static String solution(String str) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char x: str.toCharArray()) {
            if (x=='(') stack.push(x);
            else if (!stack.isEmpty()) stack.pop();
            else return "NO";
        }

        if (stack.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
