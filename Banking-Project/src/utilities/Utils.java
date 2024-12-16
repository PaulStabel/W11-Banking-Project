package utilities;

import entities.Account;
import java.util.Scanner;
import static utilities.Login.*;
import static utilities.Signup.signUp;


public class Utils {
    public static final Scanner scanner = new Scanner(System.in);
    public static Account currentUser;

    public static void displayLoginMenu() {
        System.out.println("""
                Main Menu
                Please select an option:
                1. Signup
                2. Login
                3. Exit""");
        processLoginMenu();
    }

    public static void displayUserMenu() {
        System.out.println("""
                User Menu
                Please select an option:
                1. Show balance
                2. Deposit
                3. Withdraw
                4. Reset password
                5. Logout""");
        processUserMenu(scanner.nextLine());
    }

    private static void processLoginMenu() {
        String option;
        option = scanner.nextLine();
        if (option.length() == 1 && option.chars().allMatch(Character::isDigit)) {
            int optionValue = Integer.parseInt(option);
            switch (optionValue) {
                case 1:
                    signUp();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("No such option exists!\n");
                    displayLoginMenu();
            }
        } else {
            System.out.println("No such option exists!\n");
            displayLoginMenu();
        }
    }

    private static void processUserMenu(String option) {
        if (option.length() == 1 && option.chars().allMatch(Character::isDigit)) {
            int optionValue = Integer.parseInt(option);
            switch (optionValue) {
                case 1:
                    System.out.printf("Account balance: %.0f\n\n", currentUser.getBalance());
                    displayUserMenu();
                    break;
                case 2:
                    System.out.print("How much money do you want to deposit? (max. " + currentUser.getDepositLimit() + "): ");
                    if (currentUser.deposit(scanner.nextLine(), currentUser.getDepositLimit())) {
                        System.out.println("Success!\n");
                    }
                    displayUserMenu();
                    break;
                case 3:
                    System.out.print("How much money do you want to withdraw? (max. " + currentUser.getWithdrawLimit() + "): ");
                    if (currentUser.withdraw(scanner.nextLine(), currentUser.getWithdrawLimit())) {
                        System.out.println("Success!\n");
                    }
                    displayUserMenu();
                    break;
                case 4:
                    System.out.print("Please enter your current password: ");
                    String currentPassword = scanner.nextLine();
                    System.out.print("Please enter the new password: ");
                    String newPassword = scanner.nextLine();
                    currentUser.resetPassword(currentPassword, newPassword);
                    displayUserMenu();
                    break;
                case 5:
                    currentUser = null;
                    displayLoginMenu();
                    break;
                default:
                    System.out.println("No such option exists!");
                    displayUserMenu();
            }
        } else {
            System.out.println("No such option exists!\n");
            displayUserMenu();
        }
    }

    public static boolean parseDepositValues(String amount) {
        if (amount != null && !amount.isBlank()) {
            return amount.matches("(\\d+.)?\\d+");
        } else {
            return false;
        }
    }
}
