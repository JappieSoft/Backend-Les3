import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> broodVoorraad = new ArrayList<>();
        broodVoorraad.add(new Product("wit brood", 1.50, 20));
        broodVoorraad.add(new Product("bruin brood", 1.25, 25));
        broodVoorraad.add(new Product("spelt brood", 1.99, 2));
        broodVoorraad.add(new Product("mais brood", 1.75, 5));

        ArrayList<Product> groenteVoorraad = new ArrayList<>();
        groenteVoorraad.add(new Product("aardbijen", 4.99, 150));
        groenteVoorraad.add(new Product("bananen", 1.50, 90));
        groenteVoorraad.add(new Product("kersen", 2.49, 25));
        groenteVoorraad.add(new Product("kiwi's", 3.95, 10));

        ArrayList<Product> kaasVoorraad = new ArrayList<>();
        kaasVoorraad.add(new Product("goudse kaas", 8.00, 200));
        kaasVoorraad.add(new Product("mozzerela", 3.75, 25));
        kaasVoorraad.add(new Product("emmentaler", 5.50, 50));
        kaasVoorraad.add(new Product("geiten kaas", 7.50, 20));

        System.out.println("De winkel is voor het eerst bevoorraad!");


        HashMap<String, SuperMarket> supermarkets = new HashMap<>();
        supermarkets.put("bakker", new SuperMarket(broodVoorraad, "bakker"));
        supermarkets.put("groente boer", new SuperMarket(groenteVoorraad, "groente boer"));
        supermarkets.put("kaas boer", new SuperMarket(kaasVoorraad, "kaas boer"));

        System.out.println(supermarkets.get("groente boer"));


        SuperMarket superMarket = new SuperMarket(broodVoorraad, "SupermarketName");
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wat wilt u vandaag kopen?");
        String productName = scanner.nextLine().trim().toLowerCase();

        System.out.println("Hoeveel wilt u er kopen?");
        int amount = scanner.nextInt();
        scanner.nextLine();

        customer.goToSuperMarket(superMarket);
        customer.buyItem(productName, amount);
    }

}
