package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;

/**
 * MainMenu.java
 * 
 * This class creates the main menu screen for the Virtual Pet Game.
 * It displays the game title, developer/team information, and options
 * for starting a new game, loading a saved game, viewing tutorials,
 * accessing parental controls, and exiting the application.
 *
 * @author 
 * @version 1.0
 */
public class MainMenu extends JFrame {

    public MainMenu() {
        // Set up the frame properties
        setTitle("Virtual Pet Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    /**
     * Initializes the user interface components.
     */
    private void initUI() {
        // Main panel uses BorderLayout to organize header, center, and footer.
        JPanel panel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(255, 200, 104); 
                Color color2 = new Color(255, 243, 224); 
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // Header panel with title and game info
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setOpaque(false); // Make header panel transparent

        JLabel titleLabel = new JLabel("Virtual Pet Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 80));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setOpaque(false);


        headerPanel.add(Box.createVerticalStrut(20));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(10));

        panel.add(headerPanel, BorderLayout.NORTH);

        // Center panel with menu buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setOpaque(false); // Make button panel transparent

        JButton newGameButton = createStyledButton("Start New Game");
        JButton loadGameButton = createStyledButton("Load Game");
        JButton tutorialButton = createStyledButton("Tutorial");
        JButton parentalControlButton = createStyledButton("Parental Controls");
        JButton exitButton = createStyledButton("Exit");

        // Attach action listeners to buttons with expanded functionality
        newGameButton.addActionListener(e -> {
            System.out.println("Pet selction screen clicked");
            PetSelectionScreen petSelectionScreen = new PetSelectionScreen();
            petSelectionScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        loadGameButton.addActionListener(e -> {
            System.out.println("Load new game screen clicked");
            LoadGameScreen loadGameScreen = new LoadGameScreen();
            loadGameScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        tutorialButton.addActionListener(e -> {
            System.out.println("Tutorial screen clicked");
            TutorialScreen tutorialScreen = new TutorialScreen();
            tutorialScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        parentalControlButton.addActionListener(e -> {
            System.out.println("Parental controls screen clicked");
            ParentalControlScreen parentalScreen = new ParentalControlScreen();
            parentalScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        exitButton.addActionListener(e -> {
            System.out.println("User now clicked exit button");
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
}
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(tutorialButton);
        buttonPanel.add(parentalControlButton);
        buttonPanel.add(exitButton);

        // Wrap button panel in a center panel to help center it vertically/horizontally
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(buttonPanel);

        panel.add(centerPanel, BorderLayout.CENTER);

        // Footer panel with team information
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BoxLayout(footerPanel, BoxLayout.Y_AXIS));
        footerPanel.setOpaque(false); // Make footer panel transparent

        JLabel teamLabel = new JLabel("Created by Team 29");
        teamLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel membersLabel = new JLabel("Tyler, Jasnav, Mann, Sudhansh, Sachi");
        membersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel courseLabel = new JLabel("For CS 2212 Winter 2025");
        courseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel universityLabel = new JLabel("Western University");
        universityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        footerPanel.add(Box.createVerticalStrut(20));
        footerPanel.add(teamLabel);
        footerPanel.add(membersLabel);
        footerPanel.add(courseLabel);
        footerPanel.add(universityLabel);
        footerPanel.add(Box.createVerticalStrut(20));

        panel.add(footerPanel, BorderLayout.SOUTH);

        add(panel);
    }

        /**
     * Helper method to create a styled button with a specific background color and font.
     *
     * @param text The text to display on the button.
     * @return A styled JButton.
     */
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(255, 91, 100)); // #FF5B64
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(250, 50));
        return button;
    }
    
    /**
     * Main method to launch the Main Menu.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
    }
}

