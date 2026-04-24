public class UseCase5UnitConversion {

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
    }

    // 🔥 STATIC CONVERT METHOD (MAIN UC5 FEATURE)
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        // Convert to base (feet)
        double baseValue = source.toBase(value);

        // Convert to target
        return baseValue / target.toBase(1.0);
    }

    // Optional: Equality (reuse UC3/UC4 idea)
    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException();
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double v1 = unit.toBase(value);
            double v2 = other.unit.toBase(other.value);

            return Double.compare(v1, v2) == 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
    }
}