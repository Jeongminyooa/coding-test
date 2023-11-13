package programmers;

/**
 * 동적계획법 : 도둑질
 * https://school.programmers.co.kr/learn/courses/30/lessons/42897
 */
public class 도둑질 {
    public static void main(String[] args) {
        int[] money = {1, 2, 3, 1};
        System.out.println(solution(money));
    }

    public static int solution(int[] money) {
        int size = money.length;
        int[] dp = new int[size];

        // 1번집을 무조건 털고, 마지막 집은 무조건 안터는 경우
        dp[0] = money[0];
        dp[1] = money[0];
        for(int i = 2; i < size; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        int firstMax = dp[size-2];


        // 1번집 무조건 안터는 경우
        dp[0] = 0;
        dp[1] = money[1];
        for(int i = 2; i < size; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        int secondMax = dp[size-1];

        return Math.max(firstMax, secondMax);
    }
}
