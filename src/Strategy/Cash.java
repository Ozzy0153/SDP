package Strategy;

public class Cash implements IPayment {
    private int money;

    public Cash(int check) {
        this.money = check;
    }

    @Override
    public void pay() {
        System.out.println("Paid with Cash: $" + money);
    }
}