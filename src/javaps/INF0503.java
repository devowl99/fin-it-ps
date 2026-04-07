package javaps;

import java.io.*;
import java.util.*;

public class INF0503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static Queue<Integer>[] q;
    static Deque<Integer> basket;
    static int M;
    static int[] moves;
    static int count;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        q = new ArrayDeque[N+1];
        for (int n=1; n<=N; n++){
            q[n] = new ArrayDeque<>();
        }

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int n = 1; n <= N; n++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp != 0) q[n].offer(tmp);
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        moves = new int[M];
        for (int m=0; m<M; m++){
            moves[m] = Integer.parseInt(st.nextToken());
        }

        basket = new ArrayDeque<>();

        count = 0;
        for (int choice: moves){
            if (!q[choice].isEmpty()) {
                int p = q[choice].poll();
                if (!basket.isEmpty() && basket.peek() == p){
                    count+=2;
                    basket.pop();
                }
                else basket.push(p);
            }
        }

        System.out.println(count);
    }
}
