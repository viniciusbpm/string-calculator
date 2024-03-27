import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }
    @Test
    void testEmptyString(){
        assertEquals(0, stringCalculator.getOutput(""));
    }
}
