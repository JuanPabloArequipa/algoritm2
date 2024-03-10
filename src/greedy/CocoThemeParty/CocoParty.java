package greedy.CocoThemeParty;

import java.util.Arrays;
import java.util.Scanner;

public class CocoParty {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] happiness = new int[N];
        for (int i = 0; i < N; i++) {
            happiness[i] = input.nextInt();
        }
        Arrays.sort(happiness);

        int[] happinessSorted = new int[N];
        int left = 0, right = N - 1, maxEnjoy = 0;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                happinessSorted[i] = happiness[left];
                left++;
            } else {
                happinessSorted[i] = happiness[right];
                right--;
            }
        }

        for (int i = 1; i < N; i++) {
            int enjoyment = Math.abs(happinessSorted[i] - happinessSorted[i - 1]);
            maxEnjoy += enjoyment;
        }
        System.out.println(maxEnjoy);
    }
}
