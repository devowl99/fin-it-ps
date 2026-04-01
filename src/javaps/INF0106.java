package javaps;

import java.io.*;
import java.util.*;

public class INF0106 {
    static String s;
//    static Set<Character> linkedset;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

//        linkedset = new LinkedHashSet<>();
//        for (char x: s.toCharArray()){
//            linkedset.add(x);
//        }
//
        String answer = "";
//        for (char x: linkedset){
//            answer += x;
//        }

        for (int i=0; i<s.length(); i++){
            if (s.indexOf(s.charAt(i)) == i) answer += s.charAt(i);
        }

        System.out.println(answer);
    }
}
