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
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void testStringHasOnlyOneValue(){
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void testStringHasTwoValues(){
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void testStringHasUnknownAmoutOfValues(){
        assertEquals(26, stringCalculator.add("1,2,5,4,6,8"));
        assertEquals(17, stringCalculator.add("1,2,6,8"));
        assertEquals(30, stringCalculator.add("1,2,5,4,6,8,4"));

    }
}
