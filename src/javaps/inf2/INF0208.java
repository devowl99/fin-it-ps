package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0208 {

    static String solution(int N, int[] scores) {
        StringBuilder sb = new StringBuilder();

        int[] ranks = new int[N];
        Arrays.fill(ranks, 1);
        for (int n=1; n<N; n++) {
            for (int m=0; m<n; m++) {
                if (scores[n] > scores[m]) ranks[m]++;
                else if (scores[n] < scores[m]) ranks[n]++;
            }
        }

        for (int rank: ranks) {
            sb.append(rank).append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        for (int n=0; n<N; n++) {
            scores[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, scores));
    }
}
