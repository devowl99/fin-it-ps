package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0808 {

    static String solution(int n, int f) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, f));
    }
}
