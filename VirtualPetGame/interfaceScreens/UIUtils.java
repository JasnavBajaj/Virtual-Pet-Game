package group29.VirtualPetGame.interfaceScreens;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * UIUtils.java
 *
 * A collection of utility methods for user interface components used in the Virtual Pet Game.
 * This class provides helper methods to center windows, load and scale icons from resources,
 * and set default fonts for UI components.
 *
 * Usage examples:
 * - UIUtils.centerFrame(frame);
 * - ImageIcon icon = UIUtils.loadIcon("/sprites/pet1.png");
 * - ImageIcon scaledIcon = UIUtils.scaleIcon(icon, 100, 100);
 * - UIUtils.setDefaultFont(new Font("Arial", Font.PLAIN, 14));
 *
 * @author 
 * @version 1.0
 */
public class UIUtils {

    /**
     * Centers a JFrame on the screen.
     *
     * @param frame the JFrame to center.
     */
    public static void centerFrame(JFrame frame) {
        frame.setLocationRelativeTo(null);
    }
    
    /**
     * Centers a window on the screen.
     *
     * @param window the Window (JFrame, JDialog, etc.) to center.
     */
    public static void centerWindow(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension windowSize = window.getSize();
        int x = (screenSize.width - windowSize.width) / 2;
        int y = (screenSize.height - windowSize.height) / 2;
        window.setLocation(x, y);
    }
    
    /**
     * Loads an ImageIcon from the specified resource path.
     * The path should be relative to the classpath.
     *
     * @param path the path to the image resource (e.g., "/sprites/pet1.png").
     * @return an ImageIcon if the resource is found; otherwise, null.
     */
    public static ImageIcon loadIcon(String path) {
        URL resource = UIUtils.class.getResource(path);
        if (resource != null) {
            return new ImageIcon(resource);
        } else {
            System.err.println("Resource not found: " + path);
            return null;
        }
    }
    
    /**
     * Scales an ImageIcon to the given width and height.
     *
     * @param icon   the original ImageIcon.
     * @param width  the target width.
     * @param height the target height.
     * @return a scaled ImageIcon, or null if the original icon is null.
     */
    public static ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        if (icon == null) {
            return null;
        }
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
    
    /**
     * Sets the default font for various UI components.
     * This method applies the specified font to components like labels, buttons,
     * text fields, and more.
     *
     * @param font the Font to set as default.
     */
    public static void setDefaultFont(Font font) {
        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("List.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("MenuItem.font", font);
    }
}

