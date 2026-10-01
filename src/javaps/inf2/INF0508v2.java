package javaps.inf2;

import java.io.*;
import java.util.*;

public class INF0508v2 {

    static class Person {
        int id;
        int rate;

        Person(int id, int rate) {
            this.id = id;
            this.rate = rate;
        }
    }

    static int solution(int N, int M, int[] arr) {

        Queue<Person> chart = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<N; i++) {
            chart.offer(new Person(i, arr[i]));
            pq.offer(arr[i]);
        }

        int count = 0;
        while (!chart.isEmpty()) {
            Person p = chart.poll();

            if (p.rate == pq.peek()) {
                count++;
                pq.poll();

                if (p.id==M) break;
            }
            else {
                chart.offer(p);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int n=0; n<N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, arr));
    }
}
