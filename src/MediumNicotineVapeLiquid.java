public class MediumNicotineVapeLiquid extends NicotineDecorator{
    public MediumNicotineVapeLiquid(ILiquid decoratedVapeLiquid) {
        super(decoratedVapeLiquid);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + " with Medium Nicotine";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 3500.0;
    }
}
