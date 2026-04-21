package javaps;

import java.io.*;
import java.util.*;

public class INF0901 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static class People {
        int h, w;

        People(int h, int w){
            this.h = h;
            this.w = w;
        }
    }

    static List<People> pLst;
    static int count;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        pLst = new ArrayList<>();
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pLst.add(new People(h, w));
        }

        count=0;
        for (int i=0; i<pLst.size(); i++){
            People cur = pLst.get(i);

            boolean flag = true;
            for (int j=0; j<pLst.size(); j++){
                if (j==i) continue;

                if (cur.h<pLst.get(j).h && cur.w<pLst.get(j).w){
                    flag = false;
                    break;
                }
            }

            if (flag) count++;
        }

        System.out.println(count);
    }
}
