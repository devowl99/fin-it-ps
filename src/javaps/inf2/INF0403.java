package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0403 {

    static String solution(int N, int K, int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<K; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        sb.append(map.size()).append(' ');

        int lt = 0;
        for (int rt=K; rt<N; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);

            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            }
            else {
                map.put(arr[lt], map.get(arr[lt])-1);
            }

            sb.append(map.size()).append(' ');
            lt++;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, arr));
    }
}
