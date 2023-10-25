package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 골드 5 : 2212 센서
 * 링크 : https://www.acmicpc.net/problem/2212
 */
public class 센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] coordinate = new int[n];
        for(int i = 0; i < n; i++) {
            coordinate[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coordinate); // 좌표 정렬

        Integer[] distance = new Integer[n-1];
        // 거리 차 구하기
        for(int i = 0; i < n-1; i++) {
            distance[i] = coordinate[i+1] - coordinate[i];
        }

        // 구한 거리 차를 내림차순
        int result = 0;
        Arrays.sort(distance, Collections.reverseOrder());
        for(int i = k-1; i < n-1; i++) {
            result += distance[i];
        }

        System.out.println(result);
    }
}
