import java.util.Arrays;
import java.util.Scanner;

public class ExerciseC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Nstones = scanner.nextInt();
        String[] numbers = scanner.nextLine().split(" ");
        int[] H = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();


    }
}
