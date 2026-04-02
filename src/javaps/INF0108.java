package javaps;

import java.io.*;

public class INF0108 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        int n = str.length();
        str = str.toUpperCase();
        char[] charArray = str.toCharArray();

        int left = 0;
        int right = n-1;
        String answer = "YES";
        while (left < right){
            if ((charArray[left]<'a' || 'z'<charArray[left]) && (charArray[left]<'A' || 'Z'<charArray[left])){
                left++;
            }

            else if ((charArray[right]<'a' || 'z'<charArray[right]) && (charArray[right]<'A' || 'Z'<charArray[right])){
                right--;
            }

            else {
                if (charArray[left] != charArray[right]){
                    answer = "NO";
                    break;
                }
                left++;
                right--;
            }
        }

        System.out.println(answer);
    }
}
