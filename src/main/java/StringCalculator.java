import utils.RegularExpressionMatch;

import static java.util.Arrays.stream;
import static utils.RegularExpressionMatch.getValueSubstringFromRegularExpression;

public class StringCalculator {
    private String delimiters = ",\\n";
    public double add(String input){
        throwExceptionIfIllegalUseOfSeparators(input);
        throwExceptionIfLastCharacterIsNotANumber(input);
        checkAndAddIfInputHasCustomDelimiter(input);
        return stream(input.split("[" + delimiters + "]"))
                .filter(value -> value.matches("\\d"))
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    private void checkAndAddIfInputHasCustomDelimiter(String input) {
        String customDelimiter = getValueSubstringFromRegularExpression(input, "(?<=\\/\\/).");
        if(!customDelimiter.isBlank()){
            delimiters += customDelimiter;
        }
    }

    private void throwExceptionIfLastCharacterIsNotANumber(String input) {
        String lastNumericCharacter = getValueSubstringFromRegularExpression(input, "[\\d]\\z");
        if(lastNumericCharacter.isBlank() && !input.isBlank()){
            throw new IllegalArgumentException("Number expected but EOF found");
        }
    }

    private void throwExceptionIfIllegalUseOfSeparators(String input) {
        String illegalSubstring = getValueSubstringFromRegularExpression(input, "(\\n,)|(,\\n)");
        if(!illegalSubstring.isBlank()){
            int indexOfIllegalSeparator = input.indexOf(illegalSubstring);
            throw new IllegalArgumentException("Number expected but '\\n' found at position "
                    + indexOfIllegalSeparator + ".");
        }
    }
}
