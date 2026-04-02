package javaps;

import java.io.*;
import java.util.*;

public class INF0112 {
    static int num;
    static String code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        code = br.readLine();

        String[] stringArray = new String[num];
        for (int i=0; i<num; i++){
            String tmp = code.substring(i*7, i*7+7);
            StringBuilder bin = new StringBuilder();
            for (int j=0; j<tmp.length(); j++){
                if (tmp.charAt(j) == '#'){
                    bin.append(1);
                }
                else if (tmp.charAt(j) == '*'){
                    bin.append(0);
                }

                stringArray[i] = bin.toString();
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i=0; i<num; i++){
            int ans = Integer.parseInt(stringArray[i], 2);
            answer.append((char)ans);
        }

        System.out.println(answer);
    }
}
