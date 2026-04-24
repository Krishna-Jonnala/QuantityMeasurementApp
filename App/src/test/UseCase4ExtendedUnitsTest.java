import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase4ExtendedUnitsTest {

    @Test
    void testEquality_YardToYard_SameValue() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);
        var q2 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToFeet_Equivalent() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);
        var q2 = new UseCase4ExtendedUnits.Quantity(3.0, UseCase4ExtendedUnits.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_YardToInch_Equivalent() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);
        var q2 = new UseCase4ExtendedUnits.Quantity(36.0, UseCase4ExtendedUnits.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CmToCm_SameValue() {
        var q1 = new UseCase4ExtendedUnits.Quantity(2.0, UseCase4ExtendedUnits.LengthUnit.CM);
        var q2 = new UseCase4ExtendedUnits.Quantity(2.0, UseCase4ExtendedUnits.LengthUnit.CM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_CmToInch_Equivalent() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.CM);
        var q2 = new UseCase4ExtendedUnits.Quantity(0.393701, UseCase4ExtendedUnits.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testEquality_DifferentValues() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);
        var q2 = new UseCase4ExtendedUnits.Quantity(2.0, UseCase4ExtendedUnits.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);

        assertFalse(q1.equals(null));
    }

    @Test
    void testSameReference() {
        var q1 = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.CM);

        assertTrue(q1.equals(q1));
    }

    @Test
    void testTransitiveProperty() {
        var a = new UseCase4ExtendedUnits.Quantity(1.0, UseCase4ExtendedUnits.LengthUnit.YARD);
        var b = new UseCase4ExtendedUnits.Quantity(3.0, UseCase4ExtendedUnits.LengthUnit.FEET);
        var c = new UseCase4ExtendedUnits.Quantity(36.0, UseCase4ExtendedUnits.LengthUnit.INCH);

        assertTrue(a.equals(b) && b.equals(c) && a.equals(c));
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UseCase4ExtendedUnits.Quantity(1.0, null);
        });
    }
}