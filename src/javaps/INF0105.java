package javaps;

import java.io.*;

public class INF0105 {
    static String s;
    static char[] charArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        charArray = s.toCharArray();

        int left = 0;
        int right = s.length()-1;

        while (left < right){
            if (!Character.isLetter(charArray[left])) left++;
            else if (!Character.isLetter(charArray[right])) right--;
            else {
                char tmp;
                tmp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = tmp;
                left++;
                right--;
            }
        }

        s = new String(charArray);
        System.out.println(s);
    }
}
