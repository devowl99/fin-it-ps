package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0405 {

    static int solution(int N, int K, int[] arr) {
        Set<Integer> ts = new TreeSet<>(Collections.reverseOrder());
        for (int x: arr) {
            ts.add(x);
        }

        List<Integer> lst = new ArrayList<>(ts);

        return lst.get(K-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
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
