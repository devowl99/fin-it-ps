package javaps;

import java.io.*;
import java.util.*;

public class INF0805 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer> coins;
    static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine()); // 동전의 종류 개수
        coins = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            coins.add(Integer.parseInt(st.nextToken()));
        }
        coins.sort(Collections.reverseOrder());

        M = Integer.parseInt(br.readLine()); // 거슬러 줄 금액

        dfs(0, 0);

        System.out.println(minCount);
    }

    static void dfs(int count, int cost) {
        if (cost>M) return;
        if (count >= minCount) return;

        if (cost==M){
            minCount = count;
            return;
        }

        for (int x: coins){
            dfs(count+1, cost+x);
        }
    }
}
