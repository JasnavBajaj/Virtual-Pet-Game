package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;

/**
 * ParentalControlScreen.java
 *
 * This class creates a password-protected parental control screen for the Virtual Pet Game.
 * The screen initially prompts for a password. Upon successful login, it displays a tabbed pane
 * with three sections:
 * 1. Limitations - Set allowed play times and enable/disable time restrictions.
 * 2. Statistics - Displays total play time and average session time, with an option to reset.
 * 3. Revive Pet - Allows a parent to select a save slot and revive the pet.
 *
 * Customize the logic for saving settings, resetting statistics, and reviving pets as required.
 *
 * @author 
 * @version 1.0
 */
public class ParentalControlScreen extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    // Hardcoded parental password. In production, this should be stored more securely.
    private static final String PARENTAL_PASSWORD = "parent123";

    public ParentalControlScreen() {
        setTitle("Parental Controls");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    /**
     * Initializes the UI with a login panel and the main parental controls panel.
     */
    private void initUI() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create the login panel
        JPanel loginPanel = createLoginPanel();
        // Create the parental control panel with tabs
        JPanel parentalPanel = createParentalPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(parentalPanel, "Parental");

        add(mainPanel);
        cardLayout.show(mainPanel, "Login");
    }

    /**
     * Creates the login panel for entering the parental password.
     * 
     * @return JPanel containing login controls.
     */
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("Enter Parental Password", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new FlowLayout());
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(15);
        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String inputPassword = new String(passwordField.getPassword());
            if (PARENTAL_PASSWORD.equals(inputPassword)) {
                // Successful login: switch to parental controls
                cardLayout.show(mainPanel, "Parental");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        bottomPanel.add(loginButton);

        // "Back" button to exit the screen (or return to the main menu)
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
        });
        bottomPanel.add(backButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Creates the main parental control panel with a tabbed interface.
     * 
     * @return JPanel containing the parental control tabs.
     */
    private JPanel createParentalPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        // Tab 1: Parental Limitations
        JPanel limitationsPanel = createLimitationsPanel();
        tabbedPane.addTab("Limitations", limitationsPanel);

        // Tab 2: Parental Statistics
        JPanel statisticsPanel = createStatisticsPanel();
        tabbedPane.addTab("Statistics", statisticsPanel);

        // Tab 3: Revive Pet
        JPanel revivePanel = createRevivePanel();
        tabbedPane.addTab("Revive Pet", revivePanel);

        panel.add(tabbedPane, BorderLayout.CENTER);

        // Bottom panel with a logout button to return to the login screen
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "Login");
        });
        bottomPanel.add(logoutButton);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Creates the Parental Limitations panel.
     * 
     * @return JPanel for setting allowed play times and time restrictions.
     */
    private JPanel createLimitationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel for allowed play time input
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel allowedTimeLabel = new JLabel("Allowed Play Time (e.g., 17:00-19:00): ");
        JTextField timeField = new JTextField(15);
        timePanel.add(allowedTimeLabel);
        timePanel.add(timeField);

        // Checkbox for enabling/disabling time restrictions
        JPanel enablePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox enableCheckBox = new JCheckBox("Enable Time Restrictions");
        enablePanel.add(enableCheckBox);

        panel.add(timePanel);
        panel.add(enablePanel);

        // Save button to persist settings
        JButton saveButton = new JButton("Save Limitations");
        saveButton.addActionListener(e -> {
            String allowedTime = timeField.getText();
            boolean enabled = enableCheckBox.isSelected();
            // In a real application, store these settings persistently
            JOptionPane.showMessageDialog(this, "Limitations saved:\nTime: " + allowedTime + "\nEnabled: " + enabled);
        });
        panel.add(saveButton);

        return panel;
    }

    /**
     * Creates the Parental Statistics panel.
     * 
     * @return JPanel displaying play time statistics with an option to reset.
     */
    private JPanel createStatisticsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Sample statistics (replace with actual values as needed)
        JLabel totalPlayTimeLabel = new JLabel("Total Play Time: 5 hours 30 minutes");
        JLabel averageSessionLabel = new JLabel("Average Session Time: 30 minutes");

        panel.add(totalPlayTimeLabel);
        panel.add(averageSessionLabel);

        // Button to reset statistics
        JButton resetButton = new JButton("Reset Statistics");
        resetButton.addActionListener(e -> {
            // Implement logic to reset statistics and persist changes
            JOptionPane.showMessageDialog(this, "Statistics have been reset.");
        });
        panel.add(resetButton);

        return panel;
    }

    /**
     * Creates the Revive Pet panel.
     * 
     * @return JPanel allowing the parent to select a save slot and revive the pet.
     */
    private JPanel createRevivePanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JLabel selectLabel = new JLabel("Select Save Slot: ");
        // Sample save slots; replace with actual save data as needed
        String[] saveSlots = {"Save Slot 1 - Pet: Fluffy", "Save Slot 2 - Pet: Sparky", "Save Slot 3 - Pet: Buddy"};
        JComboBox<String> saveComboBox = new JComboBox<>(saveSlots);
        panel.add(selectLabel);
        panel.add(saveComboBox);

        JButton reviveButton = new JButton("Revive Pet");
        reviveButton.addActionListener(e -> {
            String selectedSave = (String) saveComboBox.getSelectedItem();
            // Implement the revive logic for the selected save slot here
            JOptionPane.showMessageDialog(this, "Reviving pet for: " + selectedSave);
        });
        panel.add(reviveButton);

        return panel;
    }

    /**
     * Main method to launch the Parental Control Screen independently.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParentalControlScreen pcs = new ParentalControlScreen();
            pcs.setVisible(true);
        });
    }
}

