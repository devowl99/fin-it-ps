package javaps.inf2;

import java.io.*;

public class INF0104v2 {

    static String[] solution(int N, String[] strArr) {
        String[] newArr = new String[N];

        int i=0;
        for (String s: strArr) {
            newArr[i] = new StringBuilder(s).reverse().toString();

            i++;
        }

        return newArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] strArr = new String[N];
        for (int n=0; n<N; n++){
            strArr[n] = br.readLine();
        }

        String[] newArr = solution(N, strArr);

        for (String s: newArr){
            System.out.println(s);
        }
    }
}
