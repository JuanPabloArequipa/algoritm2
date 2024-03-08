package algoritmos;

import java.util.Scanner;

public class LisButtomUp {
    // Función para encontrar la Longest Increasing Subsequence
    static int lis(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int max = 0;

        // Inicializar todas las subsecuencias dp a 1
        for (int i = 0; i < n; i++)
            dp[i] = 1;

        // Calcular subsecuencias LIS en un arreglo unidimensional usando DP
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        // Encontrar el valor máximo de LIS
        for (int i = 0; i < n; i++)
            if (max < dp[i])
                max = dp[i];

        return max;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la secuencia: ");
        int size = scanner.nextInt();
        int[] sequence = new int[size];
        System.out.println("Ingrese la secuencia:");
        for (int i = 0; i < size; i++) {
            sequence[i] = scanner.nextInt();
        }
        System.out.println("Longest Increasing Subsequence: " + lis(sequence));
    }
}
