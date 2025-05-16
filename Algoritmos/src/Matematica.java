import java.util.regex.Pattern;
public class Matematica {
    private static final String REGEX = "^[\\s]*([-+]?\\d*\\.?\\d+)([\\s]*[+\\-*/%][\\s]*([-+]?\\d*\\.?\\d+))[\\s]*$";
    public static boolean isValidExpression(String expression) {
        String[] tokens = expression.trim().split("\\s+");
        if (tokens.length < 3) {
            return false;
        }
        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) { // Números deben estar en posiciones pares
                if (!isNumber(tokens[i])) {
                    return false;
                }
            } else { // Operaciones deben estar en posiciones impares
                if (!isOperator(tokens[i])) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isNumber(String token) {
        // Comprobar si el token es un número válido (positivo, negativo, entero o decimal)
        return Pattern.matches("[-+]?\\d*\\.?\\d+", token);
    }

    private static boolean isOperator(String token) {
        // Comprobar si el token es una operación válida
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println(isValidExpression("5 + 6 / 7 - 4")); // true
        System.out.println(isValidExpression("5 a 6")); // false
        System.out.println(isValidExpression("3.5 * 2 - 1.2")); // true
        System.out.println(isValidExpression("10 / 2 + 3.5")); // true
        System.out.println(isValidExpression("5 +")); // false
    }
}
