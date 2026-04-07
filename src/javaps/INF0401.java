package javaps;

import java.io.*;
import java.util.*;

public class INF0401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        map = new HashMap<>();
        for (char x: str.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int maxCount = 0;
        char president = '.';
        for (char key: map.keySet()){
            if (map.get(key) > maxCount){
                president = key;
                maxCount = map.get(key);
            }
        }

        System.out.println(president);
    }
}
