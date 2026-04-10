package javaps;

import java.io.*;
import java.util.*;

public class INF0402 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String word1;
    static String word2;
    static Map<Character, Integer> map1;
    static Map<Character, Integer> map2;

    public static void main(String[] args) throws IOException {
        word1 = br.readLine();
        word2 = br.readLine();

        map1 = new HashMap<>();
        map2 = new HashMap<>();

        for (char x: word1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        for (char x: word2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }

        if (map1.equals(map2)) System.out.println("YES");
        else System.out.println("NO");
    }
}
