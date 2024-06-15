package org.example.question2;

import java.util.Arrays;

/**
 * 서로 다른 종류의 통화를 나타내는 N 크기의 coin[ ] 정수 배열과 정수 합계가 주어지면, coin[]의 다양한 조합을 사용하여 합계를 만드는 방법의 수를 찾는 것이 과제입니다.
 * 입력: 합계 = 4, coins[] = {1,2,3},
 * 출력: 4
 * 입력: 합계 = 10, coins[] = {2, 5, 3, 6}
 * 출력: 5
 * - 코인은 중복 제거한다.
 */
public class Solution {
    public int algorithm(int sum, int[] coins) {
        int[] distinctCoins = Arrays.stream(coins).distinct().toArray();
        int[] dp = new int[sum + 1];

        dp[0] = 1;
        for (int coin : distinctCoins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[sum];
    }
}
