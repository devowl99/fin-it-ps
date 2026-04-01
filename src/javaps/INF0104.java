package javaps;

import java.io.*;

public class INF0104 {
    static int N;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2;

        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++){
            sb2 = new StringBuilder();
            s = br.readLine();
            sb2.append(s).reverse();
            sb.append(sb2).append('\n');
        }

        System.out.println(sb);
    }
}
