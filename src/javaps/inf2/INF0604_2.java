package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0604_2 {

    static int S, N;

    static String solution(int[] arr) {

        Queue<Integer> cache = new ArrayDeque<>();

        for (int work: arr) {
            if (cache.contains(work)) {
                cache.remove(work);
            }
            else {
                if (cache.size() == S) cache.poll();
            }

            cache.offer(work);
        }

        int[] newArr = new int[S];
        int s = S-1;
        for (int c: cache) {
            newArr[s] = c;
            s--;
        }

        StringBuilder sb = new StringBuilder();
        for (int a: newArr) {
            sb.append(a).append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }
}
