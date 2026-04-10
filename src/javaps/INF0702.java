package javaps;

import java.io.*;

public class INF0702 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        recursive(N);
    }

    static void recursive(int i){
        if (i/2 == 0) {
            System.out.print(i);
            return;
        }

        recursive(i/2);
        System.out.print(i%2);
    }
}
