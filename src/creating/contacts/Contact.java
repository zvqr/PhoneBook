package creating.contacts;

import java.util.Date;
import java.util.Scanner;

import static validations.contact.ContactValidators.*;

public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String personalPhone;
    private String workPhone;
    private Date birthday;

    public Contact() {
        setFirstName(" ");
        setWorkPhone(" ");
        setAddress(" ");
        setPersonalPhone(" ");
        setWorkPhone(" ");
    }

    //without address, work phone number, birthday
    public Contact(String firstName, String lastName, String personalPhone) {
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setPersonalPhone(personalPhone);
    }

/*    //with address
    public Contact(StringBuilder firstName, StringBuilder lastName, StringBuilder address, StringBuilder personalPhone) {
        setFirstName(firstName);
        setLastName(lastName);
        setPersonalPhone(personalPhone);
        setAddress(address);
    }

    //with work phone number
    public Contact(StringBuilder firstName, StringBuilder lastName, StringBuilder personalPhone, StringBuilder workPhone) {
        this(firstName, lastName, personalPhone);
        setWorkPhone(workPhone);
    }

    //with  birthday
    public Contact(StringBuilder firstName, StringBuilder lastName, String personalPhone, Date birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setPersonalPhone(personalPhone);
        setBirthday(birthday);
    }

    //with address and work phone number
    public Contact(String firstName, String lastName, String address, String personalPhone, String workPhone) {
        this(firstName, lastName, address, personalPhone);
        setWorkPhone(workPhone);
    }

    //with address and birthday
    public Contact(String firstName, String lastName, String address, String personalPhone, Date birthday) {
        this(firstName, lastName, address, personalPhone);
        setBirthday(birthday);
    }

    //with work phone number and birthday
    public Contact(String firstName, String lastName, String personalPhone, String workPhone, Date birthday) {
        this(firstName, lastName, personalPhone, workPhone);
        setBirthday(birthday);
    }

    //with all
    public Contact(String firstName, String lastName, String address, String personalPhone, String workPhone, Date birthday) {
        this(firstName, lastName, address, personalPhone, workPhone);
        setBirthday(birthday);
    }
*/
    public Contact (String[] fileData){
        this(fileData[0],fileData[1],fileData[3]);
        //setFirstName(fileData[0]);
        //setLastName(fileData[1]);
        if(!fileData[2].isBlank()){
            setAddress(fileData[2]);
        }
        //setPersonalPhone(fileData[3]);
        if(!fileData[4].isBlank()){
            setWorkPhone(fileData[4]);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void edit(){

        System.out.println("1 - edit first name");
        System.out.println("2 - edit last name");
        System.out.println("3 - edit address name");
        System.out.println("4 - edit personal phone number");
        System.out.println("5 - edit work phone number");

        String name;
        String phoneNumber;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of the parameter you want to edit");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Editing first name");
                System.out.print("Enter first name: ");
                name = sc.nextLine();
                if(isValidName(name)){
                    setFirstName(name);
                }else {
                    System.out.println("Invalid entered name :(");
                }
                break;
            case 2:
                System.out.println("Editing last name");
                System.out.print("Enter last name: ");
                name = sc.nextLine();
                if(isValidName(name)){
                    setLastName(name);
                }else {
                    System.out.println("Invalid entered name :(");
                }
                break;
            case 3:
                System.out.println("Editing address");
                System.out.print("Enter address name: ");
                setAddress(sc.nextLine());
                break;
            case 4:
                System.out.println("Editing personal phone number");
                System.out.println("Note: MUST START WITH 08 AND HAVE 8 DIGITS AFTER");
                System.out.print("Enter personal phone number: ");
                phoneNumber = sc.nextLine();
                if(isValidTelephoneNumber(phoneNumber)){
                    setPersonalPhone(phoneNumber);
                }else {
                    System.out.println("Invalid entered phone number :(");
                }
                setPersonalPhone(sc.nextLine());
                break;
            case 5:
                System.out.println("Editing work phone number");
                System.out.println("Note: MUST START WITH 08 AND HAVE 8 DIGITS AFTER");
                System.out.print("Enter work phone number");
                phoneNumber = sc.nextLine();
                if(isValidTelephoneNumber(phoneNumber)){
                    setWorkPhone(phoneNumber);
                }else {
                    System.out.println("Invalid entered phone number :(");
                }
                setWorkPhone(sc.nextLine());
                break;
            default:
                System.out.println("invalid input");
        }
    }

    @Override
    public String toString() {
        if(address != null && workPhone != null){
            return firstName + "," + lastName + "," + address + "," + personalPhone + "," + workPhone;
        }else if(address != null ){
            return firstName + "," + lastName + "," + address + "," + personalPhone;
        }else if(workPhone != null){
            return firstName + "," + lastName +  "," + personalPhone + "," + workPhone;
        }else {
            return firstName + ", " + lastName + ", " + personalPhone ;
        }
    }
}