public class Fibonacci {
    public static void main(String[] args) {
        int n = 50;
        long[] fibonacci = new long[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        System.out.print(fibonacci[0] + ", " + fibonacci[1]);

        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]; // Sumar los dos anteriores
            System.out.print(", " + fibonacci[i]); // Imprimir el número actual
        }
        System.out.println();
    }
}
