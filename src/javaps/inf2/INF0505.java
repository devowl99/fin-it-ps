package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0505 {

    static int solution(String str) {

        Deque<Character> stack = new ArrayDeque<>();

        int count = 0;
        char last = ' ';
        for (char c: str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else { // c == ')'
                stack.pop();
                if (last == '(') {
                    count += stack.size();
                }
                else count += 1;
            }

            last = c;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
