package javaps;

import java.io.*;
import java.util.*;

public class INF0304x {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] seq;
    static int count;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            seq[n] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        int left = 0;
        int sum = 0;
        for (int right=0; right<N; right++){
            sum += seq[right];

            while (sum > M) sum -= seq[left++];

            if (sum == M) count++;
        }

        System.out.println(count);
    }
}
