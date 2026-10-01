package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0601n2n3 {

    static String solution(int[] arr) {
        List<Integer> lst = new ArrayList<>();

        for (int x: arr) {
            lst.add(x);
        }
        Collections.sort(lst);
        // Collections.sort(lst, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int x: lst) {
            sb.append(x).append(' ');
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }
}
