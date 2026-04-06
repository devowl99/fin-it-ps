package javaps;

import java.io.*;
import java.util.*;

public class INF0301 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    static int[] newArr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr1[n] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int m=0; m<M; m++){
            arr2[m] = Integer.parseInt(st.nextToken());
        }

        newArr = new int[N+M];
//        for (int i=0; i<N; i++){
//            newArr[i] = arr1[i];
//        }
//        for (int i=N; i<N+M; i++){
//            newArr[i] = arr2[i-N];
//        }
        System.arraycopy(arr1, 0, newArr, 0, arr1.length);
        System.arraycopy(arr2, 0, newArr, arr1.length, arr2.length);

        Arrays.sort(newArr);
        StringBuilder sb = new StringBuilder();
        for (int x: newArr){
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}
