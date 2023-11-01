package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 1 : 1736 쓰레기 치우기
 * 링크 : https://www.acmicpc.net/problem/1736
 */
public class 쓰레기_치우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            count += clean(i, n, m, room, 0, false);
        }

        System.out.println(count);
    }

    public static int clean(int row, int n, int m, int[][] room, int trashIdx, boolean isClean) {
        if(row >= n) {
            return isClean ? 1 : 0;
        }

        for(int j = trashIdx; j < m; j++) {
            if(room[row][j] == 1) {
                // 쓰레기 치우기
                isClean = true;
                room[row][j] = 0;
                trashIdx = j;
            }
        }

        return clean(++row, n, m, room, trashIdx, isClean);
    }
}
