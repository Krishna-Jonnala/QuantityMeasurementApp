import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase5UnitConversionTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        double result = UseCase5UnitConversion.convert(1.0,
                UseCase5UnitConversion.LengthUnit.FEET,
                UseCase5UnitConversion.LengthUnit.INCH);

        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        double result = UseCase5UnitConversion.convert(24.0,
                UseCase5UnitConversion.LengthUnit.INCH,
                UseCase5UnitConversion.LengthUnit.FEET);

        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_YardToFeet() {
        double result = UseCase5UnitConversion.convert(3.0,
                UseCase5UnitConversion.LengthUnit.YARD,
                UseCase5UnitConversion.LengthUnit.FEET);

        assertEquals(9.0, result, EPSILON);
    }

    @Test
    void testConversion_CmToInch() {
        double result = UseCase5UnitConversion.convert(2.54,
                UseCase5UnitConversion.LengthUnit.CM,
                UseCase5UnitConversion.LengthUnit.INCH);

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        double result = UseCase5UnitConversion.convert(0.0,
                UseCase5UnitConversion.LengthUnit.FEET,
                UseCase5UnitConversion.LengthUnit.INCH);

        assertEquals(0.0, result, EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        double result = UseCase5UnitConversion.convert(-1.0,
                UseCase5UnitConversion.LengthUnit.FEET,
                UseCase5UnitConversion.LengthUnit.INCH);

        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    void testConversion_SameUnit() {
        double result = UseCase5UnitConversion.convert(5.0,
                UseCase5UnitConversion.LengthUnit.FEET,
                UseCase5UnitConversion.LengthUnit.FEET);

        assertEquals(5.0, result, EPSILON);
    }

    @Test
    void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            UseCase5UnitConversion.convert(1.0, null,
                    UseCase5UnitConversion.LengthUnit.FEET);
        });
    }

    @Test
    void testConversion_NaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            UseCase5UnitConversion.convert(Double.NaN,
                    UseCase5UnitConversion.LengthUnit.FEET,
                    UseCase5UnitConversion.LengthUnit.INCH);
        });
    }

    @Test
    void testConversion_RoundTrip() {
        double value = 5.0;

        double converted = UseCase5UnitConversion.convert(value,
                UseCase5UnitConversion.LengthUnit.FEET,
                UseCase5UnitConversion.LengthUnit.INCH);

        double back = UseCase5UnitConversion.convert(converted,
                UseCase5UnitConversion.LengthUnit.INCH,
                UseCase5UnitConversion.LengthUnit.FEET);

        assertEquals(value, back, EPSILON);
    }
}