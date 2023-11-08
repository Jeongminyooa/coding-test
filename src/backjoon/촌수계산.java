package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int targetA = Integer.parseInt(st.nextToken());
        int targetB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[] relative = new int[n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relative[child] = parent;
        }

        int cntA = 0;
        int resultCnt = -1;
        for(int i = targetA; i > 0 && resultCnt == -1; i = relative[i]) {
            int cntB = 0;
            for(int j = targetB; j > 0;  j = relative[j]) {
                if (i == j) {
                    resultCnt = cntA + cntB;
                }
                cntB++;
            }
            cntA++;
        }

        System.out.println(resultCnt);
    }
}
