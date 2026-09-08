package javaps.inf2;

import java.io.*;

public class INF0107 {

    static String solution(String str) {

        str = str.toLowerCase();
        StringBuilder sb = new StringBuilder(str);

        if (str.equals(sb.reverse().toString())) return "YES";
        else return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
