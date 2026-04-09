package javaps;

import java.io.*;
import java.util.*;

// 결정 알고리즘은 범위 (l ~ r) 사이에 반드시 정답이 있다는 확신 하에 사용해야한다.
public class INF0609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] songs;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 곡 수
        M = Integer.parseInt(st.nextToken()); // DVD 수

        songs = new int[N];
        st = new StringTokenizer(br.readLine());
        int maxLen = Integer.MIN_VALUE;
        int totalLen = 0;
        for (int i=0; i<N; i++){
            int nSong = Integer.parseInt(st.nextToken());
            songs[i] = nSong;
            totalLen += nSong;
            if (maxLen < nSong) maxLen = nSong;
        }

        int lt = maxLen;
        int rt = totalLen;
        int mid;
        int ans = 0;
        while (lt <= rt){
            mid = (lt+rt)/2;

            int dvdCount = 1;
            int dvdVolume = 0;
            boolean flag = true;
            for (int song: songs){
                if (dvdVolume+song > mid){
                    dvdCount++;
                    if (dvdCount>M){
                        flag = false;
                        break;
                    }
                    dvdVolume = 0;
                }
                dvdVolume += song;
            }

            if (flag) {
                ans = mid;
                rt = mid-1;
            }
            else lt = mid+1;
        }

        System.out.println(ans);
    }
}
