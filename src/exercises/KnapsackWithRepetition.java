package exercises;

public class KnapsackWithRepetition {
    /*
    exercises.KnapsackWithRepetition -> retorna{entero} maximo cuando se puede elegir el mismo elemento muchas veces
    KnapsackWithNoRepetition -> retorna{entero} maximo cuando se puede elegir solo una vez cada elemento
    LIS:Longest Increasing Subsequence ->[array] retorna{lista} la maxima secuencia ascendente de una determinada lista
    LCS: Longest Common Subsequence -> [matriz] retorna {entero} la longitud maxima de una secuencia que tengan en comun entre los inputs
    Levenshtein -> retorna{entero} minimo numero de ediciones para transformar A en B

    // scanner has next
    // buffered reader diferente a null o vacio
     */
    public int knapsackRep(int[] value, int[] weight, int
            maxWeight, int N) {
        int[] K = new int[maxWeight + 1];
        for (int w = 1; w <= maxWeight; w++) {
            for (int i = 1; i <= N; i++) {
                if (weight[i] <= w) {
                    K[w] = Math.max(K[w], K[w - weight[i]] + value[i]);
                }
            }
        }
        return K[maxWeight];
    }
}
