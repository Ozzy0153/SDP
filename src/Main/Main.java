package Main;

import Factory.*;
import Strategy.*;
import Singleton.*;
import Decorator.*;
import Adapter.*;
import Observer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Vape Shop!");
        System.out.println("Choose the user type (1 for Admin, 2 for Customer):");
        int user = scanner.nextInt();
        ShopObserver customer = new Customer("Zhanka");
        ShopObserver admin = new Admin("Yernur");
        VapeShop shop = new VapeShop("Ozzy's Vape Shop");
        shop.addObserver(customer);
        shop.addObserver(admin);
        if (user == 1) {
            System.out.println("Hello, Ozzy!");
            System.out.println("Choose the product type (1 for Ejuice, 2 for Vape Device):");
            int choice = scanner.nextInt();
            VapeProductFactory factory = null;
            if (choice == 1) {
                factory = new EjuiceFactory();
            } else if (choice == 2) {
                factory = new VapeDeviceFactory();
            } else {
                System.out.println("Invalid choice. Exiting.");
                return;
            }

            System.out.print("Enter the product name: ");
            String name = scanner.next();
            System.out.print("Enter the product price: ₸");
            double price = scanner.nextDouble();
            VapeProduct product = factory.createProduct(name, price);
            System.out.println("Created Product: " + product.getName() + ", Price: ₸" + product.getPrice());

            shop.notifyNewProduct(product.getName());

            scanner.close();
        } else if (user == 2) {
            System.out.println("Choose the product type (1 for Vape Liquid, 2 for Vape Products):");
            int type = scanner.nextInt();
            if (type == 1) {
                ILiquid vapeLiquid = new BasicVapeLiquid();
                List<ILiquid> selectedDecorators = new ArrayList<>();

                System.out.println("Welcome to the Vape Liquid Customization!");

                int choice;
                do {
                    System.out.println("Choose an option to enhance your vape liquid:");
                    System.out.println("1. Low Nicotine");
                    System.out.println("2. Medium Nicotine");
                    System.out.println("3. High Nicotine");
                    System.out.println("4. Finish and create your vape liquid");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            selectedDecorators.add(new LowNicotineVapeLiquid(vapeLiquid));
                            break;
                        case 2:
                            selectedDecorators.add(new MediumNicotineVapeLiquid(vapeLiquid));
                            break;
                        case 3:
                            selectedDecorators.add(new HighNicotineVapeLiquid(vapeLiquid));
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                } while (choice != 4);

                for (ILiquid decorator : selectedDecorators) {
                    vapeLiquid = decorator;
                }

                System.out.println("\nYour customized vape liquid:");
                System.out.println("Description: " + vapeLiquid.getDescription());
                System.out.println("Price: ₸" + vapeLiquid.getPrice());

                System.out.println("Choose a payment method:");
                System.out.println("1. PayPal");
                System.out.println("2. Cash");
                System.out.println("3. Credit Card");
                System.out.println("4. Promo Code");
                int pay = scanner.nextInt();
                IPayment payment = null;

                switch (pay) {
                    case 1 -> {
                        System.out.print("Enter PayPal email: ");
                        String email = scanner.next();
                        System.out.print("Enter PayPal password: ");
                        String password = scanner.next();
                        payment = new Paypal(email, password);
                    }
                    case 2 -> {
                        System.out.print("Enter payment amount (cash): ₸");
                        int check = scanner.nextInt();
                        payment = new Cash(check);
                    }
                    case 3 -> {
                        System.out.print("Enter cardholder name: ");
                        String name = scanner.next();
                        System.out.print("Enter credit card number: ");
                        String cardNumber = scanner.next();
                        System.out.print("Enter credit card cvv: ");
                        String cvv = scanner.next();
                        System.out.print("Enter credit card expiry date: ");
                        String expiryDate = scanner.next();
                        payment = new CreditCard(name, cardNumber, cvv, expiryDate);
                    }
                    case 4 -> {
                        System.out.print("Enter promo code: ");
                        String promoCode = scanner.next();
                        PromoCodePaymentMethod promoCodePaymentMethod = new PromoCodePaymentMethodImplementation();
                        Cart cart = new Cart();
                        payment = new PromoCodePaymentAdapter(promoCodePaymentMethod, promoCode, cart);
                    }
                    default -> System.out.println("Invalid choice");
                }

                if (payment != null) {
                    payment.pay();
                    System.out.println("Done! Thank you for buying");
                }

            } else {
                Cart cart = new Cart();

                Item item1 = new Item("0153", "Dozol", 4990);
                Item item2 = new Item("0153", "Waka", 7990);
                Item item3 = new Item("0153", "ElfBar", 4990);

                cart.addItem(item1);
                cart.addItem(item2);
                cart.addItem(item2);
                cart.addItem(item3);

                List<Item> itemsInCart = cart.getItems();
                System.out.println("Items in Main.Cart:");
                for (Item item : itemsInCart) {
                    System.out.println(item.getUpcCode() + " " + item.getName() + " " + item.getPrice());
                }
                System.out.println("Amount of money for pay is " + cart.calculateTotal());


                System.out.println("Choose a payment method:");
                System.out.println("1. PayPal");
                System.out.println("2. Cash");
                System.out.println("3. Credit Card");
                System.out.println("4. Promo Code");
                int choice = scanner.nextInt();
                IPayment payment = null;

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter PayPal email: ");
                        String email = scanner.next();
                        System.out.print("Enter PayPal password: ");
                        String password = scanner.next();
                        payment = new Paypal(email, password);
                    }
                    case 2 -> {
                        System.out.print("Enter payment amount (cash): ₸");
                        int check = scanner.nextInt();
                        payment = new Cash(check);
                    }
                    case 3 -> {
                        System.out.print("Enter cardholder name: ");
                        String name = scanner.next();
                        System.out.print("Enter credit card number: ");
                        String cardNumber = scanner.next();
                        System.out.print("Enter credit card cvv: ");
                        String cvv = scanner.next();
                        System.out.print("Enter credit card expiry date: ");
                        String expiryDate = scanner.next();
                        payment = new CreditCard(name, cardNumber, cvv, expiryDate);
                    }
                    case 4 -> {
                        System.out.print("Enter promo code: ");
                        String promoCode = scanner.next();
                        PromoCodePaymentMethod promoCodePaymentMethod = new PromoCodePaymentMethodImplementation();
                        payment = new PromoCodePaymentAdapter(promoCodePaymentMethod, promoCode, cart);
                    }
                    default -> System.out.println("Invalid choice");
                }

                if (payment != null) {
                    payment.pay();
                    System.out.println("Done! Thank you for buying");
                    Sales shops = Sales.getInstance("Ozzy's Vape Shop");

                    System.out.println("Shop Name: " + shop.getShopName());

                    VapeProduct product1 = new Ejuice("Dozol", 4990);
                    shops.sellProduct(product1, 1);
                    VapeProduct product2 = new Ejuice("Waka", 7990);
                    shops.sellProduct(product2, 2);
                    VapeProduct product3 = new Ejuice("ElfBar", 4990);
                    shops.sellProduct(product3, 1);

                }
            }
        }
    }
}


