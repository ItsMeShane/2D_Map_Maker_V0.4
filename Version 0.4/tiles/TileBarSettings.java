package tiles;

import main.MapPanel;
import utilities.Options;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static main.Main.*;

public class TileBarSettings extends JPanel {

    TileBar tileBar;
    JScrollPane barScroll;
    MapPanel mapPanel;

    public String collisionState;
    public String showCollisionState;
    public Options options;
    Border border = BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5);

    public TileBarSettings(TileBar tileBar, JScrollPane barScroll, MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        this.tileBar = tileBar;
        this.barScroll = barScroll;
        this.setLayout(new GridLayout(2, 2));
        this.setDoubleBuffered(true);
        this.setBorder(border);
        this.setMinimumSize(new Dimension(0, 150));

        collisionState = "Off";
        showCollisionState = "Off";
        options = new Options(mapPanel);

        initializeTileBarSettings();
    }

    void initializeTileBarSettings() {

        JButton collisionButt = new JButton("Collision: " + collisionState);
        collisionButt.setBackground(new Color(182, 66, 66));
        collisionButt.setFocusable(false);
        collisionButt.setFocusPainted(false);
        collisionButt.setVisible(true);
        collisionButt.setFont(rockwell);
        collisionButt.setForeground(Color.black);
        collisionButt.setBorder(border);
        collisionButt.setOpaque(true);
        collisionButt.addActionListener(e -> {
            switch (collisionState) {
                case "Off":
                    collisionState = "On";
                    collisionButt.setBackground(new Color(91, 182, 66));
                    break;
                case "On":
                    collisionState = "Off";
                    collisionButt.setBackground(new Color(182, 66, 66));
                    break;
            }
            collisionButt.setText("Collision: " + collisionState);
            mapPanel.repaint();
        });

        JButton showCollButt = new JButton("Show Collision: " + showCollisionState);
        showCollButt.setPreferredSize(new Dimension(250, 50));
        showCollButt.setBackground(new Color(182, 66, 66));
        showCollButt.setFocusable(false);
        showCollButt.setFocusPainted(false);
        showCollButt.setVisible(true);
        showCollButt.setFont(rockwell);
        showCollButt.setForeground(Color.black);
        showCollButt.setBorder(border);
        showCollButt.setOpaque(true);
        showCollButt.addActionListener(e -> {
            switch (showCollisionState) {
                case "Off":
                    showCollisionState = "On";
                    showCollButt.setBackground(new Color(91, 182, 66));
                    break;
                case "On":
                    showCollisionState = "Off";
                    showCollButt.setBackground(new Color(182, 66, 66));
                    break;
            }
            showCollButt.setText("Show Collision: " + showCollisionState);
            mapPanel.repaint();
        });

        JButton optionsButt = new JButton("Options");
        optionsButt.setPreferredSize(new Dimension(250, 50));
        optionsButt.setBackground(Color.ORANGE);
        optionsButt.setFocusable(false);
        optionsButt.setFocusPainted(false);
        optionsButt.setVisible(true);
        optionsButt.setFont(rockwell);
        optionsButt.setForeground(Color.black);
        optionsButt.setBorder(border);
        optionsButt.setOpaque(true);
        optionsButt.addActionListener(e -> {
//            UIManager.put("OptionPane.background",new ColorUIResource(new Color(255, 242, 0, 255)));
            JOptionPane.showOptionDialog(null, options,"Options", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });

        String[] filterOptions = new String[]{
                "Everything",
                "Grass",
                "Grass Aesthetics",
                "Trees",
                "Leveled Grass",
                "Farming Aesthetics",
                "Fences",
                "Floors",
                "Walls",
                "Roofs",
                "Stairs and Ladders",
                "Building Aesthetics",
                "Doors",
                "Signs",
                "Containers",
                "Statues and Structures",
                "Market Supplies",
                "Water",
                "Shadows",
                "Miscellaneous"
        };

        JComboBox<String> filter = new JComboBox<>(filterOptions);
        filter.setBackground(Color.ORANGE);
        filter.setBorder(border);
        filter.setFont(new Font("Rockwell", Font.BOLD, 17));
        DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        defaultRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        filter.setRenderer(defaultRenderer);
        filter.setFocusable(false);
        filter.addActionListener(e -> {
            switch (filter.getItemAt(filter.getSelectedIndex())) {
                case "Everything":
                    tileBar.add_EVERYTHING();
                    tileBar.setPreferredSize(new Dimension(350, 68700));
                    break;
                case "Grass":
                    tileBar.add_GRASS();
                    tileBar.setPreferredSize(new Dimension(350, 8750));
                    break;
                case "Grass Aesthetics":
                    tileBar.add_GRASS_AESTHETICS();
                    tileBar.setPreferredSize(new Dimension(350, 2600));
                    break;
                case "Trees":
                    tileBar.add_TREES();
                    tileBar.setPreferredSize(new Dimension(350, 4000));
                    break;
                case "Walls":
                    tileBar.add_WALLS();
                    tileBar.setPreferredSize(new Dimension(350, 10000));
                    break;
                case "Floors":
                    tileBar.add_FLOORS();
                    tileBar.setPreferredSize(new Dimension(350, 1300));
                    break;
                case "Roofs":
                    tileBar.add_ROOFS();
                    tileBar.setPreferredSize(new Dimension(350, 1200));
                    break;
                case "Stairs and Ladders":
                    tileBar.add_STAIRS_LADDERS();
                    tileBar.setPreferredSize(new Dimension(350, 1500));
                    break;
                case "Leveled Grass":
                    tileBar.add_LEVELED_GRASS();
                    tileBar.setPreferredSize(new Dimension(350, 5800));
                    break;
                case "Farming Aesthetics":
                    tileBar.add_FARMING_AESTHETICS();
                    tileBar.setPreferredSize(new Dimension(350, 1000));
                    break;
                case "Fences":
                    tileBar.add_FENCES();
                    tileBar.setPreferredSize(new Dimension(350, 2000));
                    break;
                case "Building Aesthetics":
                    tileBar.add_BUILDING_AESTHETICS();
                    tileBar.setPreferredSize(new Dimension(350, 7300));
                    break;
                case "Doors":
                    tileBar.add_DOORS();
                    tileBar.setPreferredSize(new Dimension(350, 3800));
                    break;
                case "Signs":
                    tileBar.add_SIGNS();
                    tileBar.setPreferredSize(new Dimension(350, 2500));
                    break;
                case "Containers":
                    tileBar.add_CONTAINERS();
                    tileBar.setPreferredSize(new Dimension(350, 3000));
                    break;
                case "Statues and Structures":
                    tileBar.add_STATUES_STRUCTURES();
                    tileBar.setPreferredSize(new Dimension(350, 2800));
                    break;
                case "Market Supplies":
                    tileBar.add_MARKET_SUPPLIES();
                    tileBar.setPreferredSize(new Dimension(350, 3700));
                    break;
                case "Water":
                    tileBar.add_WATER();
                    tileBar.setPreferredSize(new Dimension(350, 3500));
                    break;
                case "Shadows":
                    tileBar.add_SHADOWS();
                    tileBar.setPreferredSize(new Dimension(350, 2000));
                    break;
                case "Miscellaneous":
                    tileBar.add_OTHER();
                    tileBar.setPreferredSize(new Dimension(350, 5500));
                    break;
            }
            tileBar.revalidate();
            // sets bar back to top. also repaints
            barScroll.getVerticalScrollBar().setValue(1);
            barScroll.getVerticalScrollBar().setValue(0);
        });
        this.add(filter);
        this.add(optionsButt);
        this.add(collisionButt);
        this.add(showCollButt);
    }
}