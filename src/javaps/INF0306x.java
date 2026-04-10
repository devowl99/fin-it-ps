package javaps;

import java.io.*;
import java.util.*;

public class INF0306x {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int maxLen = 0;
        int changeCount = 0;
        for (int right=0; right<N; right++){
            if (arr[right] == 0) changeCount++;
            while (changeCount > k){
                if (arr[left] == 0) changeCount--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
