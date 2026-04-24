import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase2FeetInchesEqualityTest {

    // FEET TESTS
    @Test
    void testFeetEquality_SameValue() {
        UseCase2FeetInchesEquality.Feet f1 = new UseCase2FeetInchesEquality.Feet(1.0);
        UseCase2FeetInchesEquality.Feet f2 = new UseCase2FeetInchesEquality.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        UseCase2FeetInchesEquality.Feet f1 = new UseCase2FeetInchesEquality.Feet(1.0);
        UseCase2FeetInchesEquality.Feet f2 = new UseCase2FeetInchesEquality.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    // INCH TESTS
    @Test
    void testInchEquality_SameValue() {
        UseCase2FeetInchesEquality.Inch i1 = new UseCase2FeetInchesEquality.Inch(1.0);
        UseCase2FeetInchesEquality.Inch i2 = new UseCase2FeetInchesEquality.Inch(1.0);

        assertTrue(i1.equals(i2));
    }

    @Test
    void testInchEquality_DifferentValue() {
        UseCase2FeetInchesEquality.Inch i1 = new UseCase2FeetInchesEquality.Inch(1.0);
        UseCase2FeetInchesEquality.Inch i2 = new UseCase2FeetInchesEquality.Inch(2.0);

        assertFalse(i1.equals(i2));
    }

    // COMMON TESTS
    @Test
    void testNullComparison() {
        UseCase2FeetInchesEquality.Feet f1 = new UseCase2FeetInchesEquality.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testSameReference() {
        UseCase2FeetInchesEquality.Inch i1 = new UseCase2FeetInchesEquality.Inch(1.0);

        assertTrue(i1.equals(i1));
    }

    @Test
    void testDifferentType() {
        UseCase2FeetInchesEquality.Feet f1 = new UseCase2FeetInchesEquality.Feet(1.0);

        assertFalse(f1.equals("1.0"));
    }
}