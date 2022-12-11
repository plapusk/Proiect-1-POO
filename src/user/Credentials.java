package user;

import input.CredentialsInput;

public class Credentials {
    private String name;
    private String password;
    private boolean premium;
    private String country;
    private int balance;

    public Credentials(CredentialsInput credentials) {
        this.name = credentials.getName();
        this.password = credentials.getPassword();
        if (credentials.getAccountType().equals("standard"))
            this.premium = false;
        else
            this.premium = true;
        this.country = credentials.getCountry();
        this.balance =  Integer.valueOf(credentials.getBalance());
    }
}
