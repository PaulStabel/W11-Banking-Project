package utilities;

import entities.Account;

import java.util.ArrayList;

import static entities.Account.accounts;
import static utilities.Utils.*;

public class Signup {

    public static boolean validateUsername(ArrayList<Account> accounts, String username) {
        if (username != null && !username.isBlank()) {
            if (Login.findUser(username, false) != null) {
                System.out.print("This username is taken. Please enter a different user name: ");
                return true;
            } else {
                System.out.println("username set to " + username);
                return false;
            }
        } else {
            System.out.print("Username cannot be neither null nor empty! Please enter a valid username: ");
            return true;
        }
    }

    public static boolean validatePassword(String password) {
        if (password != null && !password.isBlank() && password.length() >= 6) {
            System.out.println("password set to " + password);
            return false;
        } else {
            System.out.print("The given password wasn't secure enough! Please enter a different password (min. 6 characters): ");
            return true;
        }

    }

    public static boolean validatePinCode(String pinCode) {
        if (pinCode.matches("^\\d{4}$")) {
            System.out.println("You PIN is " + pinCode);
            return false;
        } else {
            System.out.print("Error! PIN must consist of 4 digits: ");
            return true;
        }
    }

    public static boolean validateName(String name, boolean isFirstName) {
        String s = isFirstName ? "First" : "Last";
        if (name != null && !name.isBlank() && name.chars().allMatch(Character::isLetter)) {
            System.out.println(s + "name set to " + name);
            return false;
        } else {
            System.out.print(s + " name cannot be empty and should contain only letters! Please try again: ");
            return true;
        }
    }

    public static boolean validateBalanceLimit(String amount) {
        if (parseDepositValues(amount)) {
            double value = Double.parseDouble(amount);
            System.out.println("Successfully added: " + value);
            return false;
        } else {
            System.out.print("Invalid amount entered! Please enter another amount: ");
            return true;
        }
    }

    public static void signUp() {
        System.out.print("Please pick a username: ");
        String username;
        do {
            username = scanner.nextLine().toLowerCase();
        } while (validateUsername(accounts, username));

        System.out.print("Please enter a password of your choice: ");
        String password;
        do {
            password = scanner.nextLine();
        } while (validatePassword(password));

        System.out.print("Please enter a PIN: ");
        String pinCode;
        do {
            pinCode = scanner.nextLine();
        } while (validatePinCode(pinCode));

        System.out.print("Please enter your first name: ");
        String firstName;
        do {
            firstName = scanner.nextLine();
        } while (validateName(firstName, true));

        System.out.print("Please enter your last name: ");
        String lastName;
        do {
            lastName = scanner.nextLine();
        } while (validateName(lastName, false));

        System.out.print("Please enter the initial deposit amount: ");
        String initialDepositAmount;
        do {
            initialDepositAmount = scanner.nextLine();
        } while (validateBalanceLimit(initialDepositAmount));

        System.out.print("Please choose a deposit limit: ");
        String depositLimit;
        do {
            depositLimit = scanner.nextLine();
        } while (validateBalanceLimit(depositLimit));

        System.out.print("Please choose a withdraw limit: ");
        String withdrawLimit;
        do {
            withdrawLimit = scanner.nextLine();
        } while (validateBalanceLimit(withdrawLimit));

        accounts.add(signUp(username, password, pinCode, firstName, lastName, initialDepositAmount, depositLimit, withdrawLimit));
        System.out.println("You have successfully signed up! Now please log in.\n");
        displayLoginMenu();
    }

    private static Account signUp(String username, String password, String pinCode, String firstName, String lastName, String initialDepositAmount, String depositLimit, String withdrawLimit) {
        return new Account(username, password, pinCode, firstName, lastName, initialDepositAmount, depositLimit, withdrawLimit);
    }
}
