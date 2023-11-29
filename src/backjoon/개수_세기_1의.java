package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 2 : 9527 1의 개수 세기
 * https://www.acmicpc.net/problem/9527
 */
public class 개수_세기_1의 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int cnt = 0;
        for(long i = a; i <= b; i++) {
            String binaryString = Long.toBinaryString(i);
            for(int j = 0; j < binaryString.length(); j++) {
                cnt += binaryString.charAt(j) - '0';
            }
        }

        System.out.println(cnt);

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }
}
