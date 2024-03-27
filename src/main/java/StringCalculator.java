import utils.RegularExpressionMatch;

import static java.util.Arrays.stream;
import static utils.RegularExpressionMatch.getValueSubstringFromRegularExpression;

public class StringCalculator {
    public double add(String input){
        throwExceptionIfIllegalUseOfSeparators(input);
        throwExceptionIfLastCharacterIsNotANumber(input);
        return stream(input.split("[,\\n]"))
                .filter(value -> !value.isBlank())
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    private void throwExceptionIfLastCharacterIsNotANumber(String input) {
        String lastNumericCharacter = getValueSubstringFromRegularExpression(input, "[\\d]\\z");
        if(lastNumericCharacter.isBlank()){
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
