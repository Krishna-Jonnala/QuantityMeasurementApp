public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert to another unit
    public QuantityWeight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Invalid target unit");
        }

        double base = unit.toBase(this.value);
        double converted = targetUnit.fromBase(base);

        return new QuantityWeight(converted, targetUnit);
    }

    // UC6 style → default (result in first unit)
    public QuantityWeight add(QuantityWeight other) {
        return add(other, this.unit);
    }

    // UC7 style → explicit target unit
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double base1 = this.unit.toBase(this.value);
        double base2 = other.unit.toBase(other.value);

        double sum = base1 + base2;

        double result = targetUnit.fromBase(sum);

        return new QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityWeight)) return false;

        QuantityWeight other = (QuantityWeight) obj;

        double base1 = this.unit.toBase(this.value);
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(unit.toBase(value));
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}