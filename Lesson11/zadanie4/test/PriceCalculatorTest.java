import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {

    private final PriceCalculator priceCalculator = new PriceCalculator();

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs0Km() {
        assertEquals(-1, priceCalculator.calculatePrice(TransportType.BIKE, 0));
    }

    @Test
    public void shouldReturn100ForBikeAndDistanceIs10Km() {
        assertEquals(100, priceCalculator.calculatePrice(TransportType.BIKE, 10));
    }

    @Test
    public void shouldBeNegativeWhenBikeAndDistanceIs21Km() {
        assertEquals(-2, priceCalculator.calculatePrice(TransportType.BIKE, 21));
    }


    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs0Km() {
        assertEquals(-1, priceCalculator.calculatePrice(TransportType.CAR, 0));
    }

    @Test
    public void shouldBeNegativeWhenCarAndDistanceIs1001Km() {
        assertEquals(-2, priceCalculator.calculatePrice(TransportType.CAR, 1001));
    }

    @Test
    public void shouldReturn7000ForCarAndDistanceIs1000Km() {
        assertEquals(7000, priceCalculator.calculatePrice(TransportType.CAR, 1000));
    }


    @Test
    public void shouldBeNegativeWhenTruckAndDistanceIs0Km() {
        assertEquals(-1, priceCalculator.calculatePrice(TransportType.TRUCK, 0));
    }

    @Test
    public void shouldReturn5000ForTruckAndDistanceIs1000Km() {
        assertEquals(5000, priceCalculator.calculatePrice(TransportType.TRUCK, 1000));
    }

    @Test
    public void shouldBeNullWhenDroneAndDistanceIs0Km() {
        assertNull(priceCalculator.calculatePrice(TransportType.DRONE, 0));

    }
}
