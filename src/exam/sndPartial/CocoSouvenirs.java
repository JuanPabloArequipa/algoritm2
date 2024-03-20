package exam.sndPartial;

public class CocoSouvenirs {
    public static int[] createCounterArray(int[] input) {
        int n = input.length;
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            output[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            int maxCounter = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (input[j] > input[i]) {
                    maxCounter = Math.max(maxCounter, output[j] + 1);
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (input[j] > input[i]) {
                    maxCounter = Math.max(maxCounter, output[j] + 1);
                } else {
                    break;
                }
            }
            output[i] = maxCounter;
        }

        return output;
    }

    public static int sumCounters(int[] integerArr){
        int sum = 0;
        for (int i : integerArr) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input1 = {2, 2, 10, 5};
        System.out.println(sumCounters(createCounterArray(input1)));

        int[] input2 = {10, 3, 4};
        System.out.println(sumCounters(createCounterArray(input2)));

        int[] input3 = {5, 4, 3, 2, 1};
        System.out.println(sumCounters(createCounterArray(input3)));
    }
}
