package utilities;

import main.MapPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

import static main.Main.*;
import static java.awt.Color.*;

public class Options extends JPanel {
    MapPanel mapPanel;
    public Options(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
        this.setPreferredSize(new Dimension(350, 400));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.YELLOW);
        this.setDoubleBuffered(true);
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        this.setMinimumSize(new Dimension(0, 0));
        initializeOptionPanel();
    }

    void initializeOptionPanel() {
        JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(300, 50));
        exit.setBackground(Color.ORANGE);
        exit.setFocusable(false);
        exit.setFocusPainted(false);
        exit.setVisible(true);
        exit.setFont(rockwell);
        exit.setForeground(Color.black);
        exit.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        exit.setOpaque(true);
        exit.addActionListener(e -> {
            if (JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0) == JOptionPane.YES_OPTION)
                System.exit(0);
        });

        JButton save = new JButton("Save Map");
        save.setPreferredSize(new Dimension(300, 50));
        save.setBackground(Color.ORANGE);
        save.setFocusable(false);
        save.setFocusPainted(false);
        save.setVisible(true);
        save.setFont(rockwell);
        save.setForeground(Color.black);
        save.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        save.setOpaque(true);
        save.addActionListener(actionEvent -> saveMap());

        JButton load = new JButton("Load Map");
        load.setPreferredSize(new Dimension(300, 50));
        load.setBackground(Color.ORANGE);
        load.setFocusable(false);
        load.setFocusPainted(false);
        load.setVisible(true);
        load.setFont(rockwell);
        load.setForeground(Color.black);
        load.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        load.setOpaque(true);
        load.addActionListener(e -> {
            try {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    FileReader reader = new FileReader(fileChooser.getSelectedFile().getAbsolutePath());
                    int tileVal = reader.read();
                    StringBuilder numMap = new StringBuilder();
                    while (tileVal != -1) {
                        numMap.append((char) tileVal);
                        tileVal = reader.read();
                    }
                    reader.close();
                    loadMap(numMap.toString());
                }
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        });

        JTextPane genMapTxt = new JTextPane();
        genMapTxt.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width / 10 * 9, Toolkit.getDefaultToolkit().getScreenSize().height / 10 * 9));
        genMapTxt.setBackground(lightGray);
        JScrollPane genMapScroll = new JScrollPane(genMapTxt);
        genMapScroll.getHorizontalScrollBar().setEnabled(true);
        genMapScroll.getHorizontalScrollBar().setVisible(true);
        genMapScroll.getVerticalScrollBar().setEnabled(true);

        JButton genMap = new JButton("Generate Map");
        genMap.setPreferredSize(new Dimension(300, 50));
        genMap.setBackground(orange);
        genMap.setFocusable(false);
        genMap.setFocusPainted(false);
        genMap.setVisible(true);
        genMap.setFont(rockwell);
        genMap.setForeground(Color.black);
        genMap.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        genMap.setOpaque(true);
        genMap.addActionListener(e -> {
            genMapTxt.setText("" + mapPanel.L1_mapStringLine + mapPanel.L2_mapStringLine + mapPanel.L3_mapStringLine + mapPanel.L4_mapStringLine + mapPanel.maxMapTilesX + " " + mapPanel.maxMapTilesY);
            genMapTxt.selectAll();
            JOptionPane.showOptionDialog(null, genMapScroll, "Number Map", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });

        JButton upload = new JButton("Upload Map");
        upload.setPreferredSize(new Dimension(300, 50));
        upload.setBackground(orange);
        upload.setFocusable(false);
        upload.setFocusPainted(false);
        upload.setVisible(true);
        upload.setFont(rockwell);
        upload.setForeground(Color.black);
        upload.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        upload.setOpaque(true);
        upload.addActionListener(e -> {
            try {
                loadMap(JOptionPane.showInputDialog(null, "Enter a saved number map. These\ncan be obtained from \"Generate Map\".", "Enter Number Map", JOptionPane.PLAIN_MESSAGE).replaceAll(" {2}", "\n"));
            } catch (NumberFormatException NFE) {
                System.out.println("non number inputted");
            } catch (NullPointerException NPE) {
                System.out.println("Null");
            }
        });


        CustomDimension customDimension = new CustomDimension(mapPanel);
        JButton dimensions = new JButton("Change Dimensions");
        dimensions.setPreferredSize(new Dimension(300, 50));
        dimensions.setBackground(orange);
        dimensions.setFocusable(false);
        dimensions.setFocusPainted(false);
        dimensions.setVisible(true);
        dimensions.setFont(rockwell);
        dimensions.setForeground(Color.black);
        dimensions.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        dimensions.setOpaque(true);
        dimensions.addActionListener(e -> {
            if (JOptionPane.showOptionDialog(null, "Changing the dimensions will reset the current map.\nAre you sure you want to continue?", "WARNING", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0) == JOptionPane.YES_OPTION)
                JOptionPane.showOptionDialog(null, customDimension, "Enter Dimensions", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
        });


        JButton controls = new JButton("Show Controls");
        controls.setPreferredSize(new Dimension(300, 50));
        controls.setBackground(orange);
        controls.setFocusable(false);
        controls.setFocusPainted(false);
        controls.setVisible(true);
        controls.setFont(rockwell);
        controls.setForeground(Color.black);
        controls.setBorder(BorderFactory.createLineBorder(Color.YELLOW.darker().darker(), 5));
        controls.setOpaque(true);
        controls.addActionListener(e -> {
            try {
                JOptionPane.showOptionDialog(null, new ImageIcon(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Controls.png"))).getScaledInstance(Toolkit.getDefaultToolkit().getScreenSize().width / 10 * 7, Toolkit.getDefaultToolkit().getScreenSize().height / 10 * 7, BufferedImage.SCALE_SMOOTH)), "Controls", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        this.add(exit);
        this.add(save);
        this.add(load);
        this.add(genMap);
        this.add(upload);
        this.add(dimensions);
        this.add(controls);
    }


    void saveMap() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            Path path = Paths.get(fileChooser.getSelectedFile().getAbsolutePath());
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
                writer.write("" + mapPanel.L1_mapStringLine + mapPanel.L2_mapStringLine + mapPanel.L3_mapStringLine + mapPanel.L4_mapStringLine + mapPanel.maxMapTilesX + " " + mapPanel.maxMapTilesY);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void loadMap(String numMap) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(numMap));

            // finds last line and assigns maxX and maxY
            String dimLine;
            while ((dimLine = bufferedReader.readLine()) != null) {
                mapPanel.maxMapTilesX = Integer.parseInt(dimLine.split(" ")[0]);
                mapPanel.maxMapTilesY = Integer.parseInt(dimLine.split(" ")[1]);
            }
            // recreates variables with new dimensions
            update();

            // resets bufferedReader to starting position
            bufferedReader = new BufferedReader(new StringReader(numMap));
            // reads loaded map and transfers contents into a temporary string
            for (int positionY = 0; positionY < mapPanel.maxMapTilesY * 4; positionY++) {  // max Y * total layers
                // assigns what line to load
                String line = bufferedReader.readLine();
                // layer one
                if (positionY < mapPanel.maxMapTilesY)
                    for (int positionX = 0; positionX < mapPanel.maxMapTilesX; positionX++)
                        mapPanel.L1_mapTileCoordinate[positionX][positionY] = Integer.parseInt(line.split(" ")[positionX]);  // mapTileCoordinate[x][y] = number that line read
                // layer two
                if (positionY > mapPanel.maxMapTilesY - 1 && positionY < mapPanel.maxMapTilesY * 2)
                    for (int positionX = 0; positionX < mapPanel.maxMapTilesX; positionX++)
                        mapPanel.L2_mapTileCoordinate[positionX][positionY - mapPanel.maxMapTilesY] = Integer.parseInt(line.split(" ")[positionX]);
                // layer three
                if (positionY > mapPanel.maxMapTilesY * 2 - 1 && positionY < mapPanel.maxMapTilesY * 3)
                    for (int positionX = 0; positionX < mapPanel.maxMapTilesX; positionX++)
                        mapPanel.L3_mapTileCoordinate[positionX][positionY - mapPanel.maxMapTilesY * 2] = Integer.parseInt(line.split(" ")[positionX]);
                // layer four
                if (positionY > mapPanel.maxMapTilesY * 3 - 1 && positionY < mapPanel.maxMapTilesY * 4)
                    for (int positionX = 0; positionX < mapPanel.maxMapTilesX; positionX++)
                        mapPanel.L4_mapTileCoordinate[positionX][positionY - mapPanel.maxMapTilesY * 3] = Integer.parseInt(line.split(" ")[positionX]);
            }
            bufferedReader.close();
            // takes string from previous step and moves it to a new string
            mapPanel.L1_mapStringLine = new StringBuilder();
            for (int i = 0; i < mapPanel.maxMapTilesY; i++) {
                for (int ii = 0; ii < mapPanel.maxMapTilesX; ii++)
                    mapPanel.L1_mapStringLine.append(mapPanel.L1_mapTileCoordinate[ii][i]).append(" ");
                mapPanel.L1_mapStringLine.append("\n");
            }
            mapPanel.L2_mapStringLine = new StringBuilder();
            for (int i = 0; i < mapPanel.maxMapTilesY; i++) {
                for (int ii = 0; ii < mapPanel.maxMapTilesX; ii++)
                    mapPanel.L2_mapStringLine.append(mapPanel.L2_mapTileCoordinate[ii][i]).append(" ");
                mapPanel.L2_mapStringLine.append("\n");
            }
            mapPanel.L3_mapStringLine = new StringBuilder();
            for (int i = 0; i < mapPanel.maxMapTilesY; i++) {
                for (int ii = 0; ii < mapPanel.maxMapTilesX; ii++)
                    mapPanel.L3_mapStringLine.append(mapPanel.L3_mapTileCoordinate[ii][i]).append(" ");
                mapPanel.L3_mapStringLine.append("\n");
            }
            mapPanel.L4_mapStringLine = new StringBuilder();
            for (int i = 0; i < mapPanel.maxMapTilesY; i++) {
                for (int ii = 0; ii < mapPanel.maxMapTilesX; ii++)
                    mapPanel.L4_mapStringLine.append(mapPanel.L4_mapTileCoordinate[ii][i]).append(" ");
                mapPanel.L4_mapStringLine.append("\n");
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("out of bounds");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mapPanel.repaint();
    }


    void update() {
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