package dinamicProgramming;

public class ChocolateBar {

    public static void main(String[] args) {

        System.out.println("Sample 1");
        int input1 = 8;
        System.out.println(greedySolution(input1));

        System.out.println("Sample 2");
        int input2 = 12;
        System.out.println(greedySolution(input2));
        
    }

    public static int greedySolution(int N){
        int pieces = 0;
        int size = 1;

        while (size <= N) {
            pieces++;
            N -= size;
            size++;
        }

        return pieces;
    }
}
