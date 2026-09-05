package javaps.inf2;

import java.io.*;

public class INF0104 {

    static String[] solution(int N, String[] strArr) {
        StringBuilder sb;

        String[] newArr = new String[N];
        for (int n=0; n<N; n++){
            sb = new StringBuilder();
            newArr[n] = sb.append(strArr[n]).reverse().toString();
            //sb.setLength(0);
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

        for (int n=0; n<N; n++){
            System.out.println(newArr[n]);
        }
    }
}
