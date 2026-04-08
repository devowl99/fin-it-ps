package javaps;

import java.io.*;
import java.util.*;

public class INF0606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N+1];
        arr2 = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++){
            int next = Integer.parseInt(st.nextToken());
            arr1[n] = next;
            arr2[n] = next;
        }
        Arrays.sort(arr1);

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i=1; i<=N; i++){
            if (arr1[i] != arr2[i]){
                if (idx == 0){
                    idx = i;
                }
                else {
                    sb.append(idx).append(' ').append(i);
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
