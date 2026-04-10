package javaps;

import java.io.*;
import java.util.*;

public class INF0507 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String ess;
    static String plan;
    static Queue<Character> q;
    static String answer;

    public static void main(String[] args) throws IOException {

        ess = br.readLine();
        plan = br.readLine();

        q = new ArrayDeque<>();
        for (char x: ess.toCharArray()){
            q.offer(x);
        }

        answer = "YES";
        for (char x: plan.toCharArray()){
            if (q.contains(x)){
                if (q.peek() == x) q.poll();
                else {
                    answer = "NO";
                    break;
                }
            }
        }
        if (!q.isEmpty()) answer = "NO";

        System.out.println(answer);
    }
}
