package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0508 {

    static int solution(int N, int M, int[] arr) {

        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            q.offer(new int[]{i, arr[i]}); // [대기순서, 위험도]
            pq.offer(arr[i]); // 위험도 높은 순
        }

        int count = 0;
        while (!q.isEmpty()) {
            int[] recent = q.poll();

            if (!pq.isEmpty()) {
                if (recent[1] >= pq.peek()) {
                    pq.poll();
                    count++;

                    if (recent[0] == M) break;
                }
                else {
                    q.offer(recent);
                }
            }

            else {
                count++;

                if (recent[0] == M) break;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, arr));
    }
}
