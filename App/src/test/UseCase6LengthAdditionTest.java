import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase6LengthAdditionTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        var q1 = new UseCase6LengthAddition.Quantity(1.0, UseCase6LengthAddition.LengthUnit.FEET);
        var q2 = new UseCase6LengthAddition.Quantity(2.0, UseCase6LengthAddition.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(3.0, result.getValue(), EPSILON);
        assertEquals(UseCase6LengthAddition.LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        var q1 = new UseCase6LengthAddition.Quantity(1.0, UseCase6LengthAddition.LengthUnit.FEET);
        var q2 = new UseCase6LengthAddition.Quantity(12.0, UseCase6LengthAddition.LengthUnit.INCH);

        var result = q1.add(q2);

        assertEquals(2.0, result.getValue(), EPSILON);
        assertEquals(UseCase6LengthAddition.LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        var q1 = new UseCase6LengthAddition.Quantity(12.0, UseCase6LengthAddition.LengthUnit.INCH);
        var q2 = new UseCase6LengthAddition.Quantity(1.0, UseCase6LengthAddition.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(24.0, result.getValue(), EPSILON);
        assertEquals(UseCase6LengthAddition.LengthUnit.INCH, result.getUnit());
    }

    @Test
    void testAddition_YardPlusFeet() {
        var q1 = new UseCase6LengthAddition.Quantity(1.0, UseCase6LengthAddition.LengthUnit.YARD);
        var q2 = new UseCase6LengthAddition.Quantity(3.0, UseCase6LengthAddition.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_CmPlusInch() {
        var q1 = new UseCase6LengthAddition.Quantity(2.54, UseCase6LengthAddition.LengthUnit.CM);
        var q2 = new UseCase6LengthAddition.Quantity(1.0, UseCase6LengthAddition.LengthUnit.INCH);

        var result = q1.add(q2);

        assertEquals(5.08, result.getValue(), 1e-2); // relaxed precision
    }

    @Test
    void testAddition_WithZero() {
        var q1 = new UseCase6LengthAddition.Quantity(5.0, UseCase6LengthAddition.LengthUnit.FEET);
        var q2 = new UseCase6LengthAddition.Quantity(0.0, UseCase6LengthAddition.LengthUnit.INCH);

        var result = q1.add(q2);

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        var q1 = new UseCase6LengthAddition.Quantity(5.0, UseCase6LengthAddition.LengthUnit.FEET);
        var q2 = new UseCase6LengthAddition.Quantity(-2.0, UseCase6LengthAddition.LengthUnit.FEET);

        var result = q1.add(q2);

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_Null() {
        var q1 = new UseCase6LengthAddition.Quantity(1.0, UseCase6LengthAddition.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }
}