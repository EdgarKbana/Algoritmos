import java.util.Scanner;
public class Konami {

    private static final String[] KONAMI_CODE = {
            "UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        System.out.println("Introduce el Código Konami tecla por tecla.");
        System.out.println("Teclas válidas: UP, DOWN, LEFT, RIGHT, B, A");
        System.out.println("Introduce las teclas en mayúsculas.");
        while (true) {
            System.out.print("Tecla: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (!input.equals(KONAMI_CODE[index])) {
                index = input.equals(KONAMI_CODE[0]) ? 1 : 0;
            } else {
                index++;
            }
            if (index == KONAMI_CODE.length) {
                System.out.println("¡Código Konami introducido correctamente! ¡Secreto desbloqueado!");
                break;
            }
        }
        scanner.close();
    }
}
