package controller;

import static controller.Controller.isThereIsNotSavedEdit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.*;
import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class FileMenuItemsListener implements ActionListener, MenuListener {

    private FileOperations fileOperations;
    private InvoiceTableListener invoiceTableListener;
    private GUI gui;

    public FileMenuItemsListener(GUI gui, FileOperations fileOperations, InvoiceTableListener invoiceTableListener) {
        this.gui = gui;
        this.fileOperations = fileOperations;
        this.invoiceTableListener = invoiceTableListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load Files" -> {
                Controller.isThereIsNotSavedEdit = false;

                while (InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).getRowCount() > 0) {
                    InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).removeRow(0);
                }

                while (InvoicesLineTableModel.setInvoicesLineTableModel(gui).getRowCount() > 0) {
                    InvoicesLineTableModel.setInvoicesLineTableModel(gui).removeRow(0);
                }

                gui.getInvoiceTotalLabel().setText("");
                fileOperations.getFilesPaths();
                if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
                    Controller.invoices = fileOperations.readFile();
                    fileOperations.main(Controller.invoices);
                    InvoicesHeaderController.calculateInvoiceTableTotal(Controller.invoices);
                    TablesController.loadInvoicesHeaderTable(gui, Controller.invoices);
                    fileOperations.getMaxNumberOfExistedInvoices(Controller.maxNumberOfExistedInvoices, Controller.invoices);
                }
            }
            case "Save File" -> {
                try {
                    fileOperations.writeFile(Controller.invoices);
                    gui.loadFiles();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            case "Quit" -> {
                System.exit(0);
            }
        }
    }

    @Override
    public void menuSelected(MenuEvent e) {
        if (Controller.isThereIsNotSavedEdit) {
            gui.getSaveFile().setEnabled(true);
        } else {
            gui.getSaveFile().setEnabled(false);
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {
    }

    @Override
    public void menuCanceled(MenuEvent e) {
    }

}
