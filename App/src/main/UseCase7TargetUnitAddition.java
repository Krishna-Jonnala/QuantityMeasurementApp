public class UseCase7TargetUnitAddition {

    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12),
        YARD(3.0),
        CM(0.393701 / 12);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }

        public double fromBase(double feetValue) {
            return feetValue / this.toFeet;
        }
    }

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }


        public Quantity add(Quantity other) {
            return add(other, this.unit);
        }


        public Quantity add(Quantity other, LengthUnit targetUnit) {

            if (other == null) throw new IllegalArgumentException("Other cannot be null");
            if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");

            double base1 = this.unit.toBase(this.value);
            double base2 = other.unit.toBase(other.value);

            double sum = base1 + base2;

            double resultValue = targetUnit.fromBase(sum);

            return new Quantity(resultValue, targetUnit);
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {
        Quantity q1 = new Quantity(1.0, LengthUnit.FEET);
        Quantity q2 = new Quantity(12.0, LengthUnit.INCH);

        System.out.println(q1.add(q2, LengthUnit.YARD));
    }
}