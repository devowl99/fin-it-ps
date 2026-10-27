package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0606_2 {

    static int N;
    static int[] arr;

    static String solution() {

        List<Integer> lst = new ArrayList<>();

        for (int x: arr) {
            lst.add(x);
        }
        Collections.sort(lst);

        StringBuilder sb = new StringBuilder();
        int count = 2;
        for (int i=0; i<N; i++) {
            if (arr[i] != lst.get(i)) {
                sb.append(i+1).append(' ');
                count--;

                if (count == 0) break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
}
