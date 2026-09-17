package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0305 {

    static int solution(int n) {

        int count = 0;

        int range = n/2+1;
        int lt = 0;
        int sum = 0;
        for (int rt=0; rt<=range; rt++) {
            sum += rt;

            while (sum > n) {
                sum -= ++lt;
            }

            if (sum==n) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
