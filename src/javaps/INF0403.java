package javaps;

import java.io.*;
import java.util.*;

public class INF0403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] arr;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();
        // 초기 값 저장
        StringBuilder sb = new StringBuilder();
        int key = 0;
        for (key=0; key<K; key++){
            map.put(arr[key], map.getOrDefault(arr[key], 0)+1);
        }
        sb.append(map.size()).append(' ');
        // 슬라이딩 윈도우
        int l = 0;
        for (int r=key; r<N; r++){
            l = r-key;
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            map.put(arr[l], map.get(arr[l])-1);
            if (map.get(arr[l]) == 0) map.remove(arr[l]);

            sb.append(map.size()).append(' ');
        }

        System.out.println(sb);
    }
}