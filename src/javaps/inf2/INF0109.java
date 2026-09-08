package javaps.inf2;

import java.io.*;

public class INF0109 {

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = str.toCharArray();
        for (char c: cArr) {
            if (Character.isDigit(c)) sb.append(c);
        }

        return String.valueOf(Integer.parseInt(sb.toString()));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
