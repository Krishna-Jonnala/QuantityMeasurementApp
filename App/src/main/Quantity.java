public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // ================= ENUM =================
    private enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        DIVIDE((a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        });

        private final java.util.function.DoubleBinaryOperator op;

        ArithmeticOperation(java.util.function.DoubleBinaryOperator op) {
            this.op = op;
        }

        public double compute(double a, double b) {
            return op.applyAsDouble(a, b);
        }
    }

    // ================= VALIDATION =================
    private void validate(Quantity<U> other, U targetUnit, boolean needTarget) {

        if (other == null)
            throw new IllegalArgumentException("Other cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Different measurement types");

        if (!Double.isFinite(value) || !Double.isFinite(other.value))
            throw new IllegalArgumentException("Invalid numbers");

        if (needTarget && targetUnit == null)
            throw new IllegalArgumentException("Target unit required");
    }

    // ================= CORE HELPER =================
    private double perform(Quantity<U> other, ArithmeticOperation op) {

        double base1 = unit.toBaseUnit(value);
        double base2 = other.unit.toBaseUnit(other.value);

        return op.compute(base1, base2);
    }

    // ================= ADD =================
    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        validate(other, targetUnit, true);

        double base = perform(other, ArithmeticOperation.ADD);
        double result = targetUnit.fromBaseUnit(base);

        return new Quantity<>(round(result), targetUnit);
    }

    // ================= SUBTRACT =================
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        validate(other, targetUnit, true);

        double base = perform(other, ArithmeticOperation.SUBTRACT);
        double result = targetUnit.fromBaseUnit(base);

        return new Quantity<>(round(result), targetUnit);
    }

    // ================= DIVIDE =================
    public double divide(Quantity<U> other) {
        validate(other, null, false);

        return perform(other, ArithmeticOperation.DIVIDE);
    }

    // ================= ROUND =================
    private double round(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}