import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] hotBevNames = new String[] { "Americano", "Black Tea", "Green Tea", "Cappuccino", "Latte" };
        int[] hotBevVolumes = new int[] { 200, 300, 450, 600 };
        int[] hotBevPrices = new int[] { 50, 75, 100, 150 };
        int[] hotBevTemps = new int[] { 50, 60, 70, 80, 90 };
        ArrayList<Product> hotBevs = new ArrayList<>();

        for (String hotBevName : hotBevNames) {
            for (int hotBevTemp : hotBevTemps) {
                for (int i = 0; i < hotBevVolumes.length; i++) {
                    Product newHotBev = new HotBeverage(hotBevName, hotBevPrices[i], hotBevVolumes[i], hotBevTemp);
                    hotBevs.add(newHotBev);
                }
            }
        }

        BevVendingMachine someBevMachine = new BevVendingMachine();
        someBevMachine.initProducts(hotBevs);

        System.out.println(someBevMachine.getProduct("Americano"));

        System.out.println(someBevMachine.getProduct("Americano", 450));

        System.out.println(someBevMachine.getProduct("Americano", 300, 80));
        System.out.println();
        HotBevVendingMachine someHotBevMachine = new HotBevVendingMachine();
        someHotBevMachine.initProducts(hotBevs);

        System.out.println(someHotBevMachine.getProduct("Americano"));

        System.out.println(someHotBevMachine.getProduct("Americano", 450));

        System.out.println(someHotBevMachine.getProduct("Americano", 300, 80));

        BevIterator HotBevIterator = new BevIterator(someHotBevMachine);

        for (Product bev : someHotBevMachine.getProducts()) {
            System.out.println(HotBevIterator.next());
        }

        System.out.println(HotBevIterator.hasNext());

    }
}