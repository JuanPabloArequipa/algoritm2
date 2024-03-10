package greedy.CocoBirthday;

import java.util.Arrays;
import java.util.Scanner;

public class CocoBirthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] happiness = new int[n];
        for (int i = 0; i < n; i++) {
            happiness[i] = scanner.nextInt();
        }
        Arrays.sort(happiness);
        int totalGuests = 0;
        for (int i = 0; i < n; i++) {
            if (happiness[i] - i > 0) {
                totalGuests++;
            } else break;
        }
        System.out.println(totalGuests);
    }
}
