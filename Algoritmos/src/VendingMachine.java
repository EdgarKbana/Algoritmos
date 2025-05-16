import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class VendingMachine {
    private static final Map<Integer, String> products = new HashMap<>();
    private static final Map<Integer, Integer> prices = new HashMap<>();
    private static final int[] supportedCoins = {5, 10, 50, 100, 200};
    static {
        products.put(1, "Agua");
        products.put(2, "Refresco");
        products.put(3, "Snack");
        prices.put(1, 150);
        prices.put(2, 200);
        prices.put(3, 100);
    }

    public static Object[] vend(int[] coins, int productNumber) {
        for (int coin : coins) {
            if (!isSupportedCoin(coin)) {
                return new Object[]{"Moneda no soportada", coins};
            }
        }
        int totalMoney = 0;
        for (int coin : coins) {
            totalMoney += coin;
        }
        if (!products.containsKey(productNumber)) {
            return new Object[]{"Producto no existe", coins};
        }
        int productPrice = prices.get(productNumber);

        if (totalMoney < productPrice) {
            return new Object[]{"Dinero insuficiente", coins};
        }

        int change = totalMoney - productPrice;
        List<Integer> changeCoins = getChange(change);

        return new Object[]{products.get(productNumber), changeCoins.toArray(new Integer[0])};
    }

    private static boolean isSupportedCoin(int coin) {
        for (int supportedCoin : supportedCoins) {
            if (coin == supportedCoin) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> getChange(int change) {
        List<Integer> changeCoins = new ArrayList<>();
        for (int i = supportedCoins.length - 1; i >= 0; i--) {
            while (change >= supportedCoins[i]) {
                changeCoins.add(supportedCoins[i]);
                change -= supportedCoins[i];
            }
        }
        return changeCoins;
    }

    public static void main(String[] args) {
        int[] coins = {100, 50, 50};
        int productNumber = 2;

        Object[] result = vend(coins, productNumber);
        System.out.println("Resultado: " + result[0]);
        if (result[1] instanceof Integer[]) {
            System.out.print("Cambio: ");
            for (Integer coin : (Integer[]) result[1]) {
                System.out.print(coin + " ");
            }
        }
    }
}
