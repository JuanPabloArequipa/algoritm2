package exam.thrdPartial;

import java.util.Arrays;

public class Main {
    public static int maxMealsGreedy(int N, int M, int[] mealTimes) {
        Arrays.sort(mealTimes);

        int mealsCount = 0;
        int totalTime = 0;
        for (int i = 0; i < N; i++) {
            if (totalTime + mealTimes[i] <= M) {
                mealsCount++;
                totalTime += mealTimes[i];
            } else {
                break;
            }
        }
        return mealsCount;
    }

    public static int maxMealsDP(int N, int M, int[] mealTimes) {
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            int timeNeeded = mealTimes[i - 1];
            for (int j = 1; j <= M; j++) {
                if (timeNeeded <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - timeNeeded] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][M];
    }


    public static void main(String[] args) {
        int N = 5;
        int M = 10;
        int[] mealTimes = {6, 3, 2, 4, 1};

        int maxMealsGreedy = maxMealsGreedy(N, M, mealTimes);
        System.out.println("Greedy Algorithm: " + maxMealsGreedy);

        int maxMealsDP = maxMealsDP(N, M, mealTimes);
        System.out.println("Dynamic Programming: " + maxMealsDP);
    }

}
