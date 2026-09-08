package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0110v2 {

    static String solution(String s, char t) {
        char[] cArr = s.toCharArray();
        int[] range = new int[s.length()];
        Arrays.fill(range, Integer.MAX_VALUE);

        for (int i=0; i<s.length(); i++) { // 좌 -> 우
            int count = 0;
            if (cArr[i]==t) {
                range[i] = count;
                continue;
            }

            for (int j=i+1; j<s.length(); j++) {
                count++;
                if (cArr[j]==t) {
                    range[i] = count;
                    break;
                }
            }
        }

        for (int i=s.length()-1; 0<=i; i--) { // 좌 <- 우
            int count = 0;
            if (range[i] == 0) continue;

            for (int j=i-1; 0<=j; j--) {
                count++;
                if (cArr[j]==t) {
                    if (count < range[i]) range[i] = count;
                    break;
                }
            }
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
