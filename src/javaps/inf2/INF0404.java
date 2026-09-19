package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0404 {

    static int solution(String S, String T) {

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char c: T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        char[] sArr = S.toCharArray();
        boolean ana = true;
        for (int i=0; i<T.length(); i++) {
            if (!map.containsKey(sArr[i])) {
                ana = false;
            }

            if (map.containsKey(sArr[i])) {
                map.put(sArr[i], map.get(sArr[i])-1);
            }
        }

        if (ana) {
            for (char key : map.keySet()) {
                if (map.get(key) != 0) {
                    ana = false;
                    break;
                }
            }
        }
        if (ana) count++;

        int lt = 0;
        for (int rt=T.length(); rt<S.length(); rt++) {

            if (map.containsKey(sArr[rt])) {
                map.put(sArr[rt], map.get(sArr[rt])-1);
            }

            if (map.containsKey(sArr[lt])) {
                map.put(sArr[lt], map.get(sArr[lt])+1);
            }

            ana = true;
            for (char key: map.keySet()) {
                if (map.get(key) != 0) {
                    ana = false;
                    break;
                }
            }

            if (ana) count++;
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
