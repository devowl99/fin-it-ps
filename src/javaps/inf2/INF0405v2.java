package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0405v2 {

    static Set<Integer> treeSet;

    static int solution(int N, int K, int[] arr) {

        treeSet = new TreeSet<>(Collections.reverseOrder());

        comb(0, 0, arr, 0);

        int i=1;
        for (int x: treeSet) {
            if (i==K) return x;
            i++;
        }
        return -1;
    }

    static void comb(int depth, int start, int[] arr, int sum) {
        if (depth == 3) {
            treeSet.add(sum);
            return;
        }

        for (int i=start; i<arr.length; i++) {
            comb(depth+1, i+1, arr, sum+arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, arr));
    }
}
