package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] value = new int[n];

        int[] dp = new int[100001];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);
        for(int i = 0; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                if(j >= value[i]) {
                    if(j % value[i] == 0) {
                        dp[j] = j / value[i];
                    } else {
                        int index = value[i];
                        while(j > index) {
                            int target = dp[index] + dp[j - index];
                            if(dp[j - index] != 0 && (dp[j] == 0 || dp[j] > target)) {
                                dp[j] = target;
                            }
                            index += value[i];
                        }
                    }
                }
            }
        }

        System.out.println(dp[k] > 0 ? dp[k] : -1);
    }
}
