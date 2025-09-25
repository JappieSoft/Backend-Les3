import java.util.Objects;

public class Customer {
    public String customerName;
    public SuperMarket superMarket;
    int amount;

    public void Customer (String customerName) {
        this.customerName = customerName;
    }

    public void goToSuperMarket (SuperMarket superMarket){
        this.superMarket = superMarket;
    }


    public void buyItem(String productName, int amount) {
        if (Objects.equals(productName, superMarket.bread.name)) {
            superMarket.buyBread(amount);
        } else if (Objects.equals(productName, superMarket.fruit.name)) {
            superMarket.buyFruit(amount);
        } else if (Objects.equals(productName, superMarket.cheese.name)) {
            superMarket.buyCheese(amount);
        } else if (Objects.equals(productName, superMarket.toiletPaper.name) || Objects.equals(productName, "toiletpapier")) {
            superMarket.buyToiletPaper(amount);
        } else {
        System.out.println("Product niet gevonden in de Winkel!");
        }
    }


}