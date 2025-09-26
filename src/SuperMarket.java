import java.util.List;
import java.util.Scanner;

public class SuperMarket {
    List<Product> products;
    String superMarketName;
    Scanner scanner = new Scanner(System.in);

    public SuperMarket(List<Product> products, String superMarketName) {
        this.products = products;
        this.superMarketName = superMarketName;
    }

    public void buyItem(Product product, int orderAmount) {
        String itemName = product.name;
        double itemPrice = product.price;
        int itemStock = product.amount;
        int order = orderAmount;

        if (itemStock >= order) {
            System.out.println("U heeft " + order + " " + itemName + " gekocht, voor " + itemPrice * order + " euro");
        } else {
            System.out.println("U kan geen " + order + " " + itemName + " kopen, want we hebben maar " + itemStock + " " + itemName + " op voorraad.");
        }
    }

    public void restockItem(String productName, int amount) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).name.equalsIgnoreCase(productName)) {
                products.get(i).amount += amount;
                System.out.println(productName + " nieuwe voorraad = " + products.get(i).amount);
                break;
            } else if (i == products.size() - 1) {
                System.out.println("\nU heeft " + productName + " ingevoerd.");
                System.out.println("Dit product is niet gevonden bij de " + superMarketName);
                System.out.println("1 - U wilt opnieuw proberen?");
                System.out.println("2 - U wilt dit product toevoegen?");
                int answer = scanner.nextInt();
                scanner.nextLine();

                if (answer == 1) {
                    break;
                } else if (answer == 2) {
                    System.out.println("Voor welke prijs word " + productName + " verkocht?");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    products.add(new Product(productName, price, amount));
                } else {
                    System.out.println("Input klopt niet pannekoek!");
                    break;
                }

            }
        }
    }
}