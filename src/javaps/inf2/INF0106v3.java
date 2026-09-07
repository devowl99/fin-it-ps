package javaps.inf2;

import java.io.*;

public class INF0106v3 {

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
