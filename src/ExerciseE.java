import java.io.*;

public class ExerciseE {
    public static void main(String[] args) throws IOException {
        int[] fibonacciValues = new int[45];
        fibonacciValues[0] = 1;
        fibonacciValues[1] = 1;

        for (int i = 2; i < 45; i++) {
            fibonacciValues[i] = (fibonacciValues[i-1] + fibonacciValues[i-2]);
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(bufferedReader.readLine()) + 1;

        bufferedWriter.write(String.valueOf(fibonacciValues[input]));
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}