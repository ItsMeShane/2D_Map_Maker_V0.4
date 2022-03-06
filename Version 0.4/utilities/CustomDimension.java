package utilities;

import main.MapPanel;

import javax.swing.*;
import java.awt.*;

import static main.Main.*;

public class CustomDimension extends JPanel {
    MapPanel mapPanel;
    public CustomDimension(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.YELLOW);
        this.setPreferredSize(new Dimension(400, 170));
        addObjects();
    }

    JLabel dimensions = new JLabel("Dimensions: X=100, Y=100", SwingConstants.CENTER);
    JSlider xSlider = new JSlider(0, 200);
    JSlider ySlider = new JSlider(0, 200);

    void addObjects() {

        JLabel xLbl = new JLabel("Width:", SwingConstants.CENTER);
        xLbl.setBackground(Color.ORANGE);
        xLbl.setOpaque(true);
        xLbl.setFont(rockwell);
        xLbl.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        xLbl.setForeground(Color.black);
        xLbl.setPreferredSize(new Dimension(100, 50));


        xSlider.setValue(xSlider.getMaximum() / 2);
        xSlider.setPreferredSize(new Dimension(280, 50));
        xSlider.setPaintTrack(true);
        xSlider.setPaintTicks(true);
        xSlider.setPaintLabels(true);
        xSlider.setMajorTickSpacing(50);
        xSlider.setMinorTickSpacing(25);
        xSlider.setBackground(Color.ORANGE);
        xSlider.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        xSlider.setForeground(Color.black);
        xSlider.addChangeListener(changeEvent -> {
            if (xSlider.getValue()==0)
                xSlider.setValue(1);
            mapPanel.maxMapTilesX = xSlider.getValue();
            update();
        });


        JLabel yLbl = new JLabel("Height:", SwingConstants.CENTER);
        yLbl.setBackground(Color.ORANGE);
        yLbl.setOpaque(true);
        yLbl.setFont(rockwell);
        yLbl.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        yLbl.setForeground(Color.black);
        yLbl.setPreferredSize(new Dimension(100, 50));


        ySlider.setValue(ySlider.getMaximum() / 2);
        ySlider.setPreferredSize(new Dimension(280, 50));
        ySlider.setPaintTrack(true);
        ySlider.setPaintTicks(true);
        ySlider.setPaintLabels(true);
        ySlider.setMajorTickSpacing(50);
        ySlider.setMinorTickSpacing(25);
        ySlider.setBackground(Color.ORANGE);
        ySlider.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        ySlider.setForeground(Color.black);
        ySlider.addChangeListener(changeEvent -> {
            if (ySlider.getValue()==0)
                ySlider.setValue(1);
            mapPanel.maxMapTilesY = ySlider.getValue();
            update();
        });


        dimensions.setBackground(Color.ORANGE);
        dimensions.setOpaque(true);
        dimensions.setFont(rockwell);
        dimensions.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        dimensions.setForeground(Color.black);
        dimensions.setPreferredSize(new Dimension(300, 50));


        this.add(xLbl);
        this.add(xSlider);
        this.add(yLbl);
        this.add(ySlider);
        this.add(dimensions);
    }


    void update() {
        dimensions.setText("Dimensions: X=" + xSlider.getValue() + ", Y=" + ySlider.getValue());

        mapPanel.L1_mapTileCoordinate = new int[mapPanel.maxMapTilesX][mapPanel.maxMapTilesY];
        mapPanel.L2_mapTileCoordinate = new int[mapPanel.maxMapTilesX][mapPanel.maxMapTilesY];
        mapPanel.L3_mapTileCoordinate = new int[mapPanel.maxMapTilesX][mapPanel.maxMapTilesY];
        mapPanel.L4_mapTileCoordinate = new int[mapPanel.maxMapTilesX][mapPanel.maxMapTilesY];
        mapPanel.emptyLayer.delete(0, mapPanel.emptyLayer.length());
        for (int i = 0; i < mapPanel.maxMapTilesY; i++) {
            for (int ii = 0; ii < mapPanel.maxMapTilesX; ii++)
                mapPanel.emptyLayer.append("0 ");
            mapPanel.emptyLayer.append("\n");
        }
        mapPanel.L1_mapStringLine = new StringBuilder(mapPanel.emptyLayer);
        mapPanel.L2_mapStringLine = new StringBuilder(mapPanel.emptyLayer);
        mapPanel.L3_mapStringLine = new StringBuilder(mapPanel.emptyLayer);
        mapPanel.L4_mapStringLine = new StringBuilder(mapPanel.emptyLayer);

        mapPanel.repaint();
    }
}