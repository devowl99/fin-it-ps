package javaps.inf2;

import java.io.*;

public class INF0105 {

    static String solution(String str) {

        char[] cArr = str.toCharArray();

        int l = 0;
        int r = str.length()-1;
        char tmp;
        while (l<r){

            if (!Character.isLetter(cArr[l])) l++;

            else if (!Character.isLetter(cArr[r])) r--;

            else {
                tmp = cArr[l];
                cArr[l] = cArr[r];
                cArr[r] = tmp;

                l++;
                r--;
            }
        }

        return new String(cArr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }

}
