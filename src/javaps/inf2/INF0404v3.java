package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0404v3 {

    static int solution(String S, String T) {
        // S : 긴거
        // T : 짧은거
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char key: T.toCharArray()) {
            mapT.put(key, mapT.getOrDefault(key, 0)+1);
        }

        char[] arrS = S.toCharArray();
        for (int i=0; i<T.length()-1; i++) {
            mapS.put(arrS[i], mapS.getOrDefault(arrS[i], 0)+1);
        }

        int count = 0;
        int lt = 0;
        for (int rt=T.length()-1; rt<arrS.length; rt++) {
            mapS.put(arrS[rt], mapS.getOrDefault(arrS[rt], 0)+1);
            if (mapS.equals(mapT)) count++;

            if (mapS.get(arrS[lt])==1) mapS.remove(arrS[lt]);
            else mapS.put(arrS[lt], mapS.get(arrS[lt])-1);

            lt++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        System.out.println(solution(S, T));
    }
}
