import java.util.Objects;

public class Customer {
    public String customerName;
    public SuperMarket superMarket;
    int amount;

    public void Customer(String customerName) {
        this.customerName = customerName;
    }

    public void goToSuperMarket(SuperMarket superMarket) {
        this.superMarket = superMarket;
        System.out.println(superMarket.superMarketName);
    }


    public void buyItem(String productName, int amount) {
        if (superMarket == null) {
            System.out.println("SuperMarket is niet goed geselecteerd.");
        } else {
            for (int i = 0; i < superMarket.products.size(); i++) {
                if (superMarket.products.get(i).name.equalsIgnoreCase(productName)) {
                    superMarket.buyItem(superMarket.products.get(i), amount);
                    break;
                } else if (i == superMarket.products.size() - 1) {
                    System.out.println(superMarket.superMarketName + " verkoopt geen " + productName);
                }
            }
        }
    }
}