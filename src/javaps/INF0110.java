package javaps;

import java.io.*;
import java.util.*;

public class INF0110 {
    static String s;
    static char t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        s = st.nextToken();
        t = st.nextToken().charAt(0);

        int left;
        int right;
        int count;
        for (int i=0; i<s.length(); i++){
            count = 0;
            left = i;
            right = i;

            while (s.charAt(left) != t && s.charAt(right) != t) {
                if (left-1 >= 0) left--;
                if (right+1 < s.length()) right++;
                count++;
            }

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}
