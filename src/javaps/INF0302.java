package javaps;

import java.io.*;
import java.util.*;

public class INF0302 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] A, B;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            A[n] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<M; n++){
            B[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int p1 = 0;
        int p2 = 0;
        answer = new ArrayList<>();
        while (p1<N && p2<M){
            if (A[p1] == B[p2]){
                answer.add(A[p1++]);
                p2++;
            }
            else if (A[p1] > B[p2]){
                p2++;
            }
            else if (A[p1] < B[p2]){
                p1++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x: answer){
            sb.append(x).append(' ');
        }

        System.out.println(sb);
    }
}
