package javaps;

import java.io.*;
import java.util.*;

public class INF0602 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N-1; i++){
            for (int j=0; j<N-i-1; j++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x: arr){
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}
