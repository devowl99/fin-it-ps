// 정렬 안쓰고 품
package javaps;

import java.io.*;
import java.util.*;

public class INF0605v2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Set<Integer> set;
    static char answer;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        answer = 'U';
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            int next = Integer.parseInt(st.nextToken());
            if (set.contains(next)) {
                answer = 'D';
                break;
            }
            set.add(next);
        }

        System.out.println(answer);
    }
}
