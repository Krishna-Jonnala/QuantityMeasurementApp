public class UseCase4ExtendedUnits {

    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12),
        YARD(3.0),
        CM(0.393701 / 12); // convert cm → inches → feet

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }
    }

    public static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || this.getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisValue = this.unit.toBase(this.value);
            double otherValue = other.unit.toBase(other.value);

            return Double.compare(thisValue, otherValue) == 0;
        }
    }

    public static void main(String[] args) {
        Quantity q1 = new Quantity(1.0, LengthUnit.YARD);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        System.out.println("Equal: " + q1.equals(q2));
    }
}