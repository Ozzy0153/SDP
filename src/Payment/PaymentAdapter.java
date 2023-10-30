package Payment;

import java.util.Scanner;

public class PaymentAdapter implements IPayment {
    private IPayment paymentSystem;

    public PaymentAdapter(IPayment paymentSystem) {
        this.paymentSystem = paymentSystem;
    }


    /*   @Override
       public void pay(int amount) {

       }
   */
    @Override
    public void pay() {
        if (paymentSystem instanceof Paypal) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter PayPal email: ");
            String emailId = scanner.nextLine();
            System.out.print("Enter PayPal password: ");
            String password = scanner.nextLine();
            ((Paypal) paymentSystem).Paypal(emailId, password);
        } else if (paymentSystem instanceof Cash) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter payment amount (cash): ");
            int check = scanner.nextInt();
            ((Cash) paymentSystem).Cash(check);
        } else if (paymentSystem instanceof CreditCard) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter cardholder name: ");
            String name = scanner.nextLine();
            System.out.print("Enter credit card number: ");
            String cardNumber = scanner.nextLine();
            System.out.print("Enter credit card cvv: ");
            String cvv = scanner.nextLine();
            System.out.print("Enter credit card expiry date: ");
            String dateOfExpiry = scanner.nextLine();
            ((CreditCard) paymentSystem).CreditCard(name, cardNumber, cvv, dateOfExpiry);
        }
    }
}

