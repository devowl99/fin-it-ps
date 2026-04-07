package javaps;

import java.io.*;
import java.util.*;

public class INF0505 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;
    static Deque<Character> dq;
    static int answer;

    public static void main(String[] args) throws IOException {

        str = br.readLine();
        dq = new ArrayDeque<>();

        // ( 들어오면 잠깐 저장해두고 기다렸다가, 다음이 )가 아니면 비우고 저장
        // ( 저장했는데 다음이 바로 ) 면 현재 스택에 남은 값들 answer+=
        answer = 0;
        boolean lazer = false;
        for (char x: str.toCharArray()){
            if (x == '('){
                dq.push('(');
                lazer = true;
            }
            else if (x == ')'){
                dq.pop();
                if (lazer) {
                    answer += dq.size();
                    lazer = false;
                }
                else answer++;
            }
        }

        System.out.println(answer);
    }
}
