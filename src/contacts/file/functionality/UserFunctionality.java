package contacts.file.functionality;

import users.User;

import java.io.*;

public class UserFunctionality {
    public static void saveToUsersFile(User user){
        if(user != null){
            try{
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/files/users.csv", true));
                PrintWriter printWriter = new PrintWriter(bufferedWriter);
                printWriter.println(user);
                printWriter.flush();
                printWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
