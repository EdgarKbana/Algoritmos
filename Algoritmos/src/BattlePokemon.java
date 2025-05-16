import java.util.HashMap;
import java.util.Map;

public class BattlePokemon {
    private static final Map<String, Map<String, Double>> effectivenessMap = new HashMap<>();
    static {
        effectivenessMap.put("Agua", new HashMap<>() {{
            put("Fuego", 2.0); // Agua es efectivo contra Fuego
            put("Planta", 0.5); // Agua no es muy efectivo contra Planta
            put("Agua", 1.0); // Agua es neutral contra Agua
            put("Eléctrico", 1.0); // Agua es neutral contra Eléctrico
        }});
        effectivenessMap.put("Fuego", new HashMap<>() {{
            put("Planta", 2.0); // Fuego es efectivo contra Planta
            put("Agua", 0.5); // Fuego no es muy efectivo contra Agua
            put("Fuego", 1.0); // Fuego es neutral contra Fuego
            put("Eléctrico", 1.0); // Fuego es neutral contra Eléctrico
        }});
        effectivenessMap.put("Planta", new HashMap<>() {{
            put("Agua", 2.0); // Planta es efectiva contra Agua
            put("Fuego", 0.5); // Planta no es muy efectivo contra Fuego
            put("Planta", 1.0); // Planta es neutral contra Planta
            put("Eléctrico", 1.0); // Planta es neutral contra Eléctrico
        }});
        effectivenessMap.put("Eléctrico", new HashMap<>() {{
            put("Agua", 2.0); // Eléctrico es efectivo contra Agua
            put("Fuego", 1.0); // Eléctrico es neutral contra Fuego
            put("Planta", 1.0); // Eléctrico es neutral contra Planta
            put("Eléctrico", 1.0); // Eléctrico es neutral contra Eléctrico
        }});
    }

    public static double calculateDamage(String attackerType, String defenderType, int attack, int defense) {
        // Validar tipos de Pokémon
        if (!effectivenessMap.containsKey(attackerType) || !effectivenessMap.containsKey(defenderType)) {
            throw new IllegalArgumentException("Tipo de Pokémon no válido.");
        }

        // Validar ataque y defensa
        if (attack < 1 || attack > 100 || defense < 1 || defense > 100) {
            throw new IllegalArgumentException("El ataque y la defensa deben estar entre 1 y 100.");
        }

        // Obtener efectividad
        double effectiveness = effectivenessMap.get(attackerType).get(defenderType);

        // Calcular daño
        double damage = 50 * (attack / (double) defense) * effectiveness;
        return damage;
    }

    public static void main(String[] args) {
        String attackerType = "Agua"; // Tipo del Pokémon atacante
        String defenderType = "Fuego"; // Tipo del Pokémon defensor
        int attack = 80; // Ataque del Pokémon atacante
        int defense = 60; // Defensa del Pokémon defensor

        double damage = calculateDamage(attackerType, defenderType, attack, defense);
        System.out.printf("El daño causado es: %.2f%n", damage);
    }
}
