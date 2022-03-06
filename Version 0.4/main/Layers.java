package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Layers extends JPanel {
    MapPanel mapPanel;
    public Layers(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        this.setPreferredSize(new Dimension(0, 22));
        this.setBackground(new Color(17, 27, 80));
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        this.setMinimumSize(new Dimension(0, 0));
        initializeLayers();
    }

    public String selectedLayer = "Layer 1";

    JButton layer1;
    JButton layer2;
    JButton layer3;
    JButton layer4;
    JButton layer1Vis;
    JButton layer2Vis;
    JButton layer3Vis;
    JButton layer4Vis;

    public boolean showLayerOne = true;
    public boolean showLayerTwo = true;
    public boolean showLayerThree = true;
    public boolean showLayerFour = true;

    Image hideLayer;
    Image showLayer;

    Color select = new Color(185, 185, 185);
    Color unSelect = new Color(52, 52, 52);


    void initializeLayers() {

        try {
            hideLayer = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Layer Hidden.png"))).getScaledInstance(35, 35, BufferedImage.SCALE_SMOOTH);
            showLayer = ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Layer Shown.png"))).getScaledInstance(35, 35, BufferedImage.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Layer One
        layer1 = new JButton();
        layer1.setLayout(null);
        layer1.setPreferredSize(new Dimension(150, 150));
        layer1.setBorder(BorderFactory.createLineBorder(select, 5));
        layer1.setFocusable(false);
        try {
            layer1.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Layer One.png"))).getScaledInstance(150, 150, BufferedImage.SCALE_SMOOTH)));
        } catch (IOException ignored) {
        }
        layer1.addActionListener(e -> {
            selectedLayer = "Layer 1";
            layer1.setBorder(BorderFactory.createLineBorder(select, 5));
            layer2.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer3.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer4.setBorder(BorderFactory.createLineBorder(unSelect, 5));
        });
        layer1Vis = new JButton();
        layer1Vis.setIcon(new ImageIcon(showLayer));
        layer1Vis.setBounds(105, 105, 35, 35);
        layer1Vis.setBorder(BorderFactory.createEmptyBorder());
        layer1Vis.setFocusable(false);
        layer1Vis.addActionListener(e -> {
            showLayerOne = !showLayerOne;
            layer1Vis.setIcon(new ImageIcon(showLayerOne ? showLayer : hideLayer));
            mapPanel.repaint();
        });
        layer1.add(layer1Vis);

        // Layer Two
        layer2 = new JButton();
        layer2.setLayout(null);
        layer2.setPreferredSize(new Dimension(150, 150));
        layer2.setBorder(BorderFactory.createLineBorder(unSelect, 5));
        layer2.setFocusable(false);
        try {
            layer2.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Layer Two.png"))).getScaledInstance(150, 150, BufferedImage.SCALE_SMOOTH)));
        } catch (IOException ignored) {
        }
        layer2.addActionListener(e -> {
            selectedLayer = "Layer 2";
            layer1.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer2.setBorder(BorderFactory.createLineBorder(select, 5));
            layer3.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer4.setBorder(BorderFactory.createLineBorder(unSelect, 5));
        });
        layer2Vis = new JButton();
        layer2Vis.setIcon(new ImageIcon(showLayer));
        layer2Vis.setBounds(105, 105, 35, 35);
        layer2Vis.setBorder(BorderFactory.createEmptyBorder());
        layer2Vis.setFocusable(false);
        layer2Vis.addActionListener(e -> {
            showLayerTwo = !showLayerTwo;
            layer2Vis.setIcon(new ImageIcon(showLayerTwo ? showLayer : hideLayer));
            mapPanel.repaint();
        });
        layer2.add(layer2Vis);

        // Layer Three
        layer3 = new JButton();
        layer3.setLayout(null);
        layer3.setPreferredSize(new Dimension(150, 150));
        layer3.setBorder(BorderFactory.createLineBorder(unSelect, 5));
        layer3.setFocusable(false);
        try {
            layer3.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Layer Three.png"))).getScaledInstance(150, 150, BufferedImage.SCALE_SMOOTH)));
        } catch (IOException ignored) {
        }
        layer3.addActionListener(e -> {
            selectedLayer = "Layer 3";
            layer1.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer2.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer3.setBorder(BorderFactory.createLineBorder(select, 5));
            layer4.setBorder(BorderFactory.createLineBorder(unSelect, 5));
        });
        layer3Vis = new JButton();
        layer3Vis.setIcon(new ImageIcon(showLayer));
        layer3Vis.setBounds(105, 105, 35, 35);
        layer3Vis.setBorder(BorderFactory.createEmptyBorder());
        layer3Vis.setFocusable(false);
        layer3Vis.addActionListener(e -> {
            showLayerThree = !showLayerThree;
            layer3Vis.setIcon(new ImageIcon(showLayerThree ? showLayer : hideLayer));
            mapPanel.repaint();
        });
        layer3.add(layer3Vis);

        // Layer Four
        layer4 = new JButton();
        layer4.setLayout(null);
        layer4.setPreferredSize(new Dimension(150, 150));
        layer4.setBorder(BorderFactory.createLineBorder(unSelect, 5));
        layer4.setFocusable(false);
        try {
            layer4.setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Layer Four.png"))).getScaledInstance(150, 150, BufferedImage.SCALE_SMOOTH)));
        } catch (IOException ignored) {
        }
        layer4.addActionListener(e -> {
            selectedLayer = "Layer 4";
            layer1.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer2.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer3.setBorder(BorderFactory.createLineBorder(unSelect, 5));
            layer4.setBorder(BorderFactory.createLineBorder(select, 5));
        });
        layer4Vis = new JButton();
        layer4Vis.setIcon(new ImageIcon(showLayer));
        layer4Vis.setBounds(105, 105, 35, 35);
        layer4Vis.setBorder(BorderFactory.createEmptyBorder());
        layer4Vis.setFocusable(false);
        layer4Vis.addActionListener(e -> {
            showLayerFour = !showLayerFour;
            layer4Vis.setIcon(new ImageIcon(showLayerFour ? showLayer : hideLayer));
            mapPanel.repaint();
        });
        layer4.add(layer4Vis);

        this.add(layer1);
        this.add(layer2);
        this.add(layer3);
        this.add(layer4);
    }
}