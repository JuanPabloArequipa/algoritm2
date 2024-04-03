package dinamicProgramming;

public class ChocolateBar {

    public static void main(String[] args) {

        System.out.println("Sample 1");
        int input1 = 8;
        System.out.println(greedySolution(input1));
        System.out.println(dpSolution(input1));

        System.out.println("Sample 2");
        int input2 = 12;
        System.out.println(greedySolution(input2));
        System.out.println(dpSolution(input2));

    }

    public static int greedySolution(int N){
        int pieces = 0;
        int size = 1;

        while (size <= N) {
            pieces++;
            N -= size;
            size++;
        }

        return pieces;
    }

    public static int dpSolution(int N) {
        int[] dp = new int[N+1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + 1);
            }
        }
        return dp[N]/3;
    }
}
