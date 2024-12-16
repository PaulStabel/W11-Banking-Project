package utilities;

import entities.Account;

import static entities.Account.accounts;
import static utilities.Utils.*;

public class Login {

    static void login() {
        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();
        currentUser = findUserByName(username, password);
        if (currentUser != null) {
            displayUserMenu();
        } else {
            displayLoginMenu();
        }
    }

    private static Account findUserByName(String username, String password) {
        Account account = findUser(username, false);
        if (account != null) {
            if (account.getPassword().equals(password)) {
                System.out.println("Successful log in. Welcome " + username + "!\n");
                return account;
            } else {
                System.out.println("wrong password!\n");
            }
        } else {
            System.out.println("username not found\n");
        }
        return null;
    }

    public static Account findUser(String id, boolean searchById) {
        if (searchById) {
            for (Account account : accounts) {
                if (account.getUserId().equals(id)) {
                    return account;
                }
            }
        } else {
            for (Account account : accounts) {
                if (account.getUsername().equals(id)) {
                    return account;
                }
            }
        }
        return null;
    }
}