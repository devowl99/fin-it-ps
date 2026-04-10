package javaps;

import java.io.*;
import java.util.*;

public class INF0305 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int n=1; n<=N; n++){
            arr[n-1] = n;
        }

        int count = 0;
        int sum = 0;
        int left = 0;
        for (int right=0; right<N; right++){
            sum += arr[right];

            while (sum >= N){
                if (sum == N && left != right) count++;
                sum = sum - arr[left++];
            }
        }

        System.out.println(count);
    }
}
