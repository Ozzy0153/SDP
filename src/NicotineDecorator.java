abstract class NicotineDecorator implements ILiquid{
    private final ILiquid decoratedVapeLiquid;

    public NicotineDecorator(ILiquid decoratedVapeLiquid) {
        this.decoratedVapeLiquid = decoratedVapeLiquid;
    }
    @Override
    public String getDescription() {
        return decoratedVapeLiquid.getDescription();
    }

    @Override
    public double getPrice() {
        return decoratedVapeLiquid.getPrice();
    }
}
