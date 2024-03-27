import static java.util.Arrays.stream;

public class StringCalculator {
    public double add(String input){
        if(input.contains("\n,") || input.contains(",\n")){
            throw new IllegalArgumentException("Damn");
        }

        return stream(input.split("[,\\n]"))
                .filter(value -> !value.isBlank())
                .mapToDouble(Double::parseDouble)
                .sum();
    }
}
