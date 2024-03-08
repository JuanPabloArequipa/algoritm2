package vjudge2;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {

    private static final int MAX_N = 5607;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Turtle[] turtles = new Turtle[MAX_N];
        int n = 0, counter = 0;

        while (scanner.hasNext()) {
            if (counter++ > MAX_N) break;
            int weight = scanner.nextInt();
            int strength = scanner.nextInt();
            turtles[n++] = new Turtle(weight, strength);
        }

        Arrays.sort(turtles, 0, n, (t1, t2) -> t1.strength - t2.strength);

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                if (dp[j - 1] <= turtles[i].strength - turtles[i].weight) {
                    dp[j] = Math.min(dp[j], dp[j - 1] + turtles[i].weight);
                }
            }
        }

        int maxTurtles = 0;
        while (dp[maxTurtles + 1] != Integer.MAX_VALUE) {
            maxTurtles++;
        }
        System.out.println(maxTurtles);
    }

    static class Turtle {
        int weight, strength;

        public Turtle(int weight, int strength) {
            this.weight = weight;
            this.strength = strength;
        }
    }
}