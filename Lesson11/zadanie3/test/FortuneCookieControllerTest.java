import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortuneCookieControllerTest {

    private static FortuneCookieController goodFactoryController;
    private static FortuneCookieController badFactoryController;

    public static FortuneCookieFactory create(boolean isPositive) {
        FortuneConfig config = new FortuneConfig(isPositive);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        return new FortuneCookieFactory(config,
                positive,
                negative
        );
    }

    @BeforeAll
    static void beforeAll() {
        goodFactoryController = new FortuneCookieController(create(true));
        badFactoryController = new FortuneCookieController(create(false));
    }

    @Test
    void shouldReturnPositiveFortune() {
        assertEquals("positive", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    void shouldReturnNegativeFortune() {
        assertEquals("negative", badFactoryController.tellFortune().getFortuneText());
    }


}