package javaps;

import java.io.*;

public class INF0703 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        recursive(1, 1);
    }

    static void recursive(int count, int total){
        if (count > N) {
            System.out.println(total);
            return;
        }

        recursive(count+1, total*count);
    }
}
