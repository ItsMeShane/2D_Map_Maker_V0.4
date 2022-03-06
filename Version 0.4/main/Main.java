package main;

import input.KeyInput;
import tiles.TileBar;
import tiles.TileList;
import utilities.Tools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Main {

    public static Font rockwell = new Font("Rockwell", Font.BOLD, 20);

    public static void main(String[] args) throws Exception {
/*
         creates all main components needed and adds them together
*/
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (JOptionPane.showOptionDialog(frame, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0) == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        TileList tileList = new TileList();

        TileBar tileBar = new TileBar(tileList);

        JScrollPane barScroll = new JScrollPane(tileBar);
        barScroll.setWheelScrollingEnabled(true);
        barScroll.getVerticalScrollBar().setUnitIncrement(12);
        barScroll.getHorizontalScrollBar().setEnabled(true);
        tileBar.add_EVERYTHING();

        JScrollPane mapScroll = new JScrollPane();

        MapPanel mapPanel = new MapPanel(mapScroll, tileList, tileBar, barScroll);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(mapPanel);
        centerPanel.setBackground(new Color(56, 56, 56));

        mapScroll.getViewport().add(centerPanel);
        mapScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mapScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mapScroll.setPreferredSize(new Dimension(0,  Toolkit.getDefaultToolkit().getScreenSize().height/5*4));  // 973

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, mapScroll, mapPanel.layers), new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, new JSplitPane(JSplitPane.VERTICAL_SPLIT, mapPanel.tileBarSettings, new Tools(mapPanel)), barScroll));

        split.setDividerLocation((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 4 * 3);

        split.getRightComponent().setEnabled(false);
        frame.add(split);

        frame.addKeyListener(new KeyInput(mapPanel));
        frame.pack();
        frame.setFocusable(true);
        frame.requestFocus();
        frame.setVisible(true);
        frame.setIconImage(ImageIO.read(Objects.requireNonNull(ClassLoader.getSystemResourceAsStream("Tile ID = (60).png"))));
    }
}