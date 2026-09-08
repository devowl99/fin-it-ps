package javaps.inf2;

import java.io.*;

public class INF0108 {

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = str.toCharArray();

        for (char c: cArr) {
            if (Character.isLetter(c)) sb.append(c);
        }

        if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) return "YES";
        else return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
