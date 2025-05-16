public class Parametros {
    public static void countdown(int start, int seconds) {
        if (start <= 0 || seconds <= 0) {
            System.out.println("Ambos parámetros deben ser números enteros positivos.");
            return;
        }
        try {
            for (int i = start; i >= 0; i--) {
                System.out.println(i);
                if (i > 0) {
                    Thread.sleep(seconds * 1000L);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Cuenta atrás interrumpida.");
        }
    }
    public static void main(String[] args) {
        countdown(5, 1);
    }
}
