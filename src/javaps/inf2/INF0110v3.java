package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0110v3 {

    static String solution(String s, char t) {

        int[] range = new int[s.length()];

        int count = 100;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == t) count = 0;
            else count++;

            range[i] = count;
        }

        count = 100;
        for (int i=s.length()-1; 0<=i; i--) {
            if (range[i] == 0) {
                count = 0;
                continue;
            }
            else count++;

            range[i] = Math.min(range[i], count);
        }

        StringBuilder sb = new StringBuilder();
        for (int x: range) {
            sb.append(x).append(' ');
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char t = st.nextToken().charAt(0);

        System.out.println(solution(s, t));
    }

}
