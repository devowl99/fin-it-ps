package javaps;

import java.io.*;
import java.util.*;

public class INF0207 {
    static int N;
    static int[] OXscore;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        OXscore = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        res = 0;
        int cum = 0;
        for (int n=0; n<N; n++){
            // 0은 틀린 경우, 1은 맞은 경우
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == 1){
                cum++;
                res += cum;
            }
            else if (tmp == 0)
                cum = 0;
        }

        System.out.println(res);
    }
}
