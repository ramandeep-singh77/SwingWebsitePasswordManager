import java.util.Base64;

public class Encryptor {
    public static String encrypt(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String decrypt(String encrypted) {
        return new String(Base64.getDecoder().decode(encrypted));
    }
}