package tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class TileBar extends JPanel {

    public int tileValue;
    public JLabel[] allTiles;
    public Tile selectedTile = new Tile();
    TileList tileList;

    public TileBar(TileList tileList) {
        this.tileList = tileList;
        this.setPreferredSize(new Dimension(350, 68700));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(new Color(17, 27, 80));
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        this.setDoubleBuffered(true);
        addTiles();
    }


    public void addTiles() {
        allTiles = new JLabel[tileList.tileID.length / 2];
        for (int i = 1; i < tileList.tileID.length / 2; i++) {
            allTiles[i] = new JLabel();
            if (tileList.tileID[i].image != null) {
                allTiles[i].setIcon(new ImageIcon(tileList.tileID[i].image.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH)));
                int finalI = i;
                allTiles[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        if (selectedTile == tileList.tileID[finalI]) {
                            allTiles[finalI].setBorder(BorderFactory.createEmptyBorder());
                            tileValue = 0;
                            selectedTile = tileList.tileID[0];
                        } else {
                            selectedTile = tileList.tileID[finalI];
                            tileValue = finalI;
                            for (int i = 1; i < tileList.tileID.length / 2; i++) {
                                if (selectedTile == tileList.tileID[i])
                                    allTiles[i].setBorder(BorderFactory.createLineBorder(new Color(0, 111, 255), 5));
                                else allTiles[i].setBorder(BorderFactory.createEmptyBorder());
                            }
//                            System.out.println("Tile ID = " + finalI);
                        }
                    }
                });
            }
        }
    }


    public void add_EVERYTHING() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            this.add(allTiles[i]);
    }

    public void add_GRASS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].GRASS)
                this.add(allTiles[i]);
    }

    public void add_GRASS_AESTHETICS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].GRASS_AESTHETICS)
                this.add(allTiles[i]);
    }

    public void add_TREES() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].TREES)
                this.add(allTiles[i]);
    }

    public void add_LEVELED_GRASS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].LEVELED_GRASS)
                this.add(allTiles[i]);
    }

    public void add_FARMING_AESTHETICS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].FARMING_AESTHETICS)
                this.add(allTiles[i]);
    }

    public void add_FENCES() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].FENCES)
                this.add(allTiles[i]);
    }

    public void add_FLOORS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].FLOORS)
                this.add(allTiles[i]);
    }

    public void add_WALLS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].WALLS)
                this.add(allTiles[i]);
    }

    public void add_STAIRS_LADDERS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].STAIRS_LADDERS)
                this.add(allTiles[i]);
    }

    public void add_ROOFS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].ROOFS)
                this.add(allTiles[i]);
    }

    public void add_BUILDING_AESTHETICS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].BUILDING_AESTHETICS)
                this.add(allTiles[i]);
    }

    public void add_DOORS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].DOORS)
                this.add(allTiles[i]);
    }

    public void add_SIGNS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].SIGNS)
                this.add(allTiles[i]);
    }

    public void add_CONTAINERS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].CONTAINERS)
                this.add(allTiles[i]);
    }

    public void add_STATUES_STRUCTURES() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].STATUES_STRUCTURES)
                this.add(allTiles[i]);
    }

    public void add_MARKET_SUPPLIES() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].MARKET_SUPPLIES)
                this.add(allTiles[i]);
    }

    public void add_WATER() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].WATER)
                this.add(allTiles[i]);
    }

    public void add_SHADOWS() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].SHADOWS)
                this.add(allTiles[i]);
    }

    public void add_OTHER() {
        this.removeAll();
        for (int i = 1; i < tileList.tileID.length / 2; i++)
            if (tileList.tileID[i].MISCELLANEOUS)
                this.add(allTiles[i]);
    }
}