package input;

import user.Credentials;

public class UsersInput {
    private CredentialsInput credentials;

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsInput credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "UsersInput{" +
                "credentials=" + credentials +
                '}';
    }
}
