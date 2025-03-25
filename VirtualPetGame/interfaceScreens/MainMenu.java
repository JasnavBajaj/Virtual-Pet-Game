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
        JPanel panel = new JPanel(new BorderLayout());

        // Header panel with title and game info
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        
        JLabel titleLabel = new JLabel("Virtual Pet Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel infoLabel = new JLabel("Developed by: [Team Names] | Team 1 | Winter Session 2025 | CS2212 at Western University");
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(Box.createVerticalStrut(20));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(10));
        headerPanel.add(infoLabel);
        headerPanel.add(Box.createVerticalStrut(20));
        
        panel.add(headerPanel, BorderLayout.NORTH);

        // Center panel with menu buttons
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        JButton newGameButton = new JButton("Start New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton tutorialButton = new JButton("Tutorial / Instructions");
        JButton parentalControlButton = new JButton("Parental Controls");
        JButton exitButton = new JButton("Exit");

        // Attach action listeners to buttons with expanded functionality
        newGameButton.addActionListener(e -> {
            // Transition to the new game / pet selection screen
            PetSelectionScreen petSelectionScreen = new PetSelectionScreen();
            petSelectionScreen.setVisible(true);
            // Close the main menu after launching the pet selection screen
            MainMenu.this.dispose();
        });

        loadGameButton.addActionListener(e -> {
            // Transition to the load game screen
            LoadGameScreen loadGameScreen = new LoadGameScreen();
            loadGameScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        tutorialButton.addActionListener(e -> {
            // Transition to the tutorial screen
            TutorialScreen tutorialScreen = new TutorialScreen();
            tutorialScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        parentalControlButton.addActionListener(e -> {
            // Transition to the parental control screen
            ParentalControlScreen parentalScreen = new ParentalControlScreen();
            parentalScreen.setVisible(true);
            MainMenu.this.dispose();
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(newGameButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(tutorialButton);
        buttonPanel.add(parentalControlButton);
        buttonPanel.add(exitButton);

        // Wrap button panel in a center panel to help center it vertically/horizontally
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        panel.add(centerPanel, BorderLayout.CENTER);

        // Footer panel with a placeholder for a game image/graphic
        JPanel footerPanel = new JPanel();
        // In a complete application, replace the label with an image loaded from resources.
        JLabel imageLabel = new JLabel("Game Image/Graphic Placeholder");
        footerPanel.add(imageLabel);
        
        panel.add(footerPanel, BorderLayout.SOUTH);

        add(panel);
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

