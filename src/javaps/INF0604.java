package javaps;

import java.io.*;
import java.util.*;

public class INF0604 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int S, N;
    static int[] works;
    static int[] cache;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cache = new int[S]; // 캐시
        works = new int[N]; // 작업
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++){
            works[n] = Integer.parseInt(st.nextToken());
        }

        int idx;
        for (int work: works){
            idx = -1;
            for (int i=0; i<S; i++){ // 캐시 안에 작업 있었음
                if (work == cache[i]){
                    idx = i;
                    break;
                }
            }

            if (idx != -1) { // cache hit (빠졌다가 0으로 다시 들어옴)
                for (int i = idx; 0 < i; i--) {
                    cache[i] = cache[i-1];
                }
            }
            else { // cache miss (하나 빠지고 새로 들어옴)
                for (int i=S-1; 0<i; i--){
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = work;
        }

        StringBuilder sb = new StringBuilder();
        for (int x: cache){
            sb.append(x).append(' ');
        }

        System.out.println(sb);
    }
}
