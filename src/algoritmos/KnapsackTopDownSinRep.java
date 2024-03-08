package algoritmos;

import java.util.Scanner;

public class KnapsackTopDownSinRep {
    static int[] memo;

    public static int maxTotalValueTopDown(int[] prizes) {
        int n = prizes.length;
        memo = new int[n];
        return maxTotalValueTopDownHelper(prizes, n - 1);
    }

    public static int maxTotalValueTopDownHelper(int[] prizes, int idx) {
        if (idx < 0) return 0;
        if (memo[idx] != 0) return memo[idx];
        int choose = prizes[idx] + maxTotalValueTopDownHelper(prizes, idx - 2);
        int skip = maxTotalValueTopDownHelper(prizes, idx - 1);
        memo[idx] = Math.max(choose, skip);
        return memo[idx];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prizes = new int[n];
        for (int i = 0; i < n; i++) {
            prizes[i] = scanner.nextInt();
        }
        System.out.println(maxTotalValueTopDown(prizes));
    }
}