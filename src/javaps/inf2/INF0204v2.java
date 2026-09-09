package javaps.inf2;

import java.io.*;

public class INF0204v2 {

    static StringBuilder solution(int N) {

        StringBuilder sb = new StringBuilder();

        int a, b, c;
        a = b = 1;

        sb.append(a).append(' ').append(b).append(' ');
        for (int i=2; i<N; i++) {
            c = a+b;
            sb.append(c).append(' ');

            a=b;
            b=c;
        }

        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
