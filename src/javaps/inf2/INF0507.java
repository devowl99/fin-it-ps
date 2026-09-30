package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0507 {

    static String solution(String musts, String subs) {
        Queue<Character> must = new ArrayDeque<>();

        for (char c: musts.toCharArray()) {
            must.offer(c);
        }

        for (char sub: subs.toCharArray()) {
            if (must.isEmpty()) break;

            if (must.peek() == sub) must.poll();
            if (must.contains(sub)) return "NO";
        }

        if (must.isEmpty()) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String musts = br.readLine();
        String subs = br.readLine();

        System.out.println(solution(musts, subs));
    }
}
