import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Fechas {
    public static void main(String[] args) {
        String fecha1 = "15/03/2023";
        String fecha2 = "10/03/2023";
        try {
            int dias = calcularDiferenciaDias(fecha1, fecha2);
            System.out.println("Diferencia en días: " + dias);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static int calcularDiferenciaDias(String fechaStr1, String fechaStr2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha1;
        LocalDate fecha2;
        try {
            fecha1 = LocalDate.parse(fechaStr1, formatter);
            fecha2 = LocalDate.parse(fechaStr2, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Una de las fechas no es válida: " + e.getMessage());
        }
        return Math.abs((int) java.time.temporal.ChronoUnit.DAYS.between(fecha1, fecha2));
    }
}
