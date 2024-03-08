package algoritmos;

import java.util.Scanner;

public class KnapsackBottomUpSinRep {
    public static int maxTotalValueBottomUp(int[] prizes) {
        int n = prizes.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return prizes[0];
        int[] dp = new int[n];
        dp[0] = prizes[0];
        dp[1] = Math.max(prizes[0], prizes[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + prizes[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prizes = new int[n];
        for (int i = 0; i < n; i++) {
            prizes[i] = scanner.nextInt();
        }
        System.out.println(maxTotalValueBottomUp(prizes));
    }
}