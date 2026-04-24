public class UseCase8QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println("Equality: " + q1.equals(q2));

        System.out.println("Convert: " + q1.convertTo(LengthUnit.INCHES));

        System.out.println("Addition: " + q1.add(q2, LengthUnit.FEET));
    }
}