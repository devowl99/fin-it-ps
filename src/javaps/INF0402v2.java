package javaps;

import java.io.*;
import java.util.*;

public class INF0402v2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String word1;
    static String word2;
    static Map<Character, Integer> map;
    static String answer;

    public static void main(String[] args) throws IOException {
        word1 = br.readLine();
        word2 = br.readLine();

        map = new HashMap<>();

        for (char x : word1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        answer = "YES";
        for (char key : word2.toCharArray()) {
            if (map.getOrDefault(key, 0) == 0) {
                answer = "NO";
                break;
            }
            map.put(key, map.get(key) - 1);
        }

        System.out.println(answer);
    }
}
