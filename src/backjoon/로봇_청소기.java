package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 : 14503 로봇 청소기
 * 링크 : https://www.acmicpc.net/problem/14503
 */
public class 로봇_청소기 {
    // 북동남서
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = clean(startX, startY, d ,room);

        System.out.println(count);
    }

    public static int clean(int x, int y, int d, int[][] room) {
        if(room[x][y] == 1) {
            return 1;
        }

       room[x][y] = -1;
       boolean isClean = true;
       for(int i = 0; i < 4; i++) {
           if(room[x + dx[i]][y + dy[i]] == 0) {
               isClean = false;
           }
       }

       int moveX = x;
       int moveY = y;
       if(isClean) {
           if(d == 0 || d == 1) {
               moveX = x + dx[d+2];
               moveY = y + dy[d+2];
           } else {
               moveX = x + dx[d-2];
               moveY = y + dy[d-2];
           }
           return clean(moveX, moveY, d ,room);
       } else {
           while(room[moveX][moveY] != 0) {
               d = (d - 1) >= 0 ? (d - 1) : 3;
               moveX = x + dx[d];
               moveY = y + dy[d];
           }
           return 1 +  clean(moveX, moveY, d ,room);
       }

    }
}
