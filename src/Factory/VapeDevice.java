package Factory;

class VapeDevice implements VapeProduct {
    private String name;
    private double price;

    public VapeDevice(String name, double price) {
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
