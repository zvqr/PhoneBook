package contacts.file.functionality;

import creating.contacts.Contact;
import users.User;

import java.io.*;

public class ContactsFunctionality {

    public static void saveToContactFile(User user,Contact contact){
        if(contact != null){
            try{
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/files/" +user.getUsername() +".csv", true));
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.println(contact);
                printWriter.flush();
                printWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
