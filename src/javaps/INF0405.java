package javaps;

import java.io.*;
import java.util.*;

public class INF0405 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] cards;
    static Set<Integer> treeSet;
    static int sum;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cards = new int[N];
        for (int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        treeSet = new TreeSet<>(Collections.reverseOrder());
        sum = 0;
        combination(0, 0);

        int cnt = 1;
        if (treeSet.size() < K) System.out.println(-1);
        else {
            for (int x : treeSet) {
                if (cnt == K) {
                    System.out.println(x);
                    break;
                }
                cnt++;
            }
        }
    }

    static void combination(int depth, int start){
        if (depth == 3){
            treeSet.add(sum);
            return;
        }

        for (int i=start; i<cards.length; i++){
            sum += cards[i];
            combination(depth+1, i+1);
            sum -= cards[i];
        }
    }
}
