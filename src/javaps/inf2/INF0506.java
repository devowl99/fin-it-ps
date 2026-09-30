package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0506 {

    static int solution(int N, int K) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i=1; i<=N; i++) {
            dq.offerLast(i);
        }

        int count = 0;
        while (dq.size() > 1) {
            count++;

            if (count==K) {
                dq.pollFirst();
                count=0;
            }
            else dq.offerLast(dq.pollFirst());
        }

        return dq.peekFirst();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, K));
    }
}
