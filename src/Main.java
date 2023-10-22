import java.util.Scanner;

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
        System.out.println("Amount of money for pay is " + cart.calculateTotal());
/*
        //pay by PayPal
        cart.pay(new Paypal("221240@astanait.edu.kz", "01530153"));

        //pay by Credit Card
        cart.pay(new CreditCard("Orazaly Makambet", "0153015301530153", "667", "12/15"));

        //pay by Cash
        cart.pay(new Cash(25960));

        ILiquid basicLiquid = new BasicVapeLiquid();
        System.out.println(basicLiquid.getDescription());
        System.out.println("Price: ₸" + basicLiquid.getPrice());

        ILiquid lowNicotineLiquid = new LowNicotineVapeLiquid(basicLiquid);
        System.out.println(lowNicotineLiquid.getDescription());
        System.out.println("Price: ₸" + lowNicotineLiquid.getPrice());

        ILiquid mediumNicotineLiquid = new MediumNicotineVapeLiquid(basicLiquid);
        System.out.println(mediumNicotineLiquid.getDescription());
        System.out.println("Price: ₸" + mediumNicotineLiquid.getPrice());

        ILiquid highNicotineLiquid = new HighNicotineVapeLiquid(basicLiquid);
        System.out.println(highNicotineLiquid.getDescription());
        System.out.println("Price: ₸" + highNicotineLiquid.getPrice());
*/
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose a payment method:");
        System.out.println("1. PayPal");
        System.out.println("2. Cash");
        System.out.println("3. Credit Card");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        IPayment payment = null;

        switch (choice) {
            case 1:
                payment = new PaymentAdapter(new Paypal());
                break;
            case 2:
                payment = new PaymentAdapter(new Cash());
                break;
            case 3:
                payment = new PaymentAdapter(new CreditCard());
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        if (payment != null) {
            payment.pay();
        }

    }
}
