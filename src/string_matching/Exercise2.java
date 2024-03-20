package string_matching;

import java.util.Scanner;

public class Exercise2 {
    public static String findMostMatchingPrefix(String S) {
        int maxCount = 0;
        String mostMatchingPrefix = "";

        for (int i = 1; i <= S.length(); i++) {
            String prefix = S.substring(0, i);
            int count = KMP(S, prefix);

            if (count > maxCount || (count == maxCount && prefix.length() > mostMatchingPrefix.length())) {
                maxCount = count;
                mostMatchingPrefix = prefix;
            }
        }
        return mostMatchingPrefix + " - " + maxCount;
    }

    private static int[] computeTemporaryArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int index = 0;
        for (int i = 1; i < pattern.length();) {
            if (pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private static int KMP(String text, String pattern) {
        int[] lps = computeTemporaryArray(pattern);
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < text.length() && j < pattern.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == pattern.length()) {
                count++;
                j = lps[j - 1];
            }
        }
        return count;
    }

    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write S:");
        String S = scanner.nextLine();
        String result = findMostMatchingPrefix(S);
        System.out.println(result);
    }

    public static void main(String[] args) {
        run();
    }
}