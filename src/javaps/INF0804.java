package javaps;

import java.io.*;
import java.util.*;

public class INF0804 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static List<Integer> perm;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = i+1;
        }

        perm = new ArrayList<>();
        dfs(0);

    }

    static void dfs(int depth){
        if (depth == M){
            for (int x: perm){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<arr.length; i++){
            perm.add(arr[i]);
            dfs(depth+1);
            perm.remove(perm.size()-1);
        }
    }
}
