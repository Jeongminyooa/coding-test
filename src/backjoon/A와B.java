package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 : 12904 A와 B
 * 링크 : https://www.acmicpc.net/problem/12904
 */
public class A와B {
    public static void main(String[] args) throws IOException {
        // 연산 1 : 뒤에 A 추가
        // 연산 2 : 뒤집고 뒤에 B 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String target = st.nextToken();

        System.out.println(checkPossibility(input, target));
    }

    public static int checkPossibility(String input, String target) {
        while(target.length() > input.length()) {
            int targetLength = target.length();

            if(target.charAt(targetLength - 1) == 'A') {
                target = target.substring(0, targetLength - 1);
            } else {
                target = target.substring(0, targetLength - 1);
                target = new StringBuffer(target).reverse().toString();
            }
        }

        return target.equals(input) ? 1 : 0;
    }

}
