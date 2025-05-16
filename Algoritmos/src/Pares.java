import java.util.ArrayList;
import java.util.List;
public class Pares {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static List<int[]> findTwinPrimes(int maxRange) {
        List<int[]> twins = new ArrayList<>();
        for (int i = 2; i <= maxRange - 2; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                twins.add(new int[]{i, i + 2});
            }
        }
        return twins;
    }
    public static void main(String[] args) {
        int maxRange = 14;
        List<int[]> twinPrimes = findTwinPrimes(maxRange);

        System.out.println("Pares de primos gemelos hasta " + maxRange + ":");
        for (int[] pair : twinPrimes) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}

