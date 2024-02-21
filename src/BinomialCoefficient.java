import java.util.Scanner;

public class BinomialCoefficient {
    public static int binomialCoefficient(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Insert N:");
            int n = scanner.nextInt();
            System.out.println("Insert K:");
            int k = scanner.nextInt();
            System.out.println("Binomial Coefficient: " + binomialCoefficient(n, k));
        }
    }
}