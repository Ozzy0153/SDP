package Singleton;

import Factory.VapeProduct;

public class Sales {
    private static Sales instance;
    private final String shopName;

    // Private constructor to prevent external instantiation.
    private Sales(String shopName) {
        this.shopName = shopName;
    }

    public static Sales getInstance(String shopName) {
        if (instance == null) {
            instance = new Sales(shopName);
        }
        return instance;
    }

    public String getShopName() {
        return shopName;
    }

    public void sellProduct(VapeProduct product, int quantity) {
        System.out.println("Sold " + quantity + " of " + product.getName() + " from " + shopName);
    }
}

