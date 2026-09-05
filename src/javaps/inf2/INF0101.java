package javaps.inf2;

import java.io.*;

public class INF0101 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine().toUpperCase();
        char c = br.readLine().toUpperCase().charAt(0);

        System.out.println(solution(str, c));
    }

    static int solution(String str, char c){
        int answer = 0;

        for (char x: str.toCharArray()) {
            if (x == c) answer++;
        }

        return answer;
    }
}
