package javaps.inf2;

import java.io.*;

public class INF0702 {

    static StringBuilder sb = new StringBuilder();

    static void dfs(int N) {
        if (N==0) return;

        dfs(N/2);
        sb.append(N%2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dfs(N);
        System.out.println(sb.toString());
    }
}
