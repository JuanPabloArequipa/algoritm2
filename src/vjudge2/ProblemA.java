package vjudge2;
import java.util.Scanner;

public class ProblemA {
    //knap sack no repetition
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // Number of objects
            int[] prices = new int[N];
            int[] weights = new int[N];

            // Read prices and weights of objects
            for (int i = 0; i < N; i++) {
                prices[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
            }

            int G = scanner.nextInt(); // Number of people
            int[] maxWeights = new int[G];

            // Read max weights for each person
            for (int i = 0; i < G; i++) {
                maxWeights[i] = scanner.nextInt();
            }

            // Solve the knapsack problem for each person
            int totalValue = 0;
            for (int i = 0; i < G; i++) {
                totalValue += knapsack(prices, weights, N, maxWeights[i]);
            }

            System.out.println(totalValue);
        }
        scanner.close();
    }

    // Dynamic Programming approach for 0/1 knapsack
    private static int knapsack(int[] prices, int[] weights, int N, int maxWeight) {
        int[][] dp = new int[N + 1][maxWeight + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= maxWeight; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + prices[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[N][maxWeight];
    }
}
