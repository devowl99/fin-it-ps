package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0605_2 {

    static int N;

    static char solution(int[] arr) {

        List<Integer> lst = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            lst.add(arr[i]);
        }

        for (int i=0; i<arr.length; i++) {
            if (lst.indexOf(arr[i]) != i) {
                return 'D';
            }
        }

        return 'U';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }
}
