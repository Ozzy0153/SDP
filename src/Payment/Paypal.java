package Payment;

import java.util.Scanner;

public class Paypal implements IPayment {
    private String emailId;
    private String password;

    public void Paypal(String email, String pwd){
        this.emailId=email;
        this.password=pwd;
    }


    @Override
    public void pay() {


    }

/*
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Payment.Paypal");
    }
*/
}
