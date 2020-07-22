package study3;

import sun.security.krb5.internal.crypto.Aes128;

import java.io.Serializable;

public class MyData implements Serializable {

    private String username;
    private String passwordCypher;
    transient String passwordClear;

    public MyData(String name, String clear) {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordCypher() {
        return passwordCypher;
    }

    public void setPassword(String password) throws Exception {
        this.passwordClear = password;
        EncryptionDecryption des = new EncryptionDecryption("abc");
        passwordCypher = des.encrypt(password);
    }

    @Override
    public String toString() {
        return "MyData[ " + username + ",......]";
    }
}
