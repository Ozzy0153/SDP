package Decorator;

public class HighNicotineVapeLiquid extends NicotineDecorator{
    public HighNicotineVapeLiquid(ILiquid decoratedVapeLiquid) {
        super(decoratedVapeLiquid);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with High Nicotine";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 4500.0;
    }
}
