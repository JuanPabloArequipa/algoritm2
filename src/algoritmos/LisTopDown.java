package algoritmos;

import java.util.Scanner;

public class LisTopDown {
    static int lis(int[] arr) {
        int n = arr.length;
        // Arreglo para almacenar los resultados de las subsecuencias LIS que ya hemos calculado
        int[] memo = new int[n];
        // Inicializar el arreglo memo con -1, indicando que aún no se han calculado las subsecuencias LIS
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }
        int max = 0;
        // Calcular la LIS para cada índice i
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lisRecursive(arr, i, memo));
        }
        return max;
    }

    // Función recursiva para calcular la LIS comenzando desde el índice startIndex
    static int lisRecursive(int[] arr, int startIndex, int[] memo) {
        // Si el resultado de la subsecuencia LIS que comienza desde startIndex ya se ha calculado, retornar ese valor almacenado en memo
        if (memo[startIndex] != -1) {
            return memo[startIndex];
        }
        int maxLength = 1;
        // Calcular la LIS recursivamente para todos los elementos a la derecha de startIndex
        for (int i = startIndex + 1; i < arr.length; i++) {
            // Si el elemento actual es mayor que el elemento en startIndex, calcular la LIS recursivamente desde ese índice y actualizar maxLength
            if (arr[i] > arr[startIndex]) {
                maxLength = Math.max(maxLength, 1 + lisRecursive(arr, i, memo));
            }
        }
        // Almacenar el resultado en memo para reutilización
        memo[startIndex] = maxLength;
        return maxLength;
    }

    public static void main(String[] args) {
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
