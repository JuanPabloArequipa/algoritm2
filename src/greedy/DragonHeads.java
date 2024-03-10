package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DragonHeads {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nDragonHeads = input.nextInt();
        int nKnights = input.nextInt();

        while (nDragonHeads != 0 && nKnights != 0){
            int[] dragonHeads = new int[nDragonHeads];
            int[] knights = new int[nKnights];

            for (int i = 0; i < nDragonHeads; i++)
                dragonHeads[i] = input.nextInt();
            for (int i = 0; i < nKnights; i++)
                knights[i] = input.nextInt();

            Arrays.sort(dragonHeads);
            Arrays.sort(knights);
            int totalCoins = 0;
            int dragonIndex = 0;

            for (int knight : knights) {
                if (dragonIndex < nDragonHeads && knight >= dragonHeads[dragonIndex]) {
                    totalCoins += knight;
                    dragonIndex++;
                }
            }
            if (dragonIndex < nDragonHeads)
                System.out.println("Loowater is doomed!");
            else
                System.out.println(totalCoins);

            nDragonHeads = input.nextInt();
            nKnights = input.nextInt();
        }
    }
}