package javaps;

import java.io.*;
import java.util.*;

public class INF0110v2 {
    static String s;
    static char t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        s = st.nextToken();
        int[] answer = new int[s.length()];
        t = st.nextToken().charAt(0);

        int count = 100;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == t) count = 0;
            else count++;
            answer[i] = count;
        }

        count = 100;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i) == t) count = 0;
            else {
                count++;
                answer[i] = Math.min(answer[i], count);
            }
        }

        for (int x: answer){
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
