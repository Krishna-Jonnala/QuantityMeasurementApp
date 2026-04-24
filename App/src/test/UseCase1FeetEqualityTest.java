import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase1FeetEqualityTest {

    @Test
    void testEquality_SameValue() {
        UseCase1FeetEquality.Feet f1 = new UseCase1FeetEquality.Feet(1.0);
        UseCase1FeetEquality.Feet f2 = new UseCase1FeetEquality.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        UseCase1FeetEquality.Feet f1 = new UseCase1FeetEquality.Feet(1.0);
        UseCase1FeetEquality.Feet f2 = new UseCase1FeetEquality.Feet(2.0);

        assertFalse(f1.equals(f2));
    }

    @Test
    void testEquality_NullComparison() {
        UseCase1FeetEquality.Feet f1 = new UseCase1FeetEquality.Feet(1.0);

        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_SameReference() {
        UseCase1FeetEquality.Feet f1 = new UseCase1FeetEquality.Feet(1.0);

        assertTrue(f1.equals(f1));
    }

    @Test
    void testEquality_DifferentType() {
        UseCase1FeetEquality.Feet f1 = new UseCase1FeetEquality.Feet(1.0);

        assertFalse(f1.equals("1.0"));
    }
}