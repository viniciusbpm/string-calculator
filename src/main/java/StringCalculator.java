import static java.lang.Double.parseDouble;

public class StringCalculator {
    public double add(String input){
        if(input.isBlank()){
            return 0;
        }

        return parseDouble(input);
    }
}
