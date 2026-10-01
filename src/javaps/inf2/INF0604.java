package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0604 {

    static String solution(int S, int N, int[] arr) {
        // S : 캐시 크기
        Deque<Integer> cache = new ArrayDeque<>(); // 덱으로 사용

        for (int x: arr) {
            if (!cache.contains(x)) {
                if (cache.size() == S) cache.pollLast();
            }
            else { // cache.contains(x)
                cache.remove(x);
            }
            cache.offerFirst(x);
        }

        StringBuilder sb = new StringBuilder();
        for (int x: cache) {
            sb.append(x).append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(S, N, arr));
    }
}
