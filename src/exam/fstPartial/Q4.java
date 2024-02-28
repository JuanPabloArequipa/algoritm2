package exam.fstPartial;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] gifts = new int[N];
        for (int i = 0; i < N; i++) {
            gifts[i] = scanner.nextInt();
        }

        int minMoves = minGiftMoves(gifts);
        System.out.println(minMoves);
        scanner.close();
    }

    public static int minGiftMoves(int[] gifts) {
        int n = gifts.length;
        int[] sortedGifts = Arrays.copyOf(gifts, n);
        Arrays.sort(sortedGifts);

        int[] dp = new int[n];
        dp[0] = (gifts[0] == sortedGifts[0]) ? 0 : 1;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + ((gifts[i] == sortedGifts[i]) ? 0 : 1);
        }

        return dp[n - 1];
    }
}