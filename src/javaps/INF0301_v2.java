// 투 포인터
package javaps;

import java.io.*;
import java.util.*;

public class INF0301_v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static int[] brr;
    static List<Integer> lst;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        brr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int m=0; m<M; m++){
            brr[m] = Integer.parseInt(st.nextToken());
        }

        lst = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1<N && p2<M){
            if (arr[p1] > brr[p2]){
                lst.add(brr[p2++]);
            }
            else if (arr[p1] < brr[p2]){
                lst.add(arr[p1++]);
            }
            else if (arr[p1] == brr[p2]){
                lst.add(arr[p1++]);
                lst.add(brr[p2++]);
            }
        }
        while(p1<N) lst.add(arr[p1++]);
        while(p2<M) lst.add(brr[p2++]);

        StringBuilder sb = new StringBuilder();
        for (int x: lst){
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}
