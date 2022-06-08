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
    private GUI view = null;

    public MainFrameWindowListener(GUI view, FileOperations fileOperations, InvoiceTableListener invoiceTableListener) {
        this.view = view;
        this.fileOperations = fileOperations;
        this.invoiceTableListener = invoiceTableListener;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int option;
        if (Controller.isThereIsNotSavedEdit) {
            option = view.showSaveDontSaveCancelDialog(view, "Do You Want To Save Changes?", "Exit");
            if (option == 1) {
                System.exit(0);
            } else if (option == 0) {
                view.setVisible(false);
                try {
                    saveFile();
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

    void saveFile() throws IOException {
        //Write the invoices arraylist
        fileOperations.writeFile(Controller.invoices);
        //Reload CSV files into tables
        if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
            view.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTableListener);
            Controller.invoices = fileOperations.readFile();
            InvoicesHeaderController.calculateInvoiceTableTotal(Controller.invoices);
            TablesController.loadInvoicesHeaderTable(view, Controller.invoices);
            Controller.isThereIsNotSavedEdit = false;
            view.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);
            if (Controller.invoices.size() >= 1) {
                view.getInvoiceTable().setRowSelectionInterval(0, 0);
            }
        }
        if (Controller.isThereIsNotSavedEdit) {
            view.getCancelButton().setEnabled(Controller.isThereIsNotSavedEdit);
        } else {
            view.getCancelButton().setEnabled(Controller.isThereIsNotSavedEdit);
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
            view.getCreatNewInvoiceButton().setEnabled(true);
        } else {
            view.getCreatNewInvoiceButton().setEnabled(false);
            view.getDeleteInvoiceButton().setEnabled(false);
            view.getInvoiceTotalLabel().setText("");
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
            view.getCreatNewInvoiceButton().setEnabled(true);
        } else {
            view.getCreatNewInvoiceButton().setEnabled(false);
            view.getDeleteInvoiceButton().setEnabled(false);
            view.getInvoiceTotalLabel().setText("");
        }
    }

}
