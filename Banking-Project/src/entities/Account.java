package entities;

import java.util.ArrayList;

import static utilities.Login.findUser;
import static utilities.Utils.*;

public class Account extends User {
    public static final ArrayList<Account> accounts = new ArrayList<>();

    private final String firstName;
    private final String lastName;

    private double balance;
    private final double depositLimit;
    private final double withdrawLimit;

    public Account(String username, String password, String pinCode, String firstName, String lastName, String balance, String depositLimit, String withdrawLimit) {
        super(username, password, pinCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = Double.parseDouble(balance);
        this.depositLimit = Double.parseDouble(depositLimit);
        this.withdrawLimit = Double.parseDouble(withdrawLimit);
    }

    public boolean deposit(String amount, double depositLimit) {
        if (parseDepositValues(amount)) {
            double value = Double.parseDouble(amount);
            if (value <= depositLimit) {
                this.balance += value;
                return true;
            } else {
                System.out.println("The amount is over the limit! Process cancelled.\n");
                return false;
            }
        } else {
            System.out.println("Invalid amount entered!\n");
            return false;
        }
    }

    public boolean withdraw(String amount, double withdrawLimit) {
        if (parseDepositValues(amount)) {
            double value = Double.parseDouble(amount);
            if (value <= this.balance && value <= withdrawLimit) {
                this.balance -= value;
                return true;
            } else {
                System.out.println("The amount is over the limit! Process cancelled.\n");
                return false;
            }
        } else {
            System.out.println("Invalid amount entered!\n");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", depositLimit=" + depositLimit +
                ", withdrawLimit=" + withdrawLimit +
                "} " + super.toString();
    }

    public double getBalance() {
        return balance;
    }

    public double getDepositLimit() {
        return depositLimit;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }
}
