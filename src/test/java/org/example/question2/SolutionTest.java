package org.example.question2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    @DisplayName("합계: 4, 코인: 1,2,3")
    void case1() {
        int sum = 4;
        int[] coins = {1, 2, 3};

        assertThat(solution(sum, coins)).isEqualTo(4);
    }

    @Test
    @DisplayName("합계: 10, 코인: 2,5,3,6")
    void case2() {
        int sum = 10;
        int[] coins = {2, 5, 3, 6};

        assertThat(solution(sum, coins)).isEqualTo(5);
    }

    @Test
    @DisplayName("합계: 10, 코인: 1,2,5")
    void case3() {
        int sum = 10;
        int[] coins = {1, 2, 5};

        assertThat(solution(sum, coins)).isEqualTo(10);
    }

    @Test
    @DisplayName("합계: 3, 코인: 1,2,2,5")
    void case4() {
        int sum = 3;
        int[] coins = {1, 2, 2, 5};

        assertThat(solution(sum, coins)).isEqualTo(2);
    }

    private int solution(int sum, int[] coins) {
        return new Solution().algorithm(sum, coins);
    }
}
