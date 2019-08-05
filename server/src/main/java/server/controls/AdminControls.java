package server.controls;

import java.awt.event.*;
import javax.swing.*;

import server.gui.*;

import server.gui.*;

public class AdminControls {
    private JPanel adminPanel;
    private ServerUI serverUI;

    public AdminControls(AdminPanel adminPanel,  ServerUI serverUI) {
        this.adminPanel = adminPanel;
        this.serverUI = serverUI;

    }





    class PopUpMenu extends JPopupMenu {
        JMenuItem newItem;
        JMenuItem editItem;
        JMenuItem deleteItem;

        public PopUpMenu() {
            newItem = new JMenuItem("Nouveau");
            add(newItem);

            editItem = new JMenuItem("Modifier");
            add(editItem);

            deleteItem = new JMenuItem("Supprimer");
            add(deleteItem);
        }
    }

class PopClickListener extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);
    }

    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger())
            doPop(e);
    }

    private void doPop(MouseEvent e) {
            PopUpMenu menu = new PopUpMenu();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
}