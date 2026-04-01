package javaps;

import java.io.*;
import java.util.*;

public class INF0103 {
    static String s, longest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        longest = "";
        while (st.hasMoreTokens()){
            s = st.nextToken();
            if (longest.length() < s.length()) longest = s;
        }

        System.out.println(longest);
    }
}
