public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    // ✅ GETTERS (IMPORTANT FIX)
    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // ✅ CONVERSION
    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.toBase(value);
        double converted = targetUnit.fromBase(base);
        return new Quantity<>(converted, targetUnit);
    }

    // ✅ ADD (default unit)
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // ✅ ADD (target unit)
    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        double base1 = this.unit.toBase(this.value);
        double base2 = other.unit.toBase(other.value);

        double sum = base1 + base2;
        double result = targetUnit.fromBase(sum);

        return new Quantity<>(result, targetUnit);
    }

    // ✅ EQUALS
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        // Prevent cross-category comparison
        if (this.unit.getClass() != other.unit.getClass()) {
            return false;
        }

        double base1 = this.unit.toBase(this.value);
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    // ✅ HASHCODE
    @Override
    public int hashCode() {
        return Double.hashCode(unit.toBase(value));
    }

    // ✅ STRING
    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}