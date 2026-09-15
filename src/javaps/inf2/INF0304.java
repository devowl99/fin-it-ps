package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0304 {

    static int solution(int n, int m, int[] arr) {

        if (n==1) {
            if (arr[0] == m) return 1;
            else return 0;
        }

        int p1 = 0;
        int p2 = 1;
        int sum = arr[p1] + arr[p2];
        int count = 0;
        while (p2<n) {
            if (sum == m) {
                count++;

                if (p2+1<n) sum += arr[++p2];
                else break;
            }
            else if (sum < m) {
                if (p2+1<n) sum += arr[++p2];
                else break;
            }
            else { // if (sum > m)
                sum -= arr[p1++];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }
}
