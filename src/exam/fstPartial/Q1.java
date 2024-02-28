package exam.fstPartial;

public class Q1 {
    // a) Update this code so it uses dynamic programming
    private static int function(int n, int[] dp){
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = function(n-1, dp) + function(n-2, dp) + function(n-3, dp);
        return dp[n];
    }

    /* B) Do we still need the base case after converting the code to dynamic programming? why?
        Answer: After converting the code to dynamic programming, we still need the base case. The base cases (n == 0, n == 1, and n == 2) define the termination conditions for the recursion. without an infinite loop.
    */
}
