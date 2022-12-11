package user;

import input.CredentialsInput;

public class Credentials {
    private String name;
    private String password;
    private boolean premium;
    private Visitor visitor;
    private String country;
    private int balance;

    public Credentials(CredentialsInput credentials) {
        this.name = credentials.getName();
        this.password = credentials.getPassword();
        if (credentials.getAccountType().equals("standard")) {
            this.premium = false;
            visitor = new StandardUser();
        }
        else {
            this.premium = true;
            visitor = new PremiumUser();
        }
        this.country = credentials.getCountry();
        this.balance =  Integer.valueOf(credentials.getBalance());
    }
}
