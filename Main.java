import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap; // Import HashMap for storing user credentials

public class Main {
    // HashMap to store user credentials (username and password)
    private static HashMap<String, String> userCredentials = new HashMap<>();

    public static void main(String[] args) {
        // Create the main frame for Login/Signup page
        JFrame frame = new JFrame("Expense Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create panel for main options (Login/Signup)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        // Create Login and Signup buttons
        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");

        // Set bounds for buttons (position and size)
        loginButton.setBounds(100, 80, 200, 40);
        signupButton.setBounds(100, 140, 200, 40);

        // Add buttons to the main panel
        mainPanel.add(loginButton);
        mainPanel.add(signupButton);

        // Add main panel to the frame
        frame.add(mainPanel);
        frame.setVisible(true);

        // Action Listener for Login Button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Close the main window
                showLoginForm();  // Call method to display Login form
            }
        });

        // Action Listener for Signup Button
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Close the main window
                showSignupForm(); // Call method to display Signup form
            }
        });
    }

    // Method to display Login Form
    public static void showLoginForm() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 300);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        // Login form components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        JButton backBtn = new JButton("Back"); // Back button

        // Set bounds for components
        usernameLabel.setBounds(50, 50, 100, 30);
        usernameField.setBounds(150, 50, 200, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 200, 30);
        loginBtn.setBounds(150, 150, 100, 30);
        backBtn.setBounds(150, 200, 100, 30); // Position for Back button

        // Add components to login panel
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginBtn);
        loginPanel.add(backBtn); // Add back button to panel

        // Add login panel to frame
        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);

        // Action Listener for Login button in Login form
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check credentials against the HashMap
                if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(loginFrame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid Credentials, Try Again.");
                }
            }
        });

        // Action Listener for Back button in Login form
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginFrame.dispose(); // Close the login frame
                Main.main(new String[]{}); // Call main to show the original page
            }
        });
    }

    // Method to display Signup Form
    public static void showSignupForm() {
        JFrame signupFrame = new JFrame("Signup");
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signupFrame.setSize(400, 300);

        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(null);

        // Signup form components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton signupBtn = new JButton("Signup");
        JButton backBtn = new JButton("Back"); // Back button

        // Set bounds for components
        usernameLabel.setBounds(50, 50, 100, 30);
        usernameField.setBounds(150, 50, 200, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 200, 30);
        signupBtn.setBounds(150, 150, 100, 30);
        backBtn.setBounds(150, 200, 100, 30); // Position for Back button

        // Add components to signup panel
        signupPanel.add(usernameLabel);
        signupPanel.add(usernameField);
        signupPanel.add(passwordLabel);
        signupPanel.add(passwordField);
        signupPanel.add(signupBtn);
        signupPanel.add(backBtn); // Add back button to panel

        // Add signup panel to frame
        signupFrame.add(signupPanel);
        signupFrame.setVisible(true);

        // Action Listener for Signup button in Signup form
        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if username is already taken
                if (userCredentials.containsKey(username)) {
                    JOptionPane.showMessageDialog(signupFrame, "Username already taken, choose another one.");
                } else {
                    // Store new user credentials
                    userCredentials.put(username, password);
                    JOptionPane.showMessageDialog(signupFrame, "Signup Successful! You can now login.");
                }
            }
        });

        // Action Listener for Back button in Signup form
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signupFrame.dispose(); // Close the signup frame
                Main.main(new String[]{}); // Call main to show the original page
            }
        });
    }
}

