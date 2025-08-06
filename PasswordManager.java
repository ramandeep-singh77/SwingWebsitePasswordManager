import java.io.*;
import java.util.ArrayList;

public class PasswordManager {
    private static final String FILE_NAME = "credentials.txt";
    private ArrayList<Credential> credentials = new ArrayList<>();

    public PasswordManager() {
        loadCredentials();
    }

    private void loadCredentials() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    credentials.add(new Credential(parts[0], parts[1], Encryptor.decrypt(parts[2])));
                }
            }
        } catch (IOException ignored) {}
    }

    public void saveCredentials() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Credential c : credentials) {
                writer.println(c.getWebsite() + "," + c.getUsername() + "," + c.getEncryptedPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCredential(Credential c) {
        credentials.add(c);
        saveCredentials();
    }

    public ArrayList<Credential> getAllCredentials() {
        return credentials;
    }

    public Credential search(String website) {
        for (Credential c : credentials) {
            if (c.getWebsite().equalsIgnoreCase(website)) {
                return c;
            }
        }
        return null;
    }
}