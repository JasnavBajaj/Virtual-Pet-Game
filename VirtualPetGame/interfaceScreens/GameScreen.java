package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;

/**
 * GameScreen.java
 *
 * This class creates the main gameplay screen for the Virtual Pet Game.
 * It displays the pet's vital statistics, pet sprite, inventory, and available commands.
 *
 * Layout details:
 * - North: Vital statistics (Health, Sleep, Fullness, Happiness) using progress bars.
 * - Center: Pet sprite display (placeholder text or image).
 * - East: Inventory display (shows food and gift items).
 * - South: Command buttons (Feed, Give Gift, Play, Exercise, Go to Bed, Take to Vet).
 *
 * Customize the action listeners to integrate with your game logic.
 *
 * @author
 * @version 1.0
 */
public class GameScreen extends JFrame {

    // Vital statistics components
    private JProgressBar healthBar;
    private JProgressBar sleepBar;
    private JProgressBar fullnessBar;
    private JProgressBar happinessBar;

    // Inventory display component
    private JTextArea inventoryArea;

    // Pet sprite component (placeholder)
    private JLabel petSpriteLabel;

    public GameScreen() {
        setTitle("Virtual Pet - Game Screen");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    /**
     * Initializes the UI components and layout.
     */
    private void initUI() {
        // Main layout for the frame
        setLayout(new BorderLayout(10, 10));

        // North panel: Vital statistics
        JPanel vitalStatsPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        healthBar = createStatBar("Health", 100);
        sleepBar = createStatBar("Sleep", 100);
        fullnessBar = createStatBar("Fullness", 100);
        happinessBar = createStatBar("Happiness", 100);
        vitalStatsPanel.add(healthBar);
        vitalStatsPanel.add(sleepBar);
        vitalStatsPanel.add(fullnessBar);
        vitalStatsPanel.add(happinessBar);
        add(vitalStatsPanel, BorderLayout.NORTH);

        // Center panel: Pet sprite display
        JPanel centerPanel = new JPanel(new BorderLayout());
        petSpriteLabel = new JLabel("Pet Sprite Placeholder", SwingConstants.CENTER);
        petSpriteLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        // To load an image, you can use:
        // petSpriteLabel.setIcon(new ImageIcon(getClass().getResource("/sprites/pet1.png")));
        centerPanel.add(petSpriteLabel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // East panel: Inventory display
        JPanel inventoryPanel = new JPanel(new BorderLayout());
        JLabel inventoryLabel = new JLabel("Inventory", SwingConstants.CENTER);
        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 18));
        inventoryArea = new JTextArea(10, 15);
        inventoryArea.setEditable(false);
        // Sample inventory text; update this dynamically as needed.
        inventoryArea.setText("Food Items:\n- Apple x3\n- Bread x2\n\nGift Items:\n- Toy x1\n- Ball x2");
        JScrollPane inventoryScrollPane = new JScrollPane(inventoryArea);
        inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
        inventoryPanel.add(inventoryScrollPane, BorderLayout.CENTER);
        add(inventoryPanel, BorderLayout.EAST);

        // South panel: Command buttons
        JPanel commandPanel = new JPanel(new GridLayout(1, 6, 10, 10));
        JButton feedButton = new JButton("Feed");
        JButton giftButton = new JButton("Give Gift");
        JButton playButton = new JButton("Play");
        JButton exerciseButton = new JButton("Exercise");
        JButton goToBedButton = new JButton("Go to Bed");
        JButton vetButton = new JButton("Take to Vet");

        // Attach action listeners (expand these actions to integrate with your game logic)
        feedButton.addActionListener(e -> System.out.println("Feed command issued"));
        giftButton.addActionListener(e -> System.out.println("Give Gift command issued"));
        playButton.addActionListener(e -> System.out.println("Play command issued"));
        exerciseButton.addActionListener(e -> System.out.println("Exercise command issued"));
        goToBedButton.addActionListener(e -> System.out.println("Go to Bed command issued"));
        vetButton.addActionListener(e -> System.out.println("Take to Vet command issued"));

        commandPanel.add(feedButton);
        commandPanel.add(giftButton);
        commandPanel.add(playButton);
        commandPanel.add(exerciseButton);
        commandPanel.add(goToBedButton);
        commandPanel.add(vetButton);
        add(commandPanel, BorderLayout.SOUTH);
    }

    /**
     * Helper method to create a progress bar for a vital statistic.
     *
     * @param label The label for the statistic.
     * @param max   The maximum value for the statistic.
     * @return A JProgressBar configured with the given label and maximum value.
     */
    private JProgressBar createStatBar(String label, int max) {
        JProgressBar bar = new JProgressBar(0, max);
        bar.setStringPainted(true);
        bar.setValue(max); // Start at maximum value
        bar.setBorder(BorderFactory.createTitledBorder(label));
        return bar;
    }

    /**
     * Main method to launch the Game Screen.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameScreen gameScreen = new GameScreen();
            gameScreen.setVisible(true);
        });
    }
}

