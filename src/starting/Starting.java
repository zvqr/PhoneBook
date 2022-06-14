package starting;

import java.io.IOException;
import java.util.Scanner;

import static menus.initial.InitialMenu.signIn;
import static menus.initial.InitialMenu.signUp;

public class Starting {

    private static void listInitialMenuCommands(){
        System.out.println("1 - for sign up");
        System.out.println("2 - for sign in");
        System.out.println("3 - exit");
    }

    public static void startTheProgram() throws IOException {

        System.out.println("Type the number of the command you want");
        listInitialMenuCommands();
        Scanner sc = new Scanner(System.in);
        int userInput;
        do{
            System.out.print("> ");
            userInput = sc.nextInt();
            switch (userInput) {
                case 1 -> signUp();
                case 2 -> signIn();
                case 3 -> System.exit(-1);
                default -> System.out.println("Invalid command!");
            }
        }while (userInput != 1 || userInput != 2 || userInput != 3);

        sc.close();
    }
}
