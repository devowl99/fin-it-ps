package javaps;

import java.io.*;
import java.util.*;

public class INF0404{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String S, T;
    static Map<Character, Integer> mapT;
    static Map<Character, Integer> mapS;
    static char[] arrayS;
    static int count;

    public static void main(String[] args) throws IOException {
        S = br.readLine();
        T = br.readLine();
        int k = T.length();

        // 아나그램을 위한 map T
        mapT = new HashMap<>();
        for (char key: T.toCharArray()){
            mapT.put(key, mapT.getOrDefault(key, 0)+1);
        }

        // 첫 값 비교
        arrayS = S.toCharArray();
        mapS = new HashMap<>();
        for (char key: S.substring(0, k).toCharArray()){
            mapS.put(key, mapS.getOrDefault(key, 0)+1);
        }

        count = 0;
        if (mapT.equals(mapS)) count++;

        int left = 0;
        for (int right=k; right<S.length(); right++){
            mapS.put(arrayS[right], mapS.getOrDefault(arrayS[right], 0)+1);
            mapS.put(arrayS[left], mapS.getOrDefault(arrayS[left], 0)-1);
            if (mapS.get(arrayS[left]) == 0) mapS.remove(arrayS[left]);
            left++;

            if (mapT.equals(mapS)) count++;
        }

        System.out.println(count);
    }
}
