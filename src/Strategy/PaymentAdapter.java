package Strategy;

class PaymentAdapter implements IPayment {
    private IPayment paymentSystem;

    public PaymentAdapter(IPayment paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    @Override
    public void pay() {
        paymentSystem.pay();
    }
}


