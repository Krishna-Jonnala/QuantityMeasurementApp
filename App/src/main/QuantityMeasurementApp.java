public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> q1 = new Quantity<>(10, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6, LengthUnit.INCHES);

        System.out.println("Add: " + q1.add(q2));
        System.out.println("Subtract: " + q1.subtract(q2));
        System.out.println("Subtract (Inches): " + q1.subtract(q2, LengthUnit.INCHES));
        System.out.println("Divide: " + q1.divide(q2));
    }
}