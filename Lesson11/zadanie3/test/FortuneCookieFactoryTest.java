import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortuneCookieFactoryTest {
    private static FortuneCookieFactory factory;

    @BeforeEach
    void beforeEach() {
        FortuneConfig config = new FortuneConfig(true);
        ArrayList<String> positive = new ArrayList<>();
        positive.add("positive");
        ArrayList<String> negative = new ArrayList<>();
        negative.add("negative");
        factory = new FortuneCookieFactory(config,
                positive,
                negative
        );
    }

    @Test
    void shouldIncrementCountByOneAfterOneCookieBaked() {
        factory.bakeFortuneCookie();
        assertEquals(1, factory.getCookiesBaked());
    }

    @Test
    void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        factory.bakeFortuneCookie();
        factory.bakeFortuneCookie();
        assertEquals(2, factory.getCookiesBaked());
    }

    @Test
    void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        factory.bakeFortuneCookie();
        factory.resetCookiesCreated();
        assertEquals(0, factory.getCookiesBaked());
    }
}