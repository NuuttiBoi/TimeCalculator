import org.example.TimeCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TimeCalculatorTest {
    @Test
    public void testCalculateTimeNormalCase() {
        TimeCalculator calculator = new TimeCalculator();
        assertEquals(2.0, calculator.calculateTime(100.0, 50.0), 0.0001);
    }

    @Test
    public void testCalculateTimeZeroSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, 0);
        });
    }

    @Test
    public void testCalculateTimeNegativeSpeed() {
        TimeCalculator calculator = new TimeCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateTime(100, -10);
        });
    }


    @Test
    public void testCalculateTimeMiles() {
        TimeCalculator calculator = new TimeCalculator();
        double distance = 100.0;  // miles
        double speed = 50.0;      // miles per hour
        double expectedTime = 2.0; // hours
        double actualTime = calculator.calculateTimeDifUnits(distance, speed, TimeCalculator.Unit.MILES, TimeCalculator.Unit.MILES);
        assertEquals(expectedTime, actualTime,0.0001);
    }

}
