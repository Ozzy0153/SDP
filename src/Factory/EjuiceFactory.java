package Factory;

public class EjuiceFactory implements VapeProductFactory {
    @Override
    public VapeProduct createProduct(String name, double price) {
        return new Ejuice(name, price);
    }
}
