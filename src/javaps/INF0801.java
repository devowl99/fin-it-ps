package javaps;

import java.io.*;
import java.util.*;

public class INF0801 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static boolean flag;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        flag = false;
        dfs(0, 0, 0);

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static void dfs(int depth, int sum1, int sum2){
        if (flag) return;

        if (depth == arr.length){
            if (sum1 == sum2) flag = true;
            return;
        }

        // sum1에 넣는 경우
        dfs(depth+1, sum1+arr[depth], sum2);

        // sum2에 넣는 경우
        dfs(depth+1, sum1, sum2+arr[depth]);
    }
}
