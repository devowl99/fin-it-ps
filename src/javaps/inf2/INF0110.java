package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0110 {

    static String solution(String s, char t) {
        StringBuilder sb = new StringBuilder();

        char[] cArr = s.toCharArray();
        for (int i=0; i<cArr.length; i++){
            if (cArr[i] == t) {
                sb.append(0).append(' ');
                continue;
            }

            int li=i-1;
            int lr = 1;
            boolean flag = false;
            while (0<=li) { // 왼쪽 탐색
                if (cArr[li] == t) {
                    flag = true;
                    break;
                }
                lr++;
                li--;
            }

            if (!flag) lr = Integer.MAX_VALUE;

            int ri=i+1;
            int rr = 1;
            flag = false;
            while (ri<cArr.length) { // 오른쪽 탐색
                if (cArr[ri] == t) {
                    flag = true;
                    break;
                }
                rr++;
                ri++;
            }

            if (!flag) rr = Integer.MAX_VALUE;

            sb.append(Math.min(lr, rr)).append(' ');
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char t = st.nextToken().charAt(0);


        System.out.println(solution(s, t));
    }
}
