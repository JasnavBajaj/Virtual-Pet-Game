package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;

/**
 * TutorialScreen.java
 *
 * This class creates the tutorial/instructions screen for the Virtual Pet Game.
 * It displays detailed instructions on how to play the game, including explanations of
 * game features and controls. The screen is designed for players who have little or no
 * previous experience with the game.
 *
 * The screen provides a scrollable text area with instructions and a button to return to the main menu.
 *
 * Customize the instructions text as needed.
 *
 * @author 
 * @version 1.0
 */
public class TutorialScreen extends JFrame {

    public TutorialScreen() {
        setTitle("Tutorial / Instructions");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }
    
    /**
     * Initializes the user interface components for the tutorial screen.
     */
    private void initUI() {
        // Use BorderLayout for the main layout.
        setLayout(new BorderLayout(10, 10));
        
        // Title label at the top.
        JLabel titleLabel = new JLabel("Tutorial / Instructions", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel, BorderLayout.NORTH);
        
        // Main text area for instructions.
        JTextArea instructionsArea = new JTextArea();
        instructionsArea.setEditable(false);
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        
        // Sample tutorial instructions.
        String instructions = "Welcome to the Virtual Pet Game!\n\n" +
                              "How to Play:\n" +
                              "1. Start a new game or load an existing game from the main menu.\n" +
                              "2. Choose a pet from a variety of options and give it a unique name.\n" +
                              "3. Monitor your pet's vital statistics: Health, Sleep, Fullness, and Happiness.\n" +
                              "   - Health: Represents your pet's well-being. If it reaches zero, the pet dies.\n" +
                              "   - Sleep: When too low, your pet will fall asleep and lose health.\n" +
                              "   - Fullness: When too low, your pet becomes hungry, reducing its happiness and health.\n" +
                              "   - Happiness: If it reaches zero, your pet becomes angry and unresponsive.\n\n" +
                              "Commands:\n" +
                              "- Feed: Increases your pet's fullness.\n" +
                              "- Give Gift: Boosts your pet's happiness.\n" +
                              "- Play: Enhances your pet's mood.\n" +
                              "- Exercise: Improves your pet's health but may lower its fullness and sleep.\n" +
                              "- Go to Bed: Helps your pet sleep and restore its sleep value.\n" +
                              "- Take to Vet: Heals your pet, increasing its health.\n\n" +
                              "Navigation:\n" +
                              "- Use the mouse to click on buttons to issue commands.\n" +
                              "- Keyboard shortcuts are available for quick access to actions.\n\n" +
                              "Additional Information:\n" +
                              "- Save your game progress regularly.\n" +
                              "- Access parental controls for extra settings and statistics.\n" +
                              "- Have fun and take good care of your pet!\n";
        instructionsArea.setText(instructions);
        
        // Place the text area inside a scroll pane.
        JScrollPane scrollPane = new JScrollPane(instructionsArea);
        add(scrollPane, BorderLayout.CENTER);
        
        // Bottom panel with a "Back to Main Menu" button.
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> {
            // Replace this action with actual navigation logic.
            System.out.println("Returning to Main Menu");
            dispose();
            // Optionally, you could launch the MainMenu screen:
            // new MainMenu().setVisible(true);
        });
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Main method to launch the Tutorial Screen independently.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TutorialScreen tutorialScreen = new TutorialScreen();
            tutorialScreen.setVisible(true);
        });
    }
}

