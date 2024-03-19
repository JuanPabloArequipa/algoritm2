package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Activities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            activities[i][0] = Integer.parseInt(input[0]);
            activities[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(activities, Comparator.comparingInt(activity -> activity[1]));
        int account = 1;
        int finishTime = activities[0][1];

        for (int i = 1; i < n; i++) {
            int startTime = activities[i][0];
            if (startTime > finishTime) {
                account = account + 1;
                finishTime = activities[i][1];
            }
        }

        System.out.println(account);
    }
}
