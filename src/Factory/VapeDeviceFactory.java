package Factory;

public class VapeDeviceFactory implements VapeProductFactory {
    @Override
    public VapeProduct createProduct(String name, double price) {
        return new VapeDevice(name, price);
    }
}
