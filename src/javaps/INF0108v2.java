package javaps;

import java.io.*;

public class INF0108v2 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        str = br.readLine();
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = sb.append(str).reverse().toString();

        if (str.equals(tmp)) System.out.println("YES");
        else System.out.println("NO");
    }
}
