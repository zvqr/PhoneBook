package authentication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authenticator {

    public static boolean userAuthentication(String username, String password) throws IOException {
        boolean usernameFound = false;
        boolean passwordFound = false;

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/files/users.csv"));
        String line;
        while ( (line = bufferedReader.readLine() ) != null ){
            String[] fileData = line.split(",");
            if(username.equals(fileData[0])){
                usernameFound = true;
                if(password.equals(fileData[1])){
                    passwordFound = true;
                    break;
                }
            }
        }
        bufferedReader.close();

        return usernameFound && passwordFound;
    }
}
