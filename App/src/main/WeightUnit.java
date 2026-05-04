public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001);

    private final double factor;

    WeightUnit(double factor) {
        this.factor = factor;
    }

    @Override
    public double toBaseUnit(double value) {
        return value * factor;
    }

    @Override
    public double fromBaseUnit(double baseValue) {
        return baseValue / factor;
    }
}