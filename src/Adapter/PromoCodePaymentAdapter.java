package Adapter;

import Strategy.*;
import Main.*;

public class PromoCodePaymentAdapter implements IPayment {
    private PromoCodePaymentMethod promoCodePaymentMethod;
    private String promoCode;
    private Cart cart; // Add a Cart instance

    public PromoCodePaymentAdapter(PromoCodePaymentMethod promoCodePaymentMethod, String promoCode, Cart cart) {
        this.promoCodePaymentMethod = promoCodePaymentMethod;
        this.promoCode = promoCode;
        this.cart = cart; // Initialize the Cart instance
    }

    @Override
    public void pay() {
        double discountPercentage = promoCodePaymentMethod.getDiscountPercentage(promoCode);

        if (discountPercentage == 0.0) {
            System.out.println("Invalid or unrecognized promo code.");
        } else {
            double totalAmount = cart.calculateTotal(); // Calculate total from the Cart instance
            double discount = totalAmount * discountPercentage;
            double discountedAmount = totalAmount - discount;
            System.out.println("Payment successful! Original Amount: ₸" + totalAmount);
            System.out.println("Discounted Amount: ₸" + discountedAmount);
        }
    }
}
