package utilities;

import main.MapPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static main.Main.rockwell;

public class Tools extends JPanel {

    Border border = BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5);
    Color red = new Color(182, 66, 66);
    Color green = new Color(91, 182, 66);

    public static String selectedTool = "Pen";
    public static boolean showProperties = false;
    MapPanel mapPanel;

    public Tools(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        this.setLayout(new GridLayout(1, 4));
        this.setMinimumSize(new Dimension(0, 50));
        addTools();
    }


    void addTools() {
        JButton penButt = new JButton();
        JButton rectButt = new JButton();
        JButton fillButt = new JButton();
        JButton eyeButt = new JButton();
        JButton properties = new JButton();

        penButt.setIcon(setImageIcon("Pencil.png"));
        rectButt.setIcon(setImageIcon("Rectangle.png"));
        fillButt.setIcon(setImageIcon("Paint Bucket.png"));
        eyeButt.setIcon(setImageIcon("Eye Dropper.png"));
        properties.setIcon(setImageIcon("Properties.png"));

        penButt.setPreferredSize(new Dimension(250, 50));
        penButt.setBackground(green);
        penButt.setFocusable(false);
        penButt.setFocusPainted(false);
        penButt.setVisible(true);
        penButt.setFont(rockwell);
        penButt.setForeground(Color.black);
        penButt.setBorder(border);
        penButt.setOpaque(true);
        penButt.addActionListener(e -> {
            selectedTool = "Pen";
            penButt.setBackground(green);
            rectButt.setBackground(red);
            fillButt.setBackground(red);
            eyeButt.setBackground(red);
        });


        rectButt.setPreferredSize(new Dimension(250, 50));
        rectButt.setBackground(red);
        rectButt.setFocusable(false);
        rectButt.setFocusPainted(false);
        rectButt.setVisible(true);
        rectButt.setFont(rockwell);
        rectButt.setForeground(Color.black);
        rectButt.setBorder(border);
        rectButt.setOpaque(true);
        rectButt.addActionListener(e -> {
            selectedTool = "Rectangle";
            penButt.setBackground(red);
            rectButt.setBackground(green);
            fillButt.setBackground(red);
            eyeButt.setBackground(red);
        });


        fillButt.setPreferredSize(new Dimension(250, 50));
        fillButt.setBackground(red);
        fillButt.setFocusable(false);
        fillButt.setFocusPainted(false);
        fillButt.setVisible(true);
        fillButt.setFont(rockwell);
        fillButt.setForeground(Color.black);
        fillButt.setBorder(border);
        fillButt.setOpaque(true);
        fillButt.addActionListener(e -> {
            selectedTool = "Fill";
            penButt.setBackground(red);
            rectButt.setBackground(red);
            fillButt.setBackground(green);
            eyeButt.setBackground(red);
        });


        eyeButt.setPreferredSize(new Dimension(250, 50));
        eyeButt.setBackground(red);
        eyeButt.setFocusable(false);
        eyeButt.setFocusPainted(false);
        eyeButt.setVisible(true);
        eyeButt.setFont(rockwell);
        eyeButt.setForeground(Color.black);
        eyeButt.setBorder(border);
        eyeButt.setOpaque(true);
        eyeButt.addActionListener(e -> {
            selectedTool = "Eye Dropper";
            penButt.setBackground(red);
            rectButt.setBackground(red);
            fillButt.setBackground(red);
            eyeButt.setBackground(green);
        });


        properties.setPreferredSize(new Dimension(250, 50));
        properties.setBackground(red);
        properties.setFocusable(false);
        properties.setFocusPainted(false);
        properties.setVisible(true);
        properties.setFont(rockwell);
        properties.setForeground(Color.black);
        properties.setBorder(border);
        properties.setOpaque(true);
        properties.addActionListener(e -> {
            showProperties = !showProperties;
            mapPanel.repaint();
            properties.setBackground(showProperties ? green : red);
        });


        this.add(penButt);
        this.add(rectButt);
        this.add(fillButt);
        this.add(eyeButt);
        this.add(properties);
    }

    ImageIcon setImageIcon(String name) {
        try {
            return new ImageIcon(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream(name))).getScaledInstance(50, 50, BufferedImage.SCALE_SMOOTH));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}