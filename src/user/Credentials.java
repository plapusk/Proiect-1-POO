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

    public Credentials(final CredentialsInput credentials) {
        this.name = credentials.getName();
        this.password = credentials.getPassword();
        if (credentials.getAccountType().equals("standard")) {
            this.premium = false;
        } else {
            this.premium = true;
        }
        this.country = credentials.getCountry();
        this.balance =  Integer.valueOf(credentials.getBalance());
    }

    /**
     * Get ObjectNode for the credentials class
     * @param mapper
     * @return
     */
    public ObjectNode getJSON(final ObjectMapper mapper) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("name", name);
        obj.put("password", password);
        obj.put("accountType", getPremiumStr());
        obj.put("country", country);
        obj.put("balance", String.valueOf(balance));
        return obj;
    }

    private String getPremiumStr() {
        if (premium) {
            return "premium";
        }
        return "standard";
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final boolean isPremium() {
        return premium;
    }

    public final void setPremium(final boolean premium) {
        this.premium = premium;
    }

    public final String getCountry() {
        return country;
    }

    public final void setCountry(final String country) {
        this.country = country;
    }

    public final int getBalance() {
        return balance;
    }

    public final void setBalance(final int balance) {
        this.balance = balance;
    }
}
