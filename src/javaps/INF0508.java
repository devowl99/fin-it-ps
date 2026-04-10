package javaps;

import java.io.*;
import java.util.*;

public class INF0508 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static Queue<Person> q;
    static int point;

    static class Person {
        int order, rate;

        Person(int order, int rate){
            this.order = order;
            this.rate = rate;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>();
        point = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            int rec = Integer.parseInt(st.nextToken());
            q.offer(new Person(i, rec));
        }

        int count = 0;
        while (!q.isEmpty()){
            Person p = q.poll();
            for (Person x: q){
                if (x.rate > p.rate){ // 더 위험도 높은게 있으면 다시 들어가
                    q.offer(p);
                    p = null;
                    break;
                }
            }

            if (p != null){
                count++;
                if (p.order == M) break;
            }
        }

        System.out.println(count);
    }
}
