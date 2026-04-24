import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase7TargetUnitAdditionTest {

    private static final double EPSILON = 1e-3;

    @Test
    void testAddition_TargetFeet() {
        var q1 = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.FEET);
        var q2 = new UseCase7TargetUnitAddition.Quantity(12.0, UseCase7TargetUnitAddition.LengthUnit.INCH);

        var result = q1.add(q2, UseCase7TargetUnitAddition.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_TargetInches() {
        var q1 = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.FEET);
        var q2 = new UseCase7TargetUnitAddition.Quantity(12.0, UseCase7TargetUnitAddition.LengthUnit.INCH);

        var result = q1.add(q2, UseCase7TargetUnitAddition.LengthUnit.INCH);

        assertEquals(24.0, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_TargetYards() {
        var q1 = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.FEET);
        var q2 = new UseCase7TargetUnitAddition.Quantity(12.0, UseCase7TargetUnitAddition.LengthUnit.INCH);

        var result = q1.add(q2, UseCase7TargetUnitAddition.LengthUnit.YARD);

        assertEquals(0.666, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_TargetCentimeters() {
        var q1 = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.INCH);
        var q2 = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.INCH);

        var result = q1.add(q2, UseCase7TargetUnitAddition.LengthUnit.CM);

        assertEquals(5.08, result.getValue(), 1e-2);
    }

    @Test
    void testAddition_Commutativity() {
        var a = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.FEET);
        var b = new UseCase7TargetUnitAddition.Quantity(12.0, UseCase7TargetUnitAddition.LengthUnit.INCH);

        var r1 = a.add(b, UseCase7TargetUnitAddition.LengthUnit.YARD);
        var r2 = b.add(a, UseCase7TargetUnitAddition.LengthUnit.YARD);

        assertEquals(r1.getValue(), r2.getValue(), EPSILON);
    }

    @Test
    void testAddition_NullTargetUnit() {
        var q1 = new UseCase7TargetUnitAddition.Quantity(1.0, UseCase7TargetUnitAddition.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            q1.add(q1, null);
        });
    }
}