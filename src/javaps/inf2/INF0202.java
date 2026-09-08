package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0202 {

    static int solution(int N, int[] sh) {
        int hest = sh[0];
        int count=1;
        for (int i=1; i<N; i++) {
            if (sh[i] > hest) {
                count++;
                hest = sh[i];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sh = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            sh[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, sh));
    }
}
