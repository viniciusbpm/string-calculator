import static java.util.Arrays.stream;

public class StringCalculator {
    public double add(String input){
        return stream(input.split("[,\\n]"))
                .filter(value -> !value.isBlank())
                .mapToDouble(Double::parseDouble)
                .sum();
    }
}
