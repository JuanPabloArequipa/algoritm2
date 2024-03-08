package vjudge2;
import java.util.Scanner;

public class ProblemF {
    private static int calculateLevenshteinDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int insertion = dp[i][j - 1] + 1;
                    int deletion = dp[i - 1][j] + 1;
                    int substitution = dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1);
                    dp[i][j] = Math.min(Math.min(insertion, deletion), substitution);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();

            int distance = calculateLevenshteinDistance(first, second);
            System.out.println(distance);
        }
    }
}