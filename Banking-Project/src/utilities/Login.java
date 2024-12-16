package utilities;

import entities.Account;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;

import static entities.Account.accounts;
import static utilities.Utils.*;

public class Login {
    private static int loginAttemptsRemaining = 3;
    private static boolean isLoginAvailable = true;
    private static LocalDateTime remainingTime;

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