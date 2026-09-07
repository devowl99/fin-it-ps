package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0106 {

    static String solution(String str) {

        char[] strArr = str.toCharArray();
        List<Character> cLst = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag;

        for (char c: strArr) {
            flag = false;

            for (char used: cLst) {
                if (c == used) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append(c);
                cLst.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
}
