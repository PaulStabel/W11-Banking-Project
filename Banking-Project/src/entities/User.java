package entities;

public abstract class User {
    private static int NEXT_ID = 1;

    private final String userId;
    private final String username;
    private String password;
    private final String pinCode;

    public User(String username, String password, String pinCode) {
        this.userId = String.valueOf(NEXT_ID++);
        this.username = username;
        this.password = password;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void resetPassword(String currentPassword, String newPassword) {
        if (this.password.equals(currentPassword)) {
            if (newPassword != null && !newPassword.isBlank() && newPassword.length() >= 6) {
                this.password = newPassword;
                System.out.println("Password successfully updated! New password is " + this.password + "\n");
            } else {
                System.out.println("The new password wasn't secure enough! Please enter a different password (min. 6 characters)\n");
            }
        } else {
            System.out.println("Failed! Incorrect current password!\n");
        }
    }
}
