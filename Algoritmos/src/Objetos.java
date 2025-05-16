public class Objetos {
    public static void main(String[] args) {
        double[] objeto1 = {0, 0};
        double[] velocidad1 = {1, 2};
        double[] objeto2 = {5, 5};
        double[] velocidad2 = {0, -1};
        encontrarPuntoEncuentro(objeto1, velocidad1, objeto2, velocidad2);
    }
    public static void encontrarPuntoEncuentro(double[] objeto1, double[] velocidad1, double[] objeto2, double[] velocidad2) {
        double x1 = objeto1[0];
        double y1 = objeto1[1];
        double vx1 = velocidad1[0];
        double vy1 = velocidad1[1];

        double x2 = objeto2[0];
        double y2 = objeto2[1];
        double vx2 = velocidad2[0];
        double vy2 = velocidad2[1];

        // Ecuaciones de movimiento
        // x1 + vx1 * t = x2 + vx2 * t
        // y1 + vy1 * t = y2 + vy2 * t

        // Resolviendo para t
        double tX = (x2 - x1) / (vx1 - vx2);
        double tY = (y2 - y1) / (vy1 - vy2);

        // Verificar si los tiempos son iguales y no negativos
        if (tX == tY && tX >= 0) {
            double t = tX; // Tiempo de encuentro
            double puntoX = x1 + vx1 * t; // Punto de encuentro en x
            double puntoY = y1 + vy1 * t; // Punto de encuentro en y

            System.out.printf("Los objetos se encuentran en el punto (%.2f, %.2f) después de %.2f unidades de tiempo.%n", puntoX, puntoY, t);
        } else {
            System.out.println("Los objetos no se encontrarán.");
        }
    }
}
