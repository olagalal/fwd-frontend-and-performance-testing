package controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import view.GUI;
import model.FileOperations;

/**
 *
 * @author Ola Galal
 */
public class MainFrameWindowListener implements WindowListener {

    private FileOperations fileOperations;
    private InvoiceTableListener invoiceTableListener;
    private GUI gui = null;

    public MainFrameWindowListener(GUI gui, FileOperations fileOperations, InvoiceTableListener invoiceTableListener) {
        this.gui = gui;
        this.fileOperations = fileOperations;
        this.invoiceTableListener = invoiceTableListener;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int option;
        if (Controller.isThereIsNotSavedEdit) {
            option = gui.showSaveDontSaveCancelDialog(gui, "Do You Want To Save Changes?", "Exit");
            if (option == 1) {
                System.exit(0);
            } else if (option == 0) {
                gui.setVisible(false);
                try {
                    fileOperations.writeFile(Controller.invoices);
                } catch (IOException ex) {
                    Logger.getLogger(MainFrameWindowListener.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            } else {
            }
        } else {
            System.exit(0);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
            gui.getCreatNewInvoiceButton().setEnabled(true);
        } else {
            gui.getCreatNewInvoiceButton().setEnabled(false);
            gui.getDeleteInvoiceButton().setEnabled(false);
            gui.getInvoiceTotalLabel().setText("");
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
            gui.getCreatNewInvoiceButton().setEnabled(true);
        } else {
            gui.getCreatNewInvoiceButton().setEnabled(false);
            gui.getDeleteInvoiceButton().setEnabled(false);
            gui.getInvoiceTotalLabel().setText("");
        }
    }

}
