package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 골드 4 : 1461 도서관
 * 링크 : https://www.acmicpc.net/problem/1461
 */
public class 도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int pos = Integer.parseInt(st.nextToken());
            if(pos > 0) {
                positiveList.add(pos);
            } else {
                negativeList.add(pos);
            }
        }

        // 내림차순 정렬
        Collections.sort(positiveList, Collections.reverseOrder());
        Collections.sort(negativeList);

        int sum = 0;
        int max = 0;
        if(positiveList.size() == 0) {
            max = negativeList.get(0);
        } else if(negativeList.size() == 0) {
            max = positiveList.get(0);
        } else if(positiveList.get(0) > Math.abs(negativeList.get(0))) {
            max = positiveList.get(0);
        } else {
            max = negativeList.get(0);
        }

        for(int i = 0; i < positiveList.size(); i++) {
            if(i % m == 0) {
                sum += positiveList.get(i) == max ? positiveList.get(i) : (positiveList.get(i) * 2);
            }
        }

        for(int i = 0; i < negativeList.size(); i++) {
            if(i % m == 0) {
                sum += negativeList.get(i) == max ? Math.abs(negativeList.get(i)) : Math.abs(negativeList.get(i) * 2);
            }
        }

        System.out.println(sum);
    }
}
