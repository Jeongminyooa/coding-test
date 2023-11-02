package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 4 : 9082 지뢰찾기
 * 링크 : https://www.acmicpc.net/problem/9082
 */
public class 지뢰찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            String landMine = st.nextToken();
            int[] cntOfLandMine = new int[length];
            int sum = 0;

            for(int j = 0; j < length; j++) {
                cntOfLandMine[j] = Integer.parseInt(String.valueOf(landMine.charAt(j)));
                sum += cntOfLandMine[j];
            }

            st = new StringTokenizer(br.readLine(), "");
            String posOfLandMine = st.nextToken();

            int count = 0;
            while(sum > 0) {
                if(sum - 3 >= 2) {
                    sum -= 3;
                } else {
                    sum -= 2;
                }
                count++;
            }
            result[i] = count;
        }

        for(int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
