package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 실버 1 : 2667 단지번호붙이기
 * https://www.acmicpc.net/problem/2667
 */
public class 단지번호붙이기 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        List<Integer> house = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    house.add(bfs(map, visited, i, j, n));
                }
            }
        }

        Collections.sort(house);
        System.out.println(house.size());
        for(int i = 0; i < house.size(); i++) {
            System.out.println(house.get(i));
        }
    }

    public static int bfs(int[][] map, boolean[][] visited, int x, int y, int n) {
        visited[x][y] = true;
        int result = 0;
        for(int i = 0; i < 4; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if(tx >= 0 && tx < n && ty >= 0 && ty < n) {
                if (!visited[tx][ty] && map[tx][ty] == 1) {
                    result += bfs(map, visited, tx, ty, n);
                }
            }
        }

        return 1 + result;
    }
}
