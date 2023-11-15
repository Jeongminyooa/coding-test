package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 1 : 13460 구슬 탈출 2
 * https://www.acmicpc.net/problem/13460
 */
public class 구슬_탈출_2 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
                if(board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if(board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(dfs(board, rx, ry, bx, by, 0, -1));
    }

    public static int dfs(int[][] board, int rx, int ry, int bx, int by, int cnt, int preDirection) {
        if(board[bx][by] == 'O' || cnt > 10) {
            // 파란구슬이 구멍에 들어갔거나, 빨간구슬이 벽을 넘은 경우
            return -1;
        }  else if(board[rx][ry] == 'O') {
            return cnt;
        }

        // 방금 기울인 방향의 반대는 못하게 해야함.(단방향)
        int minCount = 1000;
        for(int i = 0; i < 4; i++) {
            // 빨간 구슬 이동
            int moveRx = rx;
            int moveRy = ry;
            boolean isFollowB = false;
            while(board[moveRx + dx[i]][moveRy + dy[i]] != '#'
                    && board[moveRx][moveRy] != 'O' && !isFollowB) {
                // 이동할 공간이 있다면 반복
                moveRx += dx[i];
                moveRy += dy[i];

                // 이동하려는 방향에 파란 구슬이 있다면
                if(moveRx == bx && moveRy == by) {
                    isFollowB = true;
                }
            }

            // 파란 구슬 이동
            int moveBx = bx;
            int moveBy = by;
            boolean isFollowR = false;
            while(board[moveBx + dx[i]][moveBy + dy[i]] != '#'
                    && board[moveBx][moveBy] != 'O' && !isFollowR) {
                moveBx += dx[i];
                moveBy += dy[i];

                // 이동하려는 방향에 빨간 구슬이 있다면
                if(moveBx == rx && moveBy == ry) {
                    isFollowR = true;
                }
            }

            if(isFollowB) {
                // 빨간 구슬이 파란 구슬을 따라가는거라면
                moveRx = moveBx - dx[i];
                moveRy = moveBy - dy[i];
            } else if(isFollowR) {
                // 파란 구슬이 빨간 구슬을 따라가는거라면
                if(board[moveRx][moveRy] == 'O') {
                    // 따라서 구멍에 들어가버림
                    moveBx = moveRx;
                    moveBy = moveRy;
                } else {
                    moveBx = moveRx - dx[i];
                    moveBy = moveRy - dy[i];
                }
            }
            int directionCount = dfs(board, moveRx, moveRy, moveBx, moveBy, cnt+1, i);
            if(minCount > directionCount && directionCount != -1) {
                minCount = directionCount;
            }
        }
        return minCount == 1000 ? -1 : minCount;
    }
}