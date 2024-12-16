import entities.Account;

import static entities.Account.accounts;
import static utilities.Utils.*;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("jack", "password", "0510", "jack", "kyomu", "10000", "10000", "1000");
        Account account2 = new Account("paul", "123456", "1234", "paul", "stabel", "1500", "1000", "300");
        currentUser = account;
        accounts.add(account);
        accounts.add(account2);
        displayLoginMenu();
        scanner.close();
    }

}
