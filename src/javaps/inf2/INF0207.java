package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0207 {

    static int solution(int N, int[] result) {

        int total = 0;

        int score = 1;
        for (int n=0; n<N; n++) {
            if (result[n] == 0) score=1;
            else {
                total += score;
                score++;
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] result = new int[N];
        for (int n=0; n<N; n++) {
            result[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, result));

    }
}
