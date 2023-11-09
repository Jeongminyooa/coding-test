package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 : 2573 빙산
 * https://www.acmicpc.net/problem/2573
 */
public class 빙산 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] iceBerg = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                iceBerg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        int cnt = 1;
        while(cnt == 1) {
            cnt = 0;
            boolean[][] visited = new boolean[n][m];
            for(int i = 1; i < n-1; i++) {
                for(int j = 1; j < m-1; j++) {
                    if(iceBerg[i][j] > 0 && !visited[i][j]) {
                        dfs(iceBerg, i, j, n, m, visited);
                        cnt++;
                    }
                }
            }
            year++;
        }

        if(cnt > 1) {
            System.out.println(year-1);
        } else if (cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(year);
        }

    }

    public static void dfs(int[][] iceBerg, int x, int y, int n, int m, boolean[][] visited) {
        if(x < 1 || x >= n-1 || y < 1 || y >= m-1) {
            return;
        }

        if(iceBerg[x][y] == 0) return;

        visited[x][y] = true;

        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(iceBerg[tx][ty] == 0 && !visited[tx][ty]) {
                cnt++;
            } else if(iceBerg[tx][ty] > 0 && !visited[tx][ty]) {
                dfs(iceBerg, tx, ty, n, m, visited);
            }
        }

        iceBerg[x][y] = (iceBerg[x][y] - cnt) < 0 ? 0 : (iceBerg[x][y] - cnt);

        return;
    }
}
