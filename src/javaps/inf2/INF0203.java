package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0203 {

    static String solution(int N, int[] A, int[] B) {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            if (A[i] == B[i]) sb.append('D').append('\n');
            else if (A[i]==1 && B[i]==2 || A[i]==2 && B[i]==3 || A[i]==3 && B[i]==1) sb.append('B').append('\n');
            else sb.append('A').append('\n');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            B[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, A, B));
    }
}
