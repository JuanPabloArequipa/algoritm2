package greedy;

import java.util.Scanner;

public class Eggs {
    public static void main(String[] args) {
        // T= test cases, n = n eggs, P=max eggs amount , Q=max eggs weight
        Scanner input = new Scanner(System.in);
        int nTestCases = input.nextInt();
        int T = 1;

        while (T <= nTestCases) {
            int n = input.nextInt();
            int P = input.nextInt();
            int Q = input.nextInt();

            int[] eggsArray = new int[n];
            for (int j = 0; j < n; j++)
                eggsArray[j] = input.nextInt();

            int maxEggs = 0 ,weight = 0;

            for (int j = 0; j < n; j++) {
                if (weight + eggsArray[j] <= Q && maxEggs < P) {
                    weight += eggsArray[j];
                    maxEggs++;
                } else break;
            }
            System.out.println("Case " + T + ": " + maxEggs);
            T++;
        }
    }
}