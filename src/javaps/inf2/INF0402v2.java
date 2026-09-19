package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0402v2 {

    static String solution(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char x: s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        boolean ana = true;
        for (char x: s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                ana = false;
                break;
            }
            map.put(x, map.get(x)-1);
        }

        if (ana) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }
}
