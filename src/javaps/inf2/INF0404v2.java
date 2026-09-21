package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0404v2 {

    static int solution(String S, String T) {
        Map<Character, Integer> mapT = new HashMap<>();

        int count = 0;
        char[] arrS = S.toCharArray();
        char[] arrT = T.toCharArray();

        for (char key: arrT) {
            mapT.put(key, mapT.getOrDefault(key, 0)+1);
        }

        Map<Character, Integer> mapS;

        int lt;
        for (int rt=T.length()-1; rt<S.length(); rt++) {
            lt = rt - T.length() + 1;

            mapS = new HashMap<>();
            for (; lt<=rt; lt++) {
                mapS.put(arrS[lt], mapS.getOrDefault(arrS[lt], 0)+1);
            }

            if (mapS.equals(mapT)) count++;
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
