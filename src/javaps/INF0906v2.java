package javaps;

import java.io.*;
import java.util.*;

public class INF0906v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] p;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // make
        p = new int[N+1];
        for (int i=0; i<=N; i++){
            p[i] = i;
        }

        for (int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        if (find(x) == find(y)) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        p[rootX] = rootY;
        return true;
    }

    static int find(int x){
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }
}
