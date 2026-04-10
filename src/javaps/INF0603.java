package javaps;

import java.io.*;
import java.util.*;

public class INF0603 {

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

        for (int i=0; i<N; i++){
            int tmp = arr[i];
            int j;
            for (j=i-1; j>=0; j--){
                if (tmp < arr[j]){
                    arr[j+1] = arr[j];
                }
                else break;
            }
            arr[j+1]=tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int x: arr){
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}
