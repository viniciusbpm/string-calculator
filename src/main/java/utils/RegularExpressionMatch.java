package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatch {
    private static final String EMPTY_STRING = "";
    public static boolean matches(String value, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
    public static String getValueSubstringFromRegularExpression(String value, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if(matcher.find()){
            return matcher.group(0);
        } else {
            return EMPTY_STRING;
        }
    }
}
