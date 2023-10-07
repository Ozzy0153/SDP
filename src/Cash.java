public class Cash implements IPayment {
    private int money;

    public Cash(int check) {
        this.money = check;
    }


    @Override
    public void pay(int amount) {
        if (money == amount) {
            System.out.println(amount + " paid with Cash");
        }
    }
}