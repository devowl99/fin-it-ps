package javaps;

import java.io.*;
import java.util.*;

public class INF0211 {
    static int n;
    static int[][] chart;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int maxCount;
    static int president;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        chart = new int[n+1][5+1];

        for (int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=5; j++){
                chart[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println(Arrays.deepToString(chart));

        maxCount = -1;
        president = 0;
        for (int student = 1; student<=n; student++){
            int count = 0;
            for (int nextStudent = 1; nextStudent<=n; nextStudent++){
                if (student == nextStudent) continue;

                for (int grade = 1; grade<=5; grade++) {
                    if (chart[student][grade] == chart[nextStudent][grade]) {
                        count++;
                        break;
                    }
                }
            }

            if (maxCount < count){
                president = student;
                maxCount = count;
            }
        }

        System.out.println(president);
    }
}
