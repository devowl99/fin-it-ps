package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0609 {

    static int solution(int N, int M, int[] arr) {

        int lt = 0;
        int rt = 0;
        for (int x: arr) {
            lt = Math.max(lt, x);
            rt+=x;
        }

        int minVol = Integer.MAX_VALUE; // 최소용량 갱신
        while (lt<=rt) {
            int mid = (lt+rt)/2; // 최대 용량 한도 설정
            int dvdCount = 1;
            int vol = 0; // 현재 dvd 용량

            for (int x: arr) {
                if (vol+x > mid) {
                    dvdCount++;
                    vol = 0;

                    if (dvdCount > M) break;
                }
                vol += x;
            }

            if (dvdCount <= M) {
                minVol = mid;
                rt = mid-1;
            }
            else if (dvdCount > M) {
                lt = mid+1;
            }
        }

        return minVol;
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
