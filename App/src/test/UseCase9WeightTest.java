import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9WeightTest {

    @Test
    void testEquality_KgToGram() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testConversion_KgToGram() {
        QuantityWeight q = new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight result = q.convertTo(WeightUnit.GRAM);

        assertEquals(new QuantityWeight(1000.0, WeightUnit.GRAM), result);
    }

    @Test
    void testAddition_DefaultUnit() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2);

        assertEquals(new QuantityWeight(2.0, WeightUnit.KILOGRAM), result);
    }

    @Test
    void testAddition_TargetUnit() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = q1.add(q2, WeightUnit.GRAM);

        assertEquals(new QuantityWeight(2000.0, WeightUnit.GRAM), result);
    }

    @Test
    void testAddition_Pound() {
        QuantityWeight q1 = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight q2 = new QuantityWeight(2.20462, WeightUnit.POUND);

        QuantityWeight result = q1.add(q2, WeightUnit.KILOGRAM);

        assertTrue(result.equals(new QuantityWeight(2.0, WeightUnit.KILOGRAM)));
    }
}