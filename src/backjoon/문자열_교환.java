package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 골드 5 : 1522 문자열 교환
 * https://www.acmicpc.net/problem/1522
 */
public class 문자열_교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        int cntA = 0;
        for(int i = 0; i < input.length; i++) { if(input[i] == 'a') cntA++; }

        int minCount = 1001;
        for(int i = 0; i < input.length; i++) {
            int cntB = 0;
            for(int j = i; j < (i+cntA); j++) {
                int tempIndex = j;
                if(tempIndex >= input.length) {
                    tempIndex = j - input.length;
                }

                if(input[tempIndex] == 'b') {
                    cntB++;
                }
            }

            if(minCount > cntB) {
                minCount = cntB;
            }
        }
        System.out.println(minCount);
    }

}
