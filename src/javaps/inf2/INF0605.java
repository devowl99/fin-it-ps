package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0605 {

    static char solution(int N, int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int x: arr) {
            set.add(x);
        }

        if (set.size()==N) return 'U';
        else return 'D';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));
    }
}
