package javaps;

import java.io.*;
import java.util.*;

public class INF0212 {
    static int N, M; // 학생 수, 수학테스트 횟수
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] result;
    static int count;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M+1][N+1];
        for (int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++){
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        for (int mento=1; mento<=N; mento++){
            for (int menti=1; menti<=N; menti++){
                if (mento == menti) continue;

                int mentoGrade = 0;
                int mentiGrade = 0;
                boolean flag = true;
                for (int i=1; i<=M; i++){ // 몇 회차?
                    for (int j=1; j<=N; j++){ // 해당 회차에서 멘토가 멘티를 앞서는가?
                        if (result[i][j] == mento) mentoGrade = j;
                        if (result[i][j] == menti) mentiGrade = j;
                    }
                    if (mentoGrade > mentiGrade) { // 등수는 낮을수록 좋음
                        flag = false;
                        break;
                    }
                }
                if (flag) count++;
            }
        }

        System.out.println(count);
    }
}
