package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0606 {

    static String solution(int N, int[] arr) {
        int[] arr2 = new int[N];
        for (int i=0; i<N; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            if (arr[i-1] != arr2[i-1]) sb.append(i).append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }

}
