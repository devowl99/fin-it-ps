package javaps.inf2;

import java.io.*;
import java.util.*;

// split 활용
public class INF0103v2 {

    static String solution(String str) {
        String[] strArr = str.split(" ");
        String answer = "";

        for (String s: strArr){
            if (s.length() > answer.length()) answer = s;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
