package load.file.data;

import creating.contacts.Contact;
import users.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadFileData {

    public static User loadUserDataFromFile(String username, String password) throws IOException {
        User currentUser = new User(username, password);
        loadContactsDataFromFile(currentUser);
        return currentUser;
    }

    public static void loadContactsDataFromFile(User currentUser) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/files/" + currentUser.getUsername() + ".csv"));
        String line;
        while ( (line = bufferedReader.readLine() ) != null ){
            String[] fileData = line.split(",");
            Contact newContact = new Contact(fileData);
            currentUser.addContact(newContact);
        }
        bufferedReader.close();
    }
}
