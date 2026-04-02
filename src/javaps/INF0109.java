package javaps;

import java.io.*;

public class INF0109 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        str = str.replaceAll("[^0-9]", "");

//        while (str.charAt(0) == '0') {
//            str = str.substring(1);
//        }
        System.out.println(Integer.parseInt(str));
    }
}
