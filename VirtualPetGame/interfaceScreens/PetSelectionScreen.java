package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * PetSelectionScreen.java
 *
 * This screen allows players to select a new pet from a set of options.
 */
public class PetSelectionScreen extends JFrame {

    private final ImageIcon achitachiIcon;
    private final ImageIcon ichigotchiIcon;
    private final ImageIcon unipegatchiIcon;

    public PetSelectionScreen() {
        setTitle("Select Your Pet");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load icons from resources (adjust paths as needed)
        achitachiIcon = new ImageIcon(getClass().getResource("/group29/VirtualPetGame/icons/achitachi.png"));
        ichigotchiIcon = new ImageIcon(getClass().getResource("/group29/VirtualPetGame/icons/ichigotchi.png"));
        unipegatchiIcon = new ImageIcon(getClass().getResource("/group29/VirtualPetGame/icons/unipegatchi.png"));

        initUI();
    }

    private void initUI() {
        // Main layout: 1 row, 1 column for "Choose your Pet" label at the top,
        // then a 2nd row for the 3 pet options, and a bottom row for the "Back" button
        setLayout(new BorderLayout());

        // Top label
        JLabel titleLabel = new JLabel("Choose your Pet", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Center panel with 3 columns for the pet options
        JPanel petOptionsPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        // Create each pet option (using a helper method)
        JPanel pet1Panel = createPetOptionPanel("Pet Option 1", achitachiIcon);
        JPanel pet2Panel = createPetOptionPanel("Pet Option 2", ichigotchiIcon);
        JPanel pet3Panel = createPetOptionPanel("Pet Option 3", unipegatchiIcon);

        petOptionsPanel.add(pet1Panel);
        petOptionsPanel.add(pet2Panel);
        petOptionsPanel.add(pet3Panel);

        add(petOptionsPanel, BorderLayout.CENTER);

        // Bottom panel with "Back to Main Menu" button (if desired)
        JPanel bottomPanel = new JPanel();
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> {
            // Go back to main menu logic here
            // e.g., dispose this screen and show the main menu
            System.out.println("Back to Main Menu clicked");
            
            dispose();
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        
        });
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Creates a small panel representing a single pet option:
     * - An icon
     * - A label for the pet option
     * - A button (or clickable label) to select the pet
     */
    private JPanel createPetOptionPanel(String label, ImageIcon icon) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));

        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        JLabel textLabel = new JLabel(label, SwingConstants.CENTER);

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePetSelection(label, icon);
            }
        });

        panel.add(iconLabel, BorderLayout.CENTER);
        panel.add(textLabel, BorderLayout.NORTH);
        panel.add(selectButton, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Called when the user selects one of the pet options.
     * Prompts for a pet name, then you can store that name for your game logic.
     */
    private void handlePetSelection(String petLabel, ImageIcon icon) {
        // Show a quick message with the pet selection
        JOptionPane.showMessageDialog(
            this,
            petLabel + " selected. Now, enter your pet's name.",
            "Pet Selection",
            JOptionPane.INFORMATION_MESSAGE
        );

        // Prompt for pet name
        String petName = JOptionPane.showInputDialog(this, "Enter your pet's name:");

        if (petName != null && !petName.trim().isEmpty()) {
            // Here you have the chosen pet type (petLabel or icon) and the petName.
            // You can create a Pet object or move to your GameScreen.
            // Example: new Pet(petName, "Achitachi", ...stats...);

            System.out.println("Pet name chosen: " + petName);

            // For example, you might pass these to a new GameScreen:
            // GameScreen game = new GameScreen();
            // game.setPetName(petName);
            // game.setVisible(true);
            // dispose(); // close the pet selection screen
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetSelectionScreen selectionScreen = new PetSelectionScreen();
            selectionScreen.setVisible(true);
        });
    }
}


//     public PetSelectionScreen() {       
    
//         setTitle("Select Your Pet");
//         setSize(800, 600);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         // Load icons from resources
//         achitachiIcon = new ImageIcon(getClass().getResource("/icons/achitachi.png"));
//         ichigotchiIcon = new ImageIcon(getClass().getResource("/icons/ichigotchi.png"));
//         unipegatchiIcon = new ImageIcon(getClass().getResource("/icons/unipegatchi.png"));

//         initUI();
//     }

//     private void initUI() {
//         JPanel mainPanel = new JPanel(new BorderLayout()) {
//             @Override
//             protected void paintComponent(Graphics g) {
//                 super.paintComponent(g);
//                 Graphics2D g2d = (Graphics2D) g;
//                 Color color1 = new Color(255, 200, 104); 
//                 Color color2 = new Color(255, 243, 224); 
//                 GradientPaint gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
//                 g2d.setPaint(gp);
//                 g2d.fillRect(0, 0, getWidth(), getHeight());
//             }
//         };
        
//         JLabel titleLabel = new JLabel("Choose your Pet", SwingConstants.CENTER);
//         titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
//         mainPanel.add(titleLabel, BorderLayout.NORTH);

//         // Panel to hold pet options (for simplicity, using buttons)
//         JPanel petPanel = new JPanel(new GridLayout(1, 3, 10, 10));
//         JButton pet1Button = new JButton("Pet Option 1");
//         JButton pet2Button = new JButton("Pet Option 2");
//         JButton pet3Button = new JButton("Pet Option 3");

//         // Attach action listeners for pet selection:
//         pet1Button.addActionListener(e -> {
//             selectPet("Pet Option 1");
//         });
       
//         pet2Button.addActionListener(e -> {
//             selectPet("Pet Option 2");
//         });

//         pet3Button.addActionListener(e -> {
//             selectPet("Pet Option 3");
//         });

//         petPanel.add(pet1Button);
//         petPanel.add(pet2Button);
//         petPanel.add(pet3Button);

//         mainPanel.add(petPanel, BorderLayout.CENTER);

//         // Back button to return to the Main Menu if needed.
//         JButton backButton = new JButton("Back to Main Menu");
//         backButton.addActionListener(e -> {
//             System.out.println("Returning to Main Menu");
        
//             // Close the current window
//             dispose();
        
//             // Launch the Main Menu screen
//             MainMenu mainMenu = new MainMenu();
//             mainMenu.setVisible(true);
//         });
//         mainPanel.add(backButton, BorderLayout.SOUTH);

//         add(mainPanel);
//     }

//     private void selectPet(String petName) {
//         // Placeholder for handling pet selection. In a full application,
//         // you might prompt the user to enter a name for the pet, save the selection,
//         // and transition to the main game screen.
//         JOptionPane.showMessageDialog(this, petName + " selected. Now, enter your pet's name.");
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             PetSelectionScreen petSelectionScreen = new PetSelectionScreen();
//             petSelectionScreen.setVisible(true);
//         });
//     }
// }