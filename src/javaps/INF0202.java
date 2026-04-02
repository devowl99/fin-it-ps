package javaps;

import java.io.*;
import java.util.*;

public class INF0202 {
    static int n;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        heights = new int[n];
        for (int i=0; i<n; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int maxH = heights[0];
        int count = 1;
        for (int i=1; i<n; i++){
            if (maxH < heights[i]) {
                count++;
                maxH = heights[i];
            }
        }

        System.out.println(count);
    }
}
