import java.util.Random;
public class Clima {
    public static void main(String[] args) {
        double temperaturaInicial = 20.0;
        double probabilidadLluviaInicial = 30.0;
        int dias = 10;
        simularClima(temperaturaInicial, probabilidadLluviaInicial, dias);
    }
    public static void simularClima(double temperaturaInicial, double probabilidadLluviaInicial, int dias) {
        Random random = new Random();
        double temperatura = temperaturaInicial;
        double probabilidadLluvia = probabilidadLluviaInicial;
        double temperaturaMaxima = temperatura;
        double temperaturaMinima = temperatura;
        int diasLluvia = 0;
        System.out.printf("Día\tTemperatura\tLluvia%n");
        System.out.println("-----------------------------");
        for (int dia = 1; dia <= dias; dia++) {
            boolean llueve = random.nextDouble() * 100 < probabilidadLluvia;
            if (llueve) {
                temperatura -= 1; // Disminuir temperatura si llueve
                diasLluvia++;
            } else {
                // 10% de probabilidad de que la temperatura cambie
                if (random.nextDouble() < 0.1) {
                    if (random.nextBoolean()) {
                        temperatura += 2; // Aumentar temperatura
                    } else {
                        temperatura -= 2; // Disminuir temperatura
                    }
                }
            }
            if (temperatura > 25) {
                probabilidadLluvia += 20; // Aumentar probabilidad de lluvia
            } else if (temperatura < 5) {
                probabilidadLluvia -= 20; // Disminuir probabilidad de lluvia
            }
            // Asegurarse de que la probabilidad de lluvia esté entre 0 y 100
            probabilidadLluvia = Math.max(0, Math.min(100, probabilidadLluvia));
            // Actualizar temperaturas máximas y mínimas
            temperaturaMaxima = Math.max(temperaturaMaxima, temperatura);
            temperaturaMinima = Math.min(temperaturaMinima, temperatura);
            // Mostrar resultados del día
            System.out.printf("%d\t%.2f\t\t%s%n", dia, temperatura, llueve ? "Sí" : "No");
        }
        System.out.printf("%nResumen:%n");
        System.out.printf("Temperatura máxima: %.2f%n", temperaturaMaxima);
        System.out.printf("Temperatura mínima: %.2f%n", temperaturaMinima);
        System.out.printf("Días de lluvia: %d%n", diasLluvia);
    }
}
