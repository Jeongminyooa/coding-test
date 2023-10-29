package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 2 : 2885 초콜릿 식사
 * 링크 : https://www.acmicpc.net/problem/2885
 */
public class 초콜릿_식사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int minSize = 1;
        while(minSize < k) {
            minSize *= 2;
        }

        int count = 0;
        int target = 0;
        int num = minSize;
        while(k != target) {
            // k보다 작지만 가장 큰 제곱근
            target += num;
            if(target > k) {
                target = target - num;
            }
            count++;
            num /= 2;
        }

        System.out.println(minSize + " " + (count-1));
    }
}
