package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0610 {

    static int solution(int N, int C, int[] arr) {
        Arrays.sort(arr);
        int dis = 0;

        // 거리
        int lt = 1; // 최소 (같은 마구간 배치 안되므로)
        int rt = arr[N-1] - arr[0]; // 최대

        while (lt<=rt) {
            int mid = (lt+rt)/2;
            int horse=1; // 여태까지 들어간 말
            int house=arr[0]; // 가장 마지막에 들어간 마구간 좌표

            for (int i=1; i<N; i++) {
                if (arr[i]-house >= mid) {
                    horse++;
                    house = arr[i];
                }

                if (horse == C) break;
            }

            if (horse >= C) {
                dis = mid;
                lt = mid+1;
            }
            else {
                rt = mid-1;
            }
        }

        return dis;
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
