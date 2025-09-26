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


        /*SuperMarket superMarket = new SuperMarket(broodVoorraad, "SupermarketName");*/
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        boolean whileActive = true;

        while (whileActive) {

            System.out.println("\nWat wil u doen?\n");
            System.out.println("1 - Selecteer een winkel");
            System.out.println("2 - Koop een product");
            System.out.println("3 - Voorraad van een product aanvullen");
            System.out.println("4 - Stop");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //choice 1
            switch (choice) {
                case (1): {
                    System.out.println("Bij welke winkel wilt u uw inkopen doen?");
                    System.out.println("Kies een van de onderstaande:");

                    for (int i = 0; i < supermarkets.size(); i++) {
                        SuperMarket supermarket = supermarkets.get(supermarkets.keySet().toArray()[i]);
                        System.out.println(i + " - " + supermarket.superMarketName);
                    }
                    int superMarketChoice = scanner.nextInt();
                    scanner.nextLine();

                    SuperMarket supermarket = supermarkets.get(supermarkets.keySet().toArray()[superMarketChoice]);
                    customer.goToSuperMarket(supermarket);
                    break;
                }

                //choice 2
                case (2): {
                    if (customer.superMarket == null) {
                        System.out.println("Kies eerst een winkel.");
                        break;
                    }
                    System.out.println("Welk product komt u kopen bij de " + customer.superMarket.superMarketName + " ?");
                    for (int i = 0; i < customer.superMarket.products.size(); i++) {
                        Product product = customer.superMarket.products.get(i);
                        System.out.println(product.name);
                    }
                    String productName = scanner.nextLine().trim().toLowerCase();
                    System.out.println("Hoeveel komt u er kopen?");
                    int amount = scanner.nextInt();
                    scanner.nextLine();

                    customer.buyItem(productName, amount);
                    break;
                }

                //choice 3
                case (3): {
                    if (customer.superMarket == null) {
                        System.out.println("Kies eerst een winkel.");
                        break;
                    }
                    System.out.println("Welk product komt u aanvullen bij de " + customer.superMarket.superMarketName + " ?");
                    for (int i = 0; i < customer.superMarket.products.size(); i++) {
                        Product product = customer.superMarket.products.get(i);
                        System.out.println(product.name);
                    }
                    String productName = scanner.nextLine().trim().toLowerCase();
                    System.out.println("Hoeveel komt u er aanvullen?");
                    int amount = scanner.nextInt();
                    scanner.nextLine();

                    customer.superMarket.restockItem(productName, amount);
                    break;
                }
                //choice 4
                case (4): {
                    System.out.println("Thanks voor shopping!");
                    whileActive = false;
                    break;
                }
                default: {
                    System.out.println("Verkeerde invoer!");
                    break;
                }

            }

        }
    }
}


