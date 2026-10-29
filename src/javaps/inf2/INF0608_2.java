package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0608_2 {

    static int N, M;
    static int[] arr;

    static int solution() {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length-1;
        while (lt<=rt) {
            int mid = (lt+rt)/2;

            if (arr[mid] == M) {
                answer = mid;
                break;
            }
            else if (arr[mid] < M) {
                lt = mid+1;
            }
            else {
                rt = mid-1;
            }
        }

        return answer+1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
}
