package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0402 {

    static String solution(String s1, String s2) {
        Map<Character, Integer> tm1 = new HashMap<>();
        Map<Character, Integer> tm2 = new HashMap<>();

        for (char x: s1.toCharArray()) {
            tm1.put(x, tm1.getOrDefault(x, 0)+1);
        }
        for (char x: s2.toCharArray()) {
            tm2.put(x, tm2.getOrDefault(x, 0)+1);
        }

        if (tm1.equals(tm2)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }
}
