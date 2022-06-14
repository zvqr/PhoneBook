package users;

import creating.contacts.Contact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static contacts.file.functionality.ContactsFunctionality.saveToContactFile;
import static validations.contact.ContactValidators.isValidName;
import static validations.contact.ContactValidators.isValidTelephoneNumber;
import static validations.user.PasswordValidator.isValidPassword;

public class User {
    private String username;
    private String password;
    private ArrayList<Contact> contacts;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void changeCurrentPassword(){
        System.out.println("Note: THE PASSWORD MUST CONTAIN AT LEAST ONE DIGIT, LOWER AND UPPER CASE ALPHABET, SPECIAL CHARACTER, " +
                "NO WHITE SPACES AND THE LENGTH MUST BE BETWEEN 8 AND 20 CHARACTERS");
        System.out.print("Enter new password: ");
        Scanner sc = new Scanner(System.in);
        String newPass;
        do {
            newPass = sc.nextLine();
        }while (isValidPassword(newPass));
        sc.close();

        this.setPassword(newPass);

    }

    public void addContact(Contact contact){
        if (contacts == null){
            contacts = new ArrayList<>();
        }
        contacts.add(contact);
    }

    public void createNewContact(){
        Scanner sc = new Scanner(System.in);
        String firstName;
        do{
            System.out.print("Enter first name: ");
            firstName = sc.nextLine();

        }while (isValidName(firstName));

        String lastName;
        do{
            System.out.print("Enter last name: ");
            lastName = sc.nextLine();

        }while (isValidName(lastName));

        String telNumber;
        do{
            System.out.print("Enter personal telephone number: ");
            telNumber = sc.nextLine();

        }while (isValidTelephoneNumber(telNumber));

        Contact newContact = new Contact(firstName, lastName, telNumber);
        addContact(newContact);

        saveToContactFile(this, newContact);
    }

    public void deleteContact(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the contact personal number: ");
        String personalNumber = sc.nextLine();
        if(isValidTelephoneNumber(personalNumber)){
            contacts.removeIf(contact -> personalNumber.equals(contact.getPersonalPhone()));
        }else {
            System.out.println("Wrong entered number!");
        }
    }

    public void listAllContacts(){
        if(contacts != null){
            for (Contact contact :
                    contacts) {
                System.out.println(contact);
            }
        }else{
            System.out.println("There are no contacts yet!");
        }
    }

    public void loadContactByName(){
        System.out.println("Searching by first name");
        String name;
        Scanner frstName = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        name = frstName.nextLine();
        int count = 0;
        for (Contact contact :
                contacts) {
            if(name.equalsIgnoreCase(contact.getFirstName())){
                count++;
                System.out.println(contact);
            }
        }
        if(count == 0){
            System.out.println("Does not exist a contact with such name");
        }

    }

    public void loadContactByPersonalPhoneNumber(){
        System.out.println("Searching by personal phone number");
        String personalNumber;
        Scanner prsnNumber = new Scanner(System.in);
        System.out.println("Enter the personal phone number: ");
        personalNumber = prsnNumber.nextLine();
        int count = 0;
        for (Contact contact :
                contacts) {
            if(personalNumber.equals(contact.getPersonalPhone())){
                count++;
                System.out.println(contact);
            }
        }
        if(count == 0){
            System.out.println("Does not exist a contact with such name");
        }
    }

    public void editContact(){
        System.out.println("To choose a contact for edit enter a personal phone number");
        Scanner sc = new Scanner(System.in);
        String personalNumber;
        do{
            System.out.println("Enter the personal phone number: ");
            personalNumber = sc.nextLine();
        }while(isValidTelephoneNumber(personalNumber));
        sc.close();

        boolean exists = false;
        for (Contact contact :
                contacts) {
            if(personalNumber.equals(contact.getPersonalPhone())){
                exists = true;
                contact.edit();
            }
        }
        if(!exists){
            System.out.println("Contact with this number does not exists!");
        }
    }

    @Override
    public String toString() {
        return getUsername() + "," + getPassword();
    }
}
