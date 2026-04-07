package javaps;

import java.io.*;
import java.util.*;

public class INF0506 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>();

        // 큐에 다 넣고, poll, offer를 반복하면서 K번째만 offer 생략
        for (int i=1; i<=N; i++){
            q.offer(i);
        }

        int count = 0;
        while (q.size() != 1){
            int tmp = q.poll();
            count++;
            if (count != K) q.offer(tmp);
            else count = 0;
        }

        System.out.println(q.peek());
    }
}
