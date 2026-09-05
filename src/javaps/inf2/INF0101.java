package javaps.inf2;

import java.io.*;

public class INF0101 {

    static int solution(String str, char c){
        int answer = 0;

        String strU = str.toUpperCase();
        char cU = Character.toUpperCase(c);

        for (char x: strU.toCharArray()) {
            if (x == cU) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char c = br.readLine().charAt(0);

        System.out.println(solution(str, c));
    }
}
