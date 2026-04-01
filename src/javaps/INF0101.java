package javaps;

import java.io.*;
import java.util.*;

public class INF0101 {
    static String s1, s2;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s1 = br.readLine().toUpperCase();
        s2 = br.readLine().toUpperCase();
        char c2 = s2.charAt(0);

        for (int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);

            if (c1 == c2) count++;
        }

        System.out.println(count);
    }
}
