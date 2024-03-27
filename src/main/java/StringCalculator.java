import java.util.Arrays;

import static java.lang.Double.parseDouble;
import static java.util.Arrays.stream;

public class StringCalculator {
    public double add(String input){
        return stream(input.split(","))
                .filter(value -> !value.isBlank())
                .mapToDouble(Double::parseDouble)
                .sum();
    }
}
