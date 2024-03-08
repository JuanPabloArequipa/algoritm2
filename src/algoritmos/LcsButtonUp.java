package algoritmos;

import java.util.Scanner;

public class LcsButtonUp {
    static String lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // Calcular la longitud de la LCS de manera bottom-up
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Construir la LCS a partir de la tabla dp
        int index = dp[m][n];
        char[] lcs = new char[index];

        // Empezar desde el final y rastrear hacia atrás para construir la LCS
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[index - 1] = X.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        return new String(lcs);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la primera secuencia: ");
        String X = scanner.next();

        System.out.print("Ingrese la segunda secuencia: ");
        String Y = scanner.next();

        String lcs = lcs(X, Y);
        int lengthLCS = lcs.length();

        System.out.println("Longitud de la Longest Common Subsequence: " + lengthLCS);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
