import java.util.*;

public class KetchupTopDown {
    static int[] dp;
    public static int maxValue(int n, int[] prizes) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        return maxValueHelper(n - 1, prizes);
    }

    public static int maxValueHelper(int index, int[] prizes) {
        if (index < 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int take = prizes[index] + maxValueHelper(index - 2, prizes);
        int skip = maxValueHelper(index - 1, prizes);
        dp[index] = Math.max(take, skip);
        return dp[index];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] prizes = new int[n];
        for (int i = 0; i < n; i++) {
            prizes[i] = input.nextInt();
        }
        System.out.println(maxValue(n, prizes));
        input.close();
    }
}
