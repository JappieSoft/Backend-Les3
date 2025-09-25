public class SuperMarket {
    Product bread;
    Product fruit;
    Product cheese;
    Product toiletPaper;


    public SuperMarket(Product bread, Product fruit, Product cheese, Product toiletPaper) {
        this.bread = bread;
        this.cheese = cheese;
        this.fruit  = fruit;
        this.toiletPaper = toiletPaper;
    }

    private void buyItem(Product product, int orderAmount) {
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

        public void buyBread (int amount){
            buyItem(this.bread, amount);
        }

        public void buyFruit (int amount){
            buyItem(this.fruit, amount);
        }

        public void buyCheese (int amount){
            buyItem(this.cheese, amount);
        }

        public void buyToiletPaper (int amount){
            buyItem(this.toiletPaper, amount);
        }

}