package javaps.inf2;

import java.io.*;

public class INF0111 {

    static String solution(String s) {

        StringBuilder sb = new StringBuilder();

        int count = 1;
        char last=s.charAt(0);
        sb.append(last);
        for (int i=1; i<s.length(); i++) {

            if (last != s.charAt(i)) {
                if (count>1) sb.append(count).append(s.charAt(i));
                else sb.append(s.charAt(i));
                count = 1;
                last = s.charAt(i);
            }

            else count++;
        }

        if (count>1) sb.append(count);

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(solution(s));
    }
}
