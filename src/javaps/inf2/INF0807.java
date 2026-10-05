package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0807 {

    static int n, r;
    static int count;

    static void dfs(int depth, int start) {
        if (depth==r) {
            count++;
            return;
        }

        for (int i=start; i<n; i++) {
            dfs(depth+1, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        count = 0;
        dfs(0, 0);

        System.out.println(count);
    }
}
