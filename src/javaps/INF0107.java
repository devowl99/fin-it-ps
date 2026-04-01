package javaps;

import java.io.*;

public class INF0107 {
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        s = br.readLine();
//        s = s.toUpperCase();

        if (s.equalsIgnoreCase(sb.append(s).reverse().toString())){
            System.out.println("YES");
        }
        else System.out.println("NO");
    }
}
