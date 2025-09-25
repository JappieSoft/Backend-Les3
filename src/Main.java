import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Product bread = new Product("brood", 1.99, 20);
        Product fruit = new Product("fruit", 13.75, 26);
        Product toiletPaper = new Product("toilet papier", 1, 50);
        Product cheese = new Product("kaas", 3.95, 2);
        System.out.println("Winkel bevoorraad!");

        SuperMarket superMarket = new SuperMarket(bread, fruit, cheese, toiletPaper);
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
