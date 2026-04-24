import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase3QuantityLengthTest {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);
        UseCase3QuantityLength.Quantity q2 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.INCH);
        UseCase3QuantityLength.Quantity q2 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_FeetToInch_Equivalent() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);
        UseCase3QuantityLength.Quantity q2 =
                new UseCase3QuantityLength.Quantity(12.0, UseCase3QuantityLength.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_InchToFeet_Equivalent() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(12.0, UseCase3QuantityLength.LengthUnit.INCH);
        UseCase3QuantityLength.Quantity q2 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentValue() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);
        UseCase3QuantityLength.Quantity q2 =
                new UseCase3QuantityLength.Quantity(2.0, UseCase3QuantityLength.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void testSameReference() {
        UseCase3QuantityLength.Quantity q1 =
                new UseCase3QuantityLength.Quantity(1.0, UseCase3QuantityLength.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UseCase3QuantityLength.Quantity(1.0, null);
        });
    }
}