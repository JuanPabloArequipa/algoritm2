package vjudge2;

import java.util.*;

public class ProblemB {
    // KnapSack repetition
    public static boolean[][] dp;
    public static boolean canPartition(int[] suitcaseWeights, int index, int targetWeight) {
        if (targetWeight == 0) {
            return true;
        }
        if (index >= suitcaseWeights.length || targetWeight < 0) {
            return false;
        }
        if (dp[index][targetWeight]) {
            return false;
        }
        if (canPartition(suitcaseWeights, index + 1, targetWeight - suitcaseWeights[index]) ||
                canPartition(suitcaseWeights, index + 1, targetWeight)) {
            return true;
        }
        dp[index][targetWeight] = true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String[] weights = scanner.nextLine().split(" ");
            int[] suitcaseWeights = new int[weights.length];
            int totalWeight = 0;
            for (int j = 0; j < weights.length; j++) {
                suitcaseWeights[j] = Integer.parseInt(weights[j]);
                totalWeight += suitcaseWeights[j];
            }
            if (totalWeight % 2 != 0) {
                System.out.println("NO");
            } else {
                int targetWeight = totalWeight / 2;
                dp = new boolean[suitcaseWeights.length][targetWeight + 1];
                boolean result = canPartition(suitcaseWeights, 0, targetWeight);
                System.out.println(result ? "YES" : "NO");
            }
        }
        scanner.close();
    }
}

