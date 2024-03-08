package vjudge2;

import java.util.Scanner;
//LCS
public class ProblemD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String seq1 = scanner.nextLine();
            String seq2 = scanner.nextLine();

            int result = longestCommonSubsequence(seq1, seq2);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[m][n];
    }
}

