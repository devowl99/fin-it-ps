package javaps;

import java.io.*;

public class INF0111 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        str = br.readLine();
        char[] charArray = str.toCharArray();
        int count = 1;
        char recent = charArray[0];
        for (int i=1; i<charArray.length; i++){
            if (recent != charArray[i]) {
                if (count != 1) sb.append(recent).append(count);
                else sb.append(recent);
                recent = charArray[i];
                count = 0;
            }
            count++;
        }
        sb.append(recent).append(count);
        System.out.println(sb);
    }
}
