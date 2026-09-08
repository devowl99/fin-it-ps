package javaps.inf2;

import java.io.*;

public class INF0112 {

    static String solution(int n, String s) {

        String answer = "";
        int len = s.length()/n;
        s = s.replace("#", "1").replace("*", "0");

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            sb.append(s.charAt(i));
            count++;
            if (count==len) {
                answer += (char)Integer.parseInt(sb.toString(), 2);

                count = 0;
                sb.setLength(0);
            }
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
