package menus.initial;

import users.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static authentication.Authenticator.userAuthentication;
import static contacts.file.functionality.UserFunctionality.saveToUsersFile;
import static load.file.data.LoadFileData.loadContactsDataFromFile;
import static load.file.data.LoadFileData.loadUserDataFromFile;
import static validations.user.PasswordValidator.isValidPassword;
import static validations.user.UsernameValidator.isValidUsername;

public class InitialMenu {

    public static void signUp() throws IOException {
        Scanner userInput = new Scanner(System.in);
        String username;
        String password;

        do{
            System.out.print("Enter a username: ");
            username = new String(userInput.nextLine());

            System.out.print("Enter a password: ");
            password = new String(userInput.nextLine());
        }while (isValidUsername(username) && isValidPassword(password) && userAuthentication(username, password));

        userInput.close();

        User newUser = new User(username, password);
        saveToUsersFile(newUser);
        File newFile = new File("src/files/", username + ".csv");
        newFile.createNewFile();

    }

    public static void signIn() throws IOException {
        Scanner userInput = new Scanner(System.in);
        String username;
        String password;

        System.out.print("Enter a username: ");
        username = new String(userInput.nextLine());

        System.out.print("Enter a password: ");
        password = new String(userInput.nextLine());

        if(userAuthentication(username, password)){
            User currUser = loadUserDataFromFile(username,password);
            loadContactsDataFromFile(currUser);

            Scanner sc = new Scanner(System.in);
            System.out.println("Type the number of the command you want");
            listMainMenuCommands();
            int userChoice;
            do{
                System.out.print("> ");
                userChoice = sc.nextInt();
                switch (userChoice) {
                    case 1 -> currUser.listAllContacts();
                    case 2 -> currUser.loadContactByName();
                    case 3 -> currUser.loadContactByPersonalPhoneNumber();
                    case 4 -> currUser.createNewContact();
                    case 5 -> currUser.deleteContact();
                    case 6 -> currUser.editContact();
                    case 7 -> currUser.changeCurrentPassword();
                    case 8 -> listMainMenuCommands();
                    case 9 -> System.exit(-1);
                    default -> System.out.println("Invalid command!");
                }
            }while(userChoice != 1 || userChoice != 2 || userChoice != 3 || userChoice != 4 ||
                    userChoice != 5 || userChoice != 6 || userChoice != 7 || userChoice != 8 || userChoice != 9 );
            sc.close();

        }else {
            System.out.println("There no such user in the register!");
        }

    }

    private static void listMainMenuCommands() {
        System.out.println("1 - lists all saved contacts in alphabetical order");
        System.out.println("2 - searches for a specific record by name");
        System.out.println("3 - searches for a specific record by number");
        System.out.println("4 - saves a new contact entry into the phone book");
        System.out.println("5 - removes a contact from the phone book");
        System.out.println("6 - modifies an existing contact");
        System.out.println("7 - for changing user password");
        System.out.println("8 - lists all valid commands");
        System.out.println("9 - for exit");
        System.out.println("===========================");
    }

}
