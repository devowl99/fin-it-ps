package javaps;

import java.io.*;

public class INF0112v2 {
    static int num;
    static String code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        num = Integer.parseInt(br.readLine());
        code = br.readLine();

        for (int i=0; i<num; i++){
            String tmp = code.substring(0, 7).replace('#', '1').replace("*", "0");
            sb.append((char)Integer.parseInt(tmp, 2));
            code = code.substring(7);
        }

        System.out.println(sb);
    }
}
