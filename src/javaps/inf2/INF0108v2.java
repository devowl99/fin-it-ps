package javaps.inf2;

import java.io.*;

public class INF0108v2 {

    static String solution(String str) {
        str = str.toUpperCase();

        int lt = 0;
        int rt = str.length()-1;
        String answer = "YES";

        while (lt < rt) {
            if (str.charAt(lt) < 'A' || 'Z' <str.charAt(lt)) lt++;
            else if (str.charAt(rt) < 'A' || 'Z' < str.charAt(rt)) rt--;
            else {
                if (str.charAt(lt) != str.charAt(rt)) {
                    answer = "NO";
                    break;
                }
                lt++;
                rt--;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
