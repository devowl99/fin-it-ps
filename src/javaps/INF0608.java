package javaps;

import java.io.*;
import java.util.*;

public class INF0608 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N-1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right)/2;

            if (M == arr[mid]){
                answer = mid+1;
                break;
            }
            else if (M < arr[mid]) right = mid-1;
            else left = mid+1;
        }

        System.out.println(answer);
    }
}
