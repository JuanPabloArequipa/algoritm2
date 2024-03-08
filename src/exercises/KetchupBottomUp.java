package exercises;

import java.util.*;

public class KetchupBottomUp {
    static int[] dp;
    public static int maxValue(int n, int[] prizes) {
        if (n == 0)
            return 0;
        if (n == 1)
            return prizes[0];
        dp = new int[n];
        dp[0] = prizes[0];
        dp[1] = Math.max(prizes[0], prizes[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(prizes[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] prizes = new int[n];
        for (int i = 0; i < n; i++) {
            prizes[i] = input.nextInt();
        }
        System.out.println(maxValue(n, prizes));
        input.close();
    }
}
