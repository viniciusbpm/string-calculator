import static java.lang.Double.parseDouble;

public class StringCalculator {
    public double add(String input){
        if(input.isBlank()){
            return 0;
        }

        double sum = 0;

        for(String value : input.split(",")){
            sum += parseDouble(value);
        }

        return sum;
    }
}
