package javaps;

import java.io.*;
import java.util.*;

public class INF0210 {
    static int N;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int count;

    // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N+2][N+2];
        for (int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println(Arrays.deepToString(map)); // 출력 테스트

        count = 0;
        for (int y=1; y<N+1; y++){
            for (int x=1; x<N+1; x++){
                boolean isIt = true;
                for (int d=0; d<4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (map[y][x] <= map[ny][nx]) {
                        isIt = false;
                        break;
                    }
                }
                if (isIt) count++;
            }
        }

        System.out.println(count);
    }
}
