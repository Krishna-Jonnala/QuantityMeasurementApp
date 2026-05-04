public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Length Subtract: " + l1.subtract(l2));
        System.out.println("Length Divide: " + l1.divide(new Quantity<>(2.0, LengthUnit.FEET)));

        // WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println("Weight Subtract: " + w1.subtract(w2));
        System.out.println("Weight Divide: " + w1.divide(new Quantity<>(5.0, WeightUnit.KILOGRAM)));

        // VOLUME
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Subtract: " + v1.subtract(v2));
        System.out.println("Volume Divide: " + v1.divide(new Quantity<>(10.0, VolumeUnit.LITRE)));
    }
}