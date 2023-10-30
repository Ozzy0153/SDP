package Adapter;

import Adapter.PromoCodePaymentMethod;

public class PromoCodePaymentMethodImplementation implements PromoCodePaymentMethod {
    @Override
    public double getDiscountPercentage(String promoCode) {
        if ("Free".equalsIgnoreCase(promoCode)) {
            return 1.0;
        } else if ("Half".equalsIgnoreCase(promoCode)) {
            return 0.5;
        }
        return 0.0;
    }
}
