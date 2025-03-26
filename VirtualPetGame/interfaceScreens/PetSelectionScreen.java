package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;

/**
 * PetSelectionScreen.java
 *
 * This screen allows players to select a new pet from a set of options.
 */
public class PetSelectionScreen extends JFrame {

    public PetSelectionScreen() {       
    
        setTitle("Select Your Pet");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel mainPanel = new JPanel(new BorderLayout()) {
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
        
        JLabel titleLabel = new JLabel("Choose your Pet", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel to hold pet options (for simplicity, using buttons)
        JPanel petPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton pet1Button = new JButton("Pet Option 1");
        JButton pet2Button = new JButton("Pet Option 2");
        JButton pet3Button = new JButton("Pet Option 3");

        // Attach action listeners for pet selection:
        pet1Button.addActionListener(e -> {
            selectPet("Pet Option 1");
        });
       
        pet2Button.addActionListener(e -> {
            selectPet("Pet Option 2");
        });

        pet3Button.addActionListener(e -> {
            selectPet("Pet Option 3");
        });

        petPanel.add(pet1Button);
        petPanel.add(pet2Button);
        petPanel.add(pet3Button);

        mainPanel.add(petPanel, BorderLayout.CENTER);

        // Back button to return to the Main Menu if needed.
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(e -> {
            System.out.println("Returning to Main Menu");
        
            // Close the current window
            dispose();
        
            // Launch the Main Menu screen
            MainMenu mainMenu = new MainMenu();
            mainMenu.setVisible(true);
        });
        mainPanel.add(backButton, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void selectPet(String petName) {
        // Placeholder for handling pet selection. In a full application,
        // you might prompt the user to enter a name for the pet, save the selection,
        // and transition to the main game screen.
        JOptionPane.showMessageDialog(this, petName + " selected. Now, enter your pet's name.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetSelectionScreen petSelectionScreen = new PetSelectionScreen();
            petSelectionScreen.setVisible(true);
        });
    }
}