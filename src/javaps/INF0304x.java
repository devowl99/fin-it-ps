package javaps;

import java.io.*;
import java.util.*;

public class INF0304x {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        int left = 0;
        int sum = 0;
        for (int right=0; right<N; right++){

            sum += arr[right];

            while (sum >= M){
                if (sum == M) count++;
                sum -= arr[left++];
            }
        }

        System.out.println(count);
    }
}
