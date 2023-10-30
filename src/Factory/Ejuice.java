package Factory;

class Ejuice implements VapeProduct {
    private String name;
    private double price;

    public Ejuice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
