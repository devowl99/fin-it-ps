package javaps;

import java.io.*;
import java.util.*;

public class INF0706 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Integer> subset;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        subset = new ArrayList<>();
        dfs(1);

    }

    static void dfs(int i){
        if (i > N) {
            if (!subset.isEmpty()) {
                for (int s : subset) System.out.print(s + " ");
                System.out.println();
            }
            else System.out.println(0); // 공집합 0
            return;
        }

        // 1. 선택하는 경우
        subset.add(i);
        dfs(i+1);
        // 백트래킹
        subset.remove(subset.size()-1);

        // 2. 선택하지 않는 경우
        dfs(i+1);
    }
}
