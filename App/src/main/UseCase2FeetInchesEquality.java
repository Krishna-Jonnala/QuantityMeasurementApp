public class UseCase2FeetInchesEquality {

    // FEET CLASS
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // INCH CLASS
    public static class Inch {
        private final double value;

        public Inch(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || this.getClass() != obj.getClass()) return false;

            Inch other = (Inch) obj;
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // OPTIONAL METHODS (as per UC2 hint)
    public static boolean compareFeet(double v1, double v2) {
        return new Feet(v1).equals(new Feet(v2));
    }

    public static boolean compareInch(double v1, double v2) {
        return new Inch(v1).equals(new Inch(v2));
    }

    public static void main(String[] args) {
        System.out.println("Feet Equal: " + compareFeet(1.0, 1.0));
        System.out.println("Inch Equal: " + compareInch(1.0, 1.0));
    }
}