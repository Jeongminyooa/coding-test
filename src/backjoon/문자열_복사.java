package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 5 : 2195 문자열 복사
 * 링크 : https://www.acmicpc.net/problem/2195
 * 일치하는 S의 부분집합과 P의 부분집합을 가장 긴 것부터 찾아내는 방식으로 구현했다가 반례
 * S : aababcefcefd
 * P : aabcefd
 *  출력은 3, 정답은 2
 */
public class 문자열_복사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();

        st = new StringTokenizer(br.readLine());
        String P = st.nextToken();

        int count = 0;
        int idx = 0;
        for(int i = 0; i < P.length(); i++) {
            if(S.indexOf(P.substring(idx, i+1)) != -1) {
                continue;
            }
            idx = i;
            i--;
            count++;
        }

        // 마지막까지 카운트 포함
        System.out.println(count+1);
    }
}
