package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0504 {

    static int solution(String str) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (char c: str.toCharArray()) {
            if (Character.isDigit(c)) { // 숫자
                stack.push(c-'0');
            }

            else {
                int n2 = stack.pop();
                int n1 = stack.pop();

                if (c=='+') {
                    stack.push(n1+n2);
                }
                else if (c=='-') {
                    stack.push(n1-n2);
                }
                else if (c=='*') {
                    stack.push(n1*n2);
                }
                else { // '/'
                    stack.push(n1/n2);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
