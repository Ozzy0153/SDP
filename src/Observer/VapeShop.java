package Observer;

class VapeShop implements Observer {
    private final String name;
    private final double basePrice;

    public VapeShop(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public void update(double newBitcoinExchangeRate) {
        double priceChangePercentage = (newBitcoinExchangeRate - 29690.0) / 29690.0 * 100.0;
        double priceChangeFactor = 1 + (priceChangePercentage / 100.0);
        double newPrice = basePrice * priceChangeFactor;
        System.out.println("Product: " + name + ", New Price: " + newPrice);
    }
}
