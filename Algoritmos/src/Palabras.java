import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Palabras {

    private static final String[] words = {
            "murcielago", "desarrollo", "programacion", "java", "computadora",
            "algoritmo", "tecnologia", "inteligencia", "redes", "software"
    };
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        String hiddenWord = hideLetters(wordToGuess);
        int attemptsLeft = MAX_ATTEMPTS;

        System.out.println("¡Bienvenido al juego de adivinar palabras!");
        System.out.println("Palabra a adivinar: " + hiddenWord);
        System.out.println("Tienes " + attemptsLeft + " intentos.");

        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.print("Introduce una letra o la palabra completa: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.length() == 1) {
                // Adivinar una letra
                if (wordToGuess.contains(userInput)) {
                    hiddenWord = revealLetter(wordToGuess, hiddenWord, userInput);
                    System.out.println("¡Correcto! La palabra ahora es: " + hiddenWord);
                } else {
                    attemptsLeft--;
                    System.out.println("Incorrecto. Te quedan " + attemptsLeft + " intentos.");
                }
            } else if (userInput.length() == wordToGuess.length()) {
                // Adivinar la palabra completa
                if (userInput.equals(wordToGuess)) {
                    System.out.println("¡Felicidades! Has adivinado la palabra: " + wordToGuess);
                    return;
                } else {
                    attemptsLeft--;
                    System.out.println("Incorrecto. Te quedan " + attemptsLeft + " intentos.");
                }
            } else {
                System.out.println("Por favor, introduce una letra o una palabra de la misma longitud.");
            }

            if (hiddenWord.equals(wordToGuess)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + wordToGuess);
                return;
            }
        }

        System.out.println("¡Has perdido! La palabra era: " + wordToGuess);
    }

    private static String hideLetters(String word) {
        StringBuilder hidden = new StringBuilder(word);
        Random random = new Random();
        int lettersToHide = (int) Math.ceil(word.length() * 0.6); // Ocultar hasta el 60%

        List<Integer> indicesToHide = new ArrayList<>();
        while (indicesToHide.size() < lettersToHide) {
            int index = random.nextInt(word.length());
            if (!indicesToHide.contains(index)) {
                indicesToHide.add(index);
                hidden.setCharAt(index, '_'); // Ocultar letra
            }
        }

        return hidden.toString();
    }

    private static String revealLetter(String word, String hiddenWord, String letter) {
        StringBuilder revealed = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                revealed.setCharAt(i, letter.charAt(0));
            }
        }
        return revealed.toString();
    }
}
