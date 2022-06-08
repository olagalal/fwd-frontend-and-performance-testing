package controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class InvoicesLineTableListener implements ListSelectionListener {

    private GUI view = null;

    public InvoicesLineTableListener(GUI view) {
        this.view = view;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //Dected the latest change
        if (!e.getValueIsAdjusting()) {
            if (view.getInvoicesLineTable().getSelectedRow() >= 0) {
                view.getDeleteItemButton().setEnabled(true);
            } else {
                view.getDeleteItemButton().setEnabled(false);
            }
        }
    }
}
