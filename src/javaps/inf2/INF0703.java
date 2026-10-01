package javaps.inf2;

import java.io.*;

public class INF0703 {

    static int dfs(int N) {
        if (N==1) return N;

        return N*dfs(N-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(dfs(N));
    }
}
