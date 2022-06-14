package validations.contact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactValidators {

    public static boolean isValidName(String name){
        final String NAME_PATTERN =
                "[a-zA-Z][a-z](.{0,23}[a-z])?";
        final Pattern pattern = Pattern.compile(NAME_PATTERN);

        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean isValidTelephoneNumber(String telNumber){
        final String TELEPHONE_NUMBER_PATTERN =
                "^08{8}$";
        final Pattern pattern = Pattern.compile(TELEPHONE_NUMBER_PATTERN);

        Matcher matcher = pattern.matcher(telNumber);
        return matcher.matches();
    }
}
