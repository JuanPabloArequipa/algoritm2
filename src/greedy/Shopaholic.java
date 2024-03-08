package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shopaholic {
    private static int selectThirdsElem(int[] prices) {
        Arrays.sort(prices);
        int totalDiscount = 0;
        for (int j = prices.length - 1; j >= 2; j -= 3) {
            totalDiscount += prices[j - 2];
        }
        return totalDiscount;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nTestScenarios = Integer.parseInt(br.readLine());

        for (int i = 0; i < nTestScenarios; i++) {
            int nItems = Integer.parseInt(br.readLine());
            int[] prices = new int[nItems];
            String[] pricesStr = br.readLine().split(" ");

            for (int j = 0; j < nItems; j++) {
                prices[j] = Integer.parseInt(pricesStr[j]);
            }
            int totalDiscount = selectThirdsElem(prices);
            System.out.println(totalDiscount);
        }
    }
}
