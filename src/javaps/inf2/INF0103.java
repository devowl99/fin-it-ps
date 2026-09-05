package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0103 {

    static String solution(String str){
        StringTokenizer st = new StringTokenizer(str);

        String answer = "";
        while (st.hasMoreTokens()){
            String next = st.nextToken();
            if (answer.length() < next.length()) answer = next;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
