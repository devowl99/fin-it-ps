package javaps;

import java.io.*;
import java.util.*;

public class INF0609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] songs;
    static int volume;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 곡 수
        M = Integer.parseInt(st.nextToken()); // DVD 수

        songs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            songs[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0; // 총 노래 길이
        for (int i=0; i<N; i++){
            total += songs[i];
        }
        // 총 노래 길이/3 에서부터 시작하자

    }
}
