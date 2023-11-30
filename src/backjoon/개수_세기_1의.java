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

        long[] dp = new long[55];
        initSet(dp);

        long result = calculateCount(b, dp) - calculateCount(a-1, dp);
        System.out.println(result);
    }

    public static void initSet(long[] dp) {
        dp[0] = 1;
        for(int i = 1; i < 55; i++) {
            dp[i] = dp[i-1] * 2 + (1L << i);
        }
    }
    public static long calculateCount(long n, long[] dp) {
        // n보다 작은 2^n의 최댓값 구하기
        long count = n & 1; // n이 1이라면 count 초기화를 1로 해놓아야 한다. for문에서 카운팅 안된다.
        int max = (int) (Math.log(n) / Math.log(2));
        for(int i = max; i > 0; i--) {
            if((n & (1L << i)) != 0L) {
                count += dp[i-1] + (n - (1L << i) + 1);
                n -= (1L << i); // 비트 이동시키기
            }
        }

        return count;
    }
}
