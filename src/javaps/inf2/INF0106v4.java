package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0106v4 {

    static String solution(String str) {

        Set<Character> lset = new LinkedHashSet<>();
        for (int i=0; i<str.length(); i++) {
            lset.add(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (char c: lset) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }

}
