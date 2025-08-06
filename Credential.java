public class Credential {
    private String website;
    private String username;
    private String password; // encrypted

    public Credential(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = Encryptor.encrypt(password);
    }

    public String getWebsite() { return website; }
    public String getUsername() { return username; }
    public String getDecryptedPassword() { return Encryptor.decrypt(password); }
    public String getEncryptedPassword() { return password; }
}