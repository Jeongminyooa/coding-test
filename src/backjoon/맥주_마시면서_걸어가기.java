package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 : 맥주 마시면서 걸어가기
 * https://www.acmicpc.net/problem/9205
 */
public class 맥주_마시면서_걸어가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int size = n+2;
            Node[] node = new Node[size];
            for(int j = 0; j < size; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                node[j] = new Node(x, y);
            }

            if(dfs(node, 0, size)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
    }

    public static boolean dfs(Node[] node, int currentIdx, int size) {
        if(currentIdx == size-1) {
            // 축제에 도달했다면 경로 존재
            return true;
        }

        boolean result = false;
        node[currentIdx].visited = true;
        for(int i = 1; i < size && !result; i++) {
            if(!node[i].visited && node[currentIdx].isPossibleDistance(node[i])) {
                result = dfs(node, i, size);
            }
        }
        node[currentIdx].visited = true;

        return result;
    }

    static class Node {
        int x;
        int y;
        boolean visited;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            visited = false;
        }

        public boolean isPossibleDistance(Node node) {
            if(Math.abs(x - node.x) + Math.abs(y - node.y) <= 1000) {
                return true;
            }
            return false;
        }
    }
}
