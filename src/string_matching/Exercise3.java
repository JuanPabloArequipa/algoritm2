package string_matching;

import java.util.Scanner;

public class Exercise3 {
    private final static int NO_OF_CHARS = 256;
    private static void searchMatches(String T, String P, int[] xValues) {
        char[] patternArray = P.toCharArray();
        int[][] TF = transitionFunction(patternArray, patternArray.length);
        for (int x : xValues) {
            int state = 0;
            for (int i = 0; i < x; i++) {
                state = TF[state][T.charAt(i)];
            }
            System.out.println(state);
        }
    }

    private static int[][] transitionFunction(char[] pattern, int m) {
        int[][] TF = new int[m + 1][NO_OF_CHARS];
        for (int q = 0; q <= m; q++) {
            for (int c = 0; c < NO_OF_CHARS; c++) {
                int k = Math.min(m + 1, q + 2);
                do {
                    k=k-1;
                } while (!isSuffix(pattern, q, k, c));
                TF[q][c] = k;
            }
        }
        return TF;
    }

    private static boolean isSuffix(char[] pattern, int q, int k, int c) {
        if (k == 0) return true;
        if (pattern[k - 1] != c) return false;
        for (int i = 1; i < k; i++) {
            if (pattern[i - 1] != pattern[q - k + i])
                return false;
        }
        return true;
    }

    public static void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write text: ");
        String T = scanner.next();

        System.out.println("Write pattern: ");
        String P = scanner.next();

        System.out.println("Write x numbers");
        int x = scanner.nextInt();
        int[] xNumbers = new int[x];

        for (int i = 0; i < x; i++) {
            xNumbers[i] = scanner.nextInt();
        }
        searchMatches(T, P, xNumbers);
    }

    public static void main(String[] args) {
        run();
    }
}