package validations.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator {

    public static boolean isValidUsername(final String username) {
        final String USERNAME_PATTERN =
                "^[a-zA-Z0-9]([_-](?![_-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
}
