package exercises;

import java.util.Scanner;

public class ExerciseB {
    public static int f91(int n ) {
        if (n <= 100){
            return f91(f91(n + 11));
        } else
            return n - 10;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aux = scanner.nextInt();
        while (aux != 0){
            int result = f91(aux);
            System.out.println("f91("+aux+") = "+result);
            aux = scanner.nextInt();
        }
    }
}