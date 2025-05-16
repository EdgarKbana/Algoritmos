import java.util.HashMap;
import java.util.Map;
public class Guerra {
    private static final Map<String, Integer> goodRaces = new HashMap<>() {{
        put("Pelosos", 1);
        put("Sureños buenos", 2);
        put("Enanos", 3);
        put("Númenóreanos", 4);
        put("Elfos", 5);
    }};
    private static final Map<String, Integer> evilRaces = new HashMap<>() {{
        put("Sureños malos", 2);
        put("Orcos", 2);
        put("Goblins", 2);
        put("Huargos", 3);
        put("Trolls", 5);
    }};
    public static String battle(Map<String, Integer> goodArmy, Map<String, Integer> evilArmy) {
        int goodScore = calculateArmyScore(goodArmy, goodRaces);
        int evilScore = calculateArmyScore(evilArmy, evilRaces);

        if (goodScore > evilScore) {
            return "El bien gana la batalla.";
        } else if (evilScore > goodScore) {
            return "El mal gana la batalla.";
        } else {
            return "La batalla termina en empate.";
        }
    }
    private static int calculateArmyScore(Map<String, Integer> army, Map<String, Integer> raceValues) {
        int totalScore = 0;
        for (Map.Entry<String, Integer> entry : army.entrySet()) {
            String race = entry.getKey();
            int count = entry.getValue();
            if (raceValues.containsKey(race)) {
                totalScore += raceValues.get(race) * count;
            }
        }
        return totalScore;
    }
    public static void main(String[] args) {
        Map<String, Integer> goodArmy = new HashMap<>() {{
            put("Pelosos", 3); // 3 Pelosos
            put("Enanos", 2);  // 2 Enanos
        }};

        Map<String, Integer> evilArmy = new HashMap<>() {{
            put("Orcos", 1);    // 1 Orco
            put("Trolls", 1);   // 1 Troll
        }};
        String result = battle(goodArmy, evilArmy);
        System.out.println(result); // Resultado de la batalla
    }
}
