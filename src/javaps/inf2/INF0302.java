package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0302 {

    static List<Integer> lst;

    static String solution(int N, int M, int[] a, int[] b) {

        int p1, p2;
        p1 = p2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);

        lst = new ArrayList<>();
        while (p1<N && p2<M) {
            if (a[p1] < b[p2]) p1++;
            else if (a[p1] > b[p2]) p2++;
            else{
                lst.add(a[p1++]);
                p2++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x: lst) {
            sb.append(x).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            a[n] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] b = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int m=0; m<M; m++) {
            b[m] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, a, b));
    }
}
