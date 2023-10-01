public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Item item1 = new Item("0153","Dozol",4990);
        Item item2 = new Item("0153","Waka",7990);
        Item item3 = new Item("0153","ElfBar",4990);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item2);
        cart.addItem(item3);

        //pay by PayPal
        cart.pay(new Paypal("221240@astanait.edu.kz", "01530153"));

        //pay by credit card
        cart.pay(new CreditCard("Orazaly Makambet", "0153015301530153", "667", "12/15"));

    }
}
