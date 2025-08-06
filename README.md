# 🔐 Password Manager (Java Swing)

A simple password manager application built using **Java Swing**. It allows users to securely store, search, and manage credentials (Website, Username, Password) with **Base64 encryption**.

## 🚀 Features

- 🔐 Add credentials (Website, Username, Password)
- 🔍 Search credentials by website
- 📁 Credentials stored locally in an encrypted format (Base64)
- 🖥️ Simple and intuitive **Swing GUI**
- 💾 File-based storage in `credentials.txt`

## 🧠 Technologies Used

- Java 17+
- Swing (GUI)
- Base64 Encryption (`java.util.Base64`)
- File I/O

## 📷 Screenshots
<img width="1918" height="1138" alt="image" src="https://github.com/user-attachments/assets/059a4f5f-dd4c-4b7a-8695-da17b493b8aa" />
> GUI loads in a simple window with input fields and a search bar.

## 🛠️ How to Run

### Option 1: Using IDE

- Open the `src` folder in **IntelliJ**, **Eclipse**, or **VS Code**
- Run `Main.java` as a Java Application

## 📄 File Structure

```
PasswordManagerSwing/
└── src/
    ├── Credential.java
    ├── Encryptor.java
    ├── PasswordManager.java
    └── Main.java
```

## ⚠️ Note

- Your credentials are saved in plain text file `credentials.txt` (with Base64 encoding)
- DO NOT upload `credentials.txt` to public GitHub repos

## 🧾 License

This project is open-source and free to use.
