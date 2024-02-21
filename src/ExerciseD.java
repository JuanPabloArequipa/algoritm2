import java.util.Scanner;

public class ExerciseD {
    static int minimumCost(int size, int[] cuts) {
        int cutsAmount = cuts.length;
        int[] cutPoints = new int[cutsAmount + 2];

        for (int i = 0; i < cutsAmount; i++) {
            cutPoints[i + 1] = cuts[i];
        }
        cutPoints[cutsAmount + 1] = size;
        int[][] memoization = new int[cutsAmount + 2][cutsAmount + 2];

        return cutCalculator(cutPoints, 0, cutsAmount + 1, memoization);
    }

    static int cutCalculator(int[] cutPoints, int left, int right, int[][] memoization) {
        if (right - left <= 1) {
            return 0;
        }
        if (memoization[left][right] != 0) {
            return memoization[left][right];
        }

        int min = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            int cost = cutPoints[right] - cutPoints[left]
                    + cutCalculator(cutPoints, left, i, memoization)
                    + cutCalculator(cutPoints, i, right, memoization);
            min = Math.min(min, cost);
        }
        memoization[left][right] = min;
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        while (size != 0) {
            int n = scanner.nextInt();
            int[] cuts = new int[n];
            for (int i = 0; i < n; i++) {
                cuts[i] = scanner.nextInt();
            }

            int min = minimumCost(size, cuts);
            System.out.println("The minimum cutting is " + min + ".");

            size = scanner.nextInt();
        }
    }
}
