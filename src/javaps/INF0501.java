package javaps;

import java.io.*;
import java.util.*;

public class INF0501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static Deque<Character> dq;

    public static void main(String[] args) throws IOException {

        str = br.readLine();
        dq = new ArrayDeque<>();

        boolean flag = true;
        for (char x: str.toCharArray()){
            if (x == '('){
                dq.push(x);
            }

            else { // )
                if (!dq.isEmpty() && dq.peek() == '(') dq.pop();
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (!flag || !dq.isEmpty()) System.out.println("NO");
        else System.out.println("YES");
    }
}
