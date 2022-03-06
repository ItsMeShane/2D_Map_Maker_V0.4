package input;

import main.MapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    boolean P_CTRL;
    boolean P_Z;
    boolean P_SHIFT;

    boolean moveCursor = false;
    MapPanel mapPanel;
    public KeyInput(MapPanel mapPanel) {
        this.mapPanel = mapPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            if (JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0) == JOptionPane.YES_OPTION)
                System.exit(0);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int interactedKey = e.getKeyCode();

        if (interactedKey == KeyEvent.VK_CONTROL) P_CTRL = true;
        if (interactedKey == KeyEvent.VK_Z) P_Z = true;
        if (interactedKey == KeyEvent.VK_SHIFT) P_SHIFT = true;

        if (P_CTRL && P_Z && mapPanel.undo.size() > 1) {
            mapPanel.undo.pop();
            mapPanel.tileBarSettings.options.loadMap(mapPanel.undo.peek());
        }

        if (e.isShiftDown() && e.isControlDown())
            moveCursor = true;

        applyCursor();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int interactedKey = e.getKeyCode();

        if (interactedKey == KeyEvent.VK_CONTROL) P_CTRL = false;
        if (interactedKey == KeyEvent.VK_Z) P_Z = false;
        if (interactedKey == KeyEvent.VK_SHIFT) P_SHIFT = false;

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            if (JOptionPane.showOptionDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0) == JOptionPane.YES_OPTION)
                System.exit(0);

        if (!e.isShiftDown() || !e.isControlDown())
            moveCursor = false;

        applyCursor();
    }

    void applyCursor() {
        mapPanel.setCursor(moveCursor ? new Cursor(Cursor.MOVE_CURSOR) : new Cursor(Cursor.DEFAULT_CURSOR));
    }
}