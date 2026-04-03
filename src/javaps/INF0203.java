package javaps;

import java.io.*;
import java.util.*;

public class INF0203 {
    static int N;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            A[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            B[n] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        // 가위 1, 바위 2, 보 3
        for (int n=0; n<N; n++){
            if (A[n] == B[n])
                sb.append("D").append('\n');
            else if (A[n]==2 && B[n]==1 || A[n]==3 && B[n]==2 || A[n]==1 && B[n]==3)
                sb.append("A").append('\n');
            else sb.append("B").append('\n');
        }

        System.out.println(sb);
    }
}
