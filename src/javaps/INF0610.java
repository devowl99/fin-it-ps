package javaps;

import java.io.*;
import java.util.*;

public class INF0610 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, C;
    static int[] horseHouse;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마구간 수
        C = Integer.parseInt(st.nextToken()); // 말 수

        st = new StringTokenizer(br.readLine());
        horseHouse = new int[N]; // 마구간의 좌표
        for (int n=0; n<N; n++){
            horseHouse[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(horseHouse);

        int rt = horseHouse[N-1] - horseHouse[0]; // 두 말의 거리 최대
        int lt = 1; // 두 말의 거리 최소
        int answer=0;
        while (lt <= rt){
            int mid = (lt+rt)/2; // 가장 가까운 두 말의 거리

            int checkIn = horseHouse[0];
            int count = 1;
            for (int i=1; i<N; i++){
                if (horseHouse[i] - checkIn >= mid){
                    count++;
                    checkIn = horseHouse[i];
                }
            }

            if (count >= C) {
                answer = mid;
                lt = mid+1;
            }
            else rt = mid-1;
        }

        System.out.println(answer);
    }
}
