package javaps;

import java.io.*;

public class INF0704 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        sb.append(1).append(" ").append(1).append(" "); // 초기 정의 세팅
        recursive(1, 1, 3); // 이전 값, 현재 값, 횟수

        System.out.println(sb);
    }

    static void recursive(int former, int recent, int count){
        if (count > N) return;

        sb.append(former + recent).append(" ");
        recursive(recent, former+recent, count+1);
    }
}
