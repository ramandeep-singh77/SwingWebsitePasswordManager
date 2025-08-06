import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static PasswordManager manager = new PasswordManager();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Manager");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 1));

        JTextField websiteField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField searchField = new JTextField();
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        JButton addButton = new JButton("Add Credential");
        JButton searchButton = new JButton("Search");

        frame.add(new JLabel("Website:"));
        frame.add(websiteField);
        frame.add(new JLabel("Username:"));
        frame.add(usernameField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(addButton);
        frame.add(new JLabel("Search by Website:"));
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(new JScrollPane(resultArea));

        addButton.addActionListener(e -> {
            String site = websiteField.getText();
            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (!site.isEmpty() && !user.isEmpty() && !pass.isEmpty()) {
                manager.addCredential(new Credential(site, user, pass));
                resultArea.setText("Credential added!");
                websiteField.setText("");
                usernameField.setText("");
                passwordField.setText("");
            } else {
                resultArea.setText("Please fill all fields.");
            }
        });

        searchButton.addActionListener(e -> {
            String site = searchField.getText();
            Credential c = manager.search(site);
            if (c != null) {
                resultArea.setText("Website: " + c.getWebsite() + "\nUsername: " + c.getUsername()
                        + "\nPassword: " + c.getDecryptedPassword());
            } else {
                resultArea.setText("No credential found.");
            }
        });

        frame.setVisible(true);
    }
}