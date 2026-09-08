package javaps.inf2;

import java.io.*;

public class INF0109v2 {

    static String solution(String str) {
        int answer = 0;
        char[] cArr = str.toCharArray();
        for (char c: cArr) {
            if (Character.isDigit(c)) answer = answer*10 + (c-'0');
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }

}
