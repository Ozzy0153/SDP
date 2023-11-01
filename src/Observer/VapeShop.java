package Observer;

import java.util.ArrayList;
import java.util.List;

public class VapeShop {
    private String shopName;
    private List<ShopObserver> observers = new ArrayList<>();

    public VapeShop(String shopName) {
        this.shopName = shopName;
    }

    public void addObserver(ShopObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ShopObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (ShopObserver observer : observers) {
            observer.update(message);
        }
    }

    public String getShopName() {
        return shopName;
    }


    public void notifyNewProduct(String productName) {
        String message = "New product added by admin: " + productName;
        notifyObservers(message);
    }
}