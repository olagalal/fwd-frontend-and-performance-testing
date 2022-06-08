package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import model.FileOperations;
import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class MainFrameMouseMotionListener implements MouseMotionListener {

    private GUI view = null;

    public MainFrameMouseMotionListener(GUI view) {
        this.view = view;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
            view.getCreatNewInvoiceButton().setEnabled(true);
        } else {
            view.getCreatNewInvoiceButton().setEnabled(false);
            view.getDeleteInvoiceButton().setEnabled(false);
            view.getInvoiceTotalLabel().setText("");
        }
        if ((Controller.invoices.isEmpty()) || (view.getInvoiceTable().getSelectedRow() < 0)) {
            view.getDeleteInvoiceButton().setEnabled(false);
        } else {
            view.getDeleteInvoiceButton().setEnabled(true);
        }
        if (Controller.isThereIsNotSavedEdit) {
            view.getCancelButton().setEnabled(Controller.isThereIsNotSavedEdit);
        } else {
            view.getCancelButton().setEnabled(Controller.isThereIsNotSavedEdit);
        }
    }

}
