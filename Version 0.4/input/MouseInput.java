package input;

import main.MapPanel;
import utilities.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseInput extends MouseAdapter {

    MapPanel mapPanel;

    public MouseInput(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }
    int pressedX;
    int pressedY;

    // sets location to draw tile (-1 if not drawing)
    int tileLocationX = -1;
    int tileLocationY = -1;

    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            int X = (int) (e.getX() / mapPanel.zoomScale);
            int Y = (int) (e.getY() / mapPanel.zoomScale);
            if (Tools.selectedTool.equals("Eye Dropper")) {
                int temp = mapPanel.tileBar.tileValue == 0 ? 1 : mapPanel.tileBar.tileValue;
                switch (mapPanel.layers.selectedLayer) {
                    case "Layer 1":
                        if (mapPanel.layers.showLayerOne)
                            mapPanel.tileBar.tileValue = mapPanel.L1_mapTileCoordinate[X][Y] < mapPanel.tileList.tileID.length / 2 ? mapPanel.L1_mapTileCoordinate[X][Y] : mapPanel.L1_mapTileCoordinate[X][Y] - mapPanel.tileList.tileID.length / 2;
                        break;
                    case "Layer 2":
                        if (mapPanel.layers.showLayerTwo)
                            mapPanel.tileBar.tileValue = mapPanel.L2_mapTileCoordinate[X][Y] < mapPanel.tileList.tileID.length / 2 ? mapPanel.L2_mapTileCoordinate[X][Y] : mapPanel.L2_mapTileCoordinate[X][Y] - mapPanel.tileList.tileID.length / 2;
                        break;
                    case "Layer 3":
                        if (mapPanel.layers.showLayerThree)
                            mapPanel.tileBar.tileValue = mapPanel.L3_mapTileCoordinate[X][Y] < mapPanel.tileList.tileID.length / 2 ? mapPanel.L3_mapTileCoordinate[X][Y] : mapPanel.L3_mapTileCoordinate[X][Y] - mapPanel.tileList.tileID.length / 2;
                        break;
                    case "Layer 4":
                        if (mapPanel.layers.showLayerFour)
                            mapPanel.tileBar.tileValue = mapPanel.L4_mapTileCoordinate[X][Y] < mapPanel.tileList.tileID.length / 2 ? mapPanel.L4_mapTileCoordinate[X][Y] : mapPanel.L4_mapTileCoordinate[X][Y] - mapPanel.tileList.tileID.length / 2;
                        break;
                }
                // manage selected tile highlight
                if (mapPanel.tileBar.tileValue != 0 && mapPanel.tileBar.tileValue != temp) {
                    mapPanel.tileBar.allTiles[mapPanel.tileBar.tileValue].setBorder(BorderFactory.createLineBorder(new Color(0, 111, 255), 5));
                    mapPanel.tileBar.allTiles[temp].setBorder(BorderFactory.createEmptyBorder());
                } else if (mapPanel.tileBar.tileValue == 0) {
                    mapPanel.tileBar.allTiles[temp].setBorder(BorderFactory.createEmptyBorder());
                }
            }
        }
    }


    public void mousePressed(MouseEvent e) {
        int X = (int) (e.getX() / mapPanel.zoomScale);
        int Y = (int) (e.getY() / mapPanel.zoomScale);
        if (e.getButton() == MouseEvent.BUTTON1) {
            pressedX = e.getX();
            pressedY = e.getY();
            switch (Tools.selectedTool) {
                case "Pen":
                    if (e.isControlDown() || e.isShiftDown()) {
                        tileLocationX = -1;
                        tileLocationY = -1;
                    } else {
                        place_1(X, Y);
                    }
                    break;
                case "Rectangle":
                    if (!e.isControlDown() && !e.isShiftDown()) {
                        mapPanel.pointStart.x = X;
                        mapPanel.pointStart.y = Y;
                    }
                    break;
                case "Fill":
                    mapPanel.fill(X, Y);
                    mapPanel.repaint();
                    mapPanel.numMap_P2();
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            tileLocationX = -1;
            tileLocationY = -1;
            mapPanel.numMap_P2();
            mapPanel.storeState();
            mapPanel.pointStart.x = 0;
            mapPanel.pointStart.y = 0;
            mapPanel.pointEnd.x = 0;
            mapPanel.pointEnd.y = 0;
            mapPanel.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int X = (int) (e.getX() / mapPanel.zoomScale);
        int Y = (int) (e.getY() / mapPanel.zoomScale);
        if (e.isControlDown() && e.isShiftDown()) {
            // Ctrl + shift + drag = move scroll bars (map)
            if (e.getX() > pressedX) // left
                mapPanel.mapScroll.getHorizontalScrollBar().setValue(mapPanel.mapScroll.getHorizontalScrollBar().getValue() - Math.abs(pressedX - e.getX()));
            if (e.getX() < pressedX) // right
                mapPanel.mapScroll.getHorizontalScrollBar().setValue(mapPanel.mapScroll.getHorizontalScrollBar().getValue() + Math.abs(pressedX - e.getX()));
            if (e.getY() > pressedY) // up
                mapPanel.mapScroll.getVerticalScrollBar().setValue(mapPanel.mapScroll.getVerticalScrollBar().getValue() - Math.abs(pressedY - e.getY()));
            if (e.getY() < pressedY) // down
                mapPanel.mapScroll.getVerticalScrollBar().setValue(mapPanel.mapScroll.getVerticalScrollBar().getValue() + Math.abs(pressedY - e.getY()));
       } else if (e.isControlDown() || e.isShiftDown()) {
            // if Ctrl or shift held but not both then don't draw
            tileLocationX = -1;
            tileLocationY = -1;
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            if (Tools.selectedTool.equals("Pen")) {
                place_1(X, Y);
            } else if (Tools.selectedTool.equals("Rectangle")) {
                mapPanel.pointEnd.x = X;
                mapPanel.pointEnd.y = Y;
                mapPanel.repaint();
            }
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        boolean zoomed = false;

        int scrollingDirection = e.getWheelRotation();
        // zoom out // scroll towards
        if (scrollingDirection == 1) {
            if (e.isControlDown()) {
                // checks if zooming out would be in limit
                if (mapPanel.mapScroll.getHeight() < mapPanel.getPreferredSize().getHeight() + 150 || mapPanel.mapScroll.getWidth() < mapPanel.getPreferredSize().getWidth() + 150) {
                    mapPanel.zoom /= 1.1;
                    zoomed = true;
                }
            }
            else if (!e.isShiftDown())
                mapPanel.mapScroll.getVerticalScrollBar().setValue((int) (mapPanel.mapScroll.getVerticalScrollBar().getValue() + mapPanel.zoomScale / 2));    // right
            else
                mapPanel.mapScroll.getHorizontalScrollBar().setValue((int) (mapPanel.mapScroll.getHorizontalScrollBar().getValue() + mapPanel.zoomScale / 2));    // down
        }
        // zoom in // scroll away
        else if (scrollingDirection == -1) {
            if (e.isControlDown()) {
                // checks if zooming in would be in limit
                if (mapPanel.zoom * 1.1 < 25000) { // 1000 ~ 10 times zoom
                    mapPanel.zoom = mapPanel.zoom * 1.1;
                    zoomed = true;
                }
            }
            else if (!e.isShiftDown())
                mapPanel.mapScroll.getVerticalScrollBar().setValue((int) (mapPanel.mapScroll.getVerticalScrollBar().getValue() - mapPanel.zoomScale / 2));   // left
            else
                mapPanel.mapScroll.getHorizontalScrollBar().setValue((int) (mapPanel.mapScroll.getHorizontalScrollBar().getValue() - mapPanel.zoomScale / 2));    // up
        }
        // if you zoomed then update alignPort and revalidate
        if (zoomed) {
            mapPanel.zoomScale = (float) (mapPanel.zoom / 100f);
            mapPanel.alignViewPort(e.getPoint());
            mapPanel.revalidate();
            mapPanel.mapScroll.repaint();
        }
    }

    void place_1(int X, int Y) {
        switch (mapPanel.layers.selectedLayer) {
            case "Layer 1":
                if (mapPanel.L1_mapTileCoordinate[X][Y] != mapPanel.tileBar.tileValue)
                    place_2(X, Y);
                break;
            case "Layer 2":
                if (mapPanel.L2_mapTileCoordinate[X][Y] != mapPanel.tileBar.tileValue)
                    place_2(X, Y);
                break;
            case "Layer 3":
                if (mapPanel.L3_mapTileCoordinate[X][Y] != mapPanel.tileBar.tileValue)
                    place_2(X, Y);
                break;
            case "Layer 4":
                if (mapPanel.L4_mapTileCoordinate[X][Y] != mapPanel.tileBar.tileValue)
                    place_2(X, Y);
                break;
        }
    }

    void place_2(int X, int Y) {
        tileLocationX = X;
        tileLocationY = Y;
        mapPanel.numMap_P1(tileLocationX, tileLocationY);
        mapPanel.repaint();
    }
}