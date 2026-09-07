package javaps.inf2;

import java.io.*;

public class INF0106v2 {

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = str.toCharArray();

        for (int i = 0; i< cArr.length; i++) {
            if (str.indexOf(cArr[i]) == i) sb.append(cArr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
}
