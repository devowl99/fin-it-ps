package javaps.inf2;

import java.io.*;

// substring, indexOf 활용
public class INF0103v3 {

    static String solution(String str) {

        String answer = "";

        while (str.contains(" ")) {

            int i = str.indexOf(" ");
            String s = str.substring(0, i);

            if (s.length() > answer.length()) answer = s;

            str = str.substring(i+1);
        }

        if (str.length() > answer.length()) answer = str;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
