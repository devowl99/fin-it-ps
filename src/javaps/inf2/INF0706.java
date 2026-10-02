package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0706 {

    static List<Integer> subset;
    static int N;

    static void solution(int N) {
        subset = new ArrayList<>();
        subset(0);
    }

    static void subset(int i) {
        if (i == N) {
            for (int x: subset) {
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }

        subset.add(i+1);
        subset(i+1);
        subset.remove(subset.size()-1);

        subset(i+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        solution(N);
    }
}
