package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0401 {

    static char solution(int n, char[] c) {
        Map<Character, Integer> m = new HashMap<>();

        for (char x: c) {
            m.put(x, m.getOrDefault(x, 0)+1);
        }

        int maxValue = 0;
        char president = ' ';
        for (char key: m.keySet()) {
            if (maxValue < m.get(key)) {
                maxValue = m.get(key);
                president = key;
            }
        }

        return president;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] c = br.readLine().toCharArray();

        System.out.println(solution(n, c));
    }
}
