package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0608 {

    static int solution(int N, int M, int[] arr) {
        Arrays.sort(arr);

        int answer = 0;
        int lt = 0;
        int rt = arr.length-1;
        int mid;
        while (lt<=rt) {
            mid = (lt+rt)/2;

            if (arr[mid] == M) {
                answer = mid+1;
                break;
            }
            else if (M < arr[mid]) {
                rt = mid-1;
            }

            else { // arr[mid] < M
                lt = mid+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, arr));
    }
}
