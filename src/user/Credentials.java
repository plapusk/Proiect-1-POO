package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
        if (credentials.getAccountType().equals("standard")) {
            this.premium = false;
        }
        else {
            this.premium = true;
        }
        this.country = credentials.getCountry();
        this.balance =  Integer.valueOf(credentials.getBalance());
    }

    public ObjectNode getJSON(ObjectMapper mapper) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("name", name);
        obj.put("password", password);
        obj.put("accountType", getPremiumStr());
        obj.put("country", country);
        obj.put("balance", String.valueOf(balance));
        return obj;
    }

    private String getPremiumStr() {
        if (premium)
            return "premium";
        return "standard";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
