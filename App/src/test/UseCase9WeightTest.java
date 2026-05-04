import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9WeightTest {

    @Test
    void testEquality_KgToGram() {
        assertTrue(new QuantityWeight(1, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(1000, WeightUnit.GRAM)));
    }

    @Test
    void testEquality_KgToPound() {
        assertTrue(new QuantityWeight(1, WeightUnit.KILOGRAM)
                .equals(new QuantityWeight(2.20462, WeightUnit.POUND)));
    }

    @Test
    void testConversion() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .convertTo(WeightUnit.GRAM);

        assertEquals(1000, result.getValue(), 0.01);
    }

    @Test
    void testAddition() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM));

        assertTrue(result.equals(new QuantityWeight(2, WeightUnit.KILOGRAM)));
    }

    @Test
    void testAdditionWithTargetUnit() {
        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM), WeightUnit.GRAM);

        assertEquals(2000, result.getValue(), 0.01);
    }
}