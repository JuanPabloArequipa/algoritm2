package algoritmos;

import java.util.Scanner;

public class LcsTopDown {
    static String lcs(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        Integer[][] memo = new Integer[m + 1][n + 1];
        // Iniciar la función recursiva con memorización
        int lengthLCS = lcsRecursive(X, Y, m, n, memo);

        // Reconstruir la LCS a partir de la matriz memo
        char[] lcs = new char[lengthLCS];
        int index = lengthLCS - 1;
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[index] = X.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (memo[i - 1][j] != null && memo[i][j - 1] != null && memo[i - 1][j] > memo[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new String(lcs);
    }

    // Función recursiva con memorización para calcular la LCS
    static int lcsRecursive(String X, String Y, int i, int j, Integer[][] memo) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            memo[i][j] = 1 + lcsRecursive(X, Y, i - 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(lcsRecursive(X, Y, i - 1, j, memo), lcsRecursive(X, Y, i, j - 1, memo));
        }
        return memo[i][j];
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
