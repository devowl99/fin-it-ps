package javaps;

import java.io.*;
import java.util.*;

public class INF0504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static Deque<Integer> dq;
    static int answer;

    public static void main(String[] args) throws IOException {

        str = br.readLine();
        dq = new ArrayDeque<>();

        answer = 0;
        for (char x: str.toCharArray()) {
            if (Character.isDigit(x)) dq.push(x - '0');
            else {
                int num1 = dq.pop();
                int num2 = dq.pop();
                if (x == '+') dq.push(num2 + num1);
                else if (x == '-') dq.push(num2 - num1);
                else if (x == '*') dq.push(num2 * num1);
                else if (x == '/') dq.push(num2 / num1);
            }
        }
        System.out.println(dq.pop());
    }
}
