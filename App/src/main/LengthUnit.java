public enum LengthUnit implements IMeasurable {

    FEET(1.0),
    INCHES(1.0 / 12.0);

    private final double factor;

    LengthUnit(double factor) {
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