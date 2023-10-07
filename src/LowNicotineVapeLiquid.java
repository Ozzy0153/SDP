public class LowNicotineVapeLiquid extends NicotineDecorator {

    public LowNicotineVapeLiquid(ILiquid decoratedVapeLiquid) {
        super(decoratedVapeLiquid);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Low Nicotine";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2000.0;
    }
}
