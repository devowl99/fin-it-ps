package javaps;

import java.io.*;

public class INF0102 {
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        s = br.readLine();

        for (char c: s.toCharArray()){
//            if (c < 'a') sb.append((char)(c + ('a'-'A'))); // 대문자인 경우
//            else sb.append((char)(c - ('a'-'A')));// 소문자인 경우

            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));

        }

        System.out.println(sb);
    }
}
