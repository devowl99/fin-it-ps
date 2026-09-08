package javaps.inf2;

import java.io.*;

public class INF0112v2 {

    static String solution(int n, String s) {

        String answer = "";

        String word;
        for (int i=0; i<n; i++) {
            word = s.substring(0, 7).replace("#", "1").replace("*", "0");
            answer += (char)Integer.parseInt(word, 2);

            s = s.substring(7);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(solution(n, s));
    }

}
