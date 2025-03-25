package group29.VirtualPetGame.interfaceScreens;

import javax.swing.*;
import java.awt.*;

/**
 * LoadGameScreen.java
 *
 * This class creates the load game screen for the Virtual Pet Game.
 * It displays a list of saved game slots (sample data here) and provides
 * buttons to load a selected save, delete a save, or return to the main menu.
 *
 * Customize the action listeners to integrate with your game's save/load logic.
 *
 * @author 
 * @version 1.0
 */
public class LoadGameScreen extends JFrame {

    private JList<String> saveList;

    public LoadGameScreen() {
        setTitle("Load Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    /**
     * Initializes the user interface components.
     */
    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        // Title label at the top
        JLabel titleLabel = new JLabel("Load Game", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel, BorderLayout.NORTH);

        // Main panel: List of saved game slots (sample data)
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Save Slot 1 - Pet: Fluffy");
        listModel.addElement("Save Slot 2 - Pet: Sparky");
        listModel.addElement("Save Slot 3 - Pet: Buddy");

        saveList = new JList<>(listModel);
        saveList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        saveList.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane listScrollPane = new JScrollPane(saveList);
        add(listScrollPane, BorderLayout.CENTER);

        // Bottom panel with buttons: Load, Delete, Back
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton loadButton = new JButton("Load Game");
        JButton deleteButton = new JButton("Delete Save");
        JButton backButton = new JButton("Back to Main Menu");

        // Action for "Load Game" button
        loadButton.addActionListener(e -> {
            int selectedIndex = saveList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedSave = saveList.getSelectedValue();
                // Implement your load game logic here
                System.out.println("Loading: " + selectedSave);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a save slot to load.", 
                                              "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Action for "Delete Save" button
        deleteButton.addActionListener(e -> {
            int selectedIndex = saveList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedSave = saveList.getSelectedValue();
                int confirm = JOptionPane.showConfirmDialog(this, 
                        "Are you sure you want to delete: " + selectedSave + "?", 
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    ((DefaultListModel<String>) saveList.getModel()).remove(selectedIndex);
                    System.out.println("Deleted: " + selectedSave);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a save slot to delete.", 
                                              "No Selection", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Action for "Back to Main Menu" button
        backButton.addActionListener(e -> {
            // Implement navigation logic to return to the main menu.
            System.out.println("Returning to Main Menu");
            dispose();
            // Optionally, launch the MainMenu screen:
            // new MainMenu().setVisible(true);
        });

        bottomPanel.add(loadButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Main method to launch the Load Game Screen independently.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoadGameScreen loadGameScreen = new LoadGameScreen();
            loadGameScreen.setVisible(true);
        });
    }
}

