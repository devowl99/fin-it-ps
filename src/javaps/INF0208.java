package javaps;

import java.io.*;
import java.util.*;

public class INF0208 {
    static int N;
    static int[] score;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        score = new int[N];
        rank = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            score[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(rank, 1);
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (i==j) continue;
                if (score[i]<score[j]){
                    rank[i]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            sb.append(rank[i]).append(" ");
        }

        System.out.println(sb);
    }
}
