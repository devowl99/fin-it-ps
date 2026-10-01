package javaps.inf2;

import java.io.*;

public class INF0701 {

    static StringBuilder sb = new StringBuilder();

    static void solution(int N) {
        if (N==0) return;

        solution(N-1);
        sb.append(N).append(' ');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        solution(N);
        System.out.println(sb.toString());
    }
}
