package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;

import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLine;
import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class Controller implements ActionListener, KeyListener {

    private InvoiceHeader invoiceHeader;
    private InvoiceLine invoiceLine;
    private GUI gui;
    private FileOperations fileOperations;
    private TablesController loadTablesContents;

    public volatile static ArrayList<InvoiceHeader> invoices = new ArrayList<>();
    public volatile static int selectedRow = 0;
    public volatile static boolean isThereIsNotSavedEdit = false;
    public volatile static int maxNumberOfExistedInvoices = 0;

    public Controller(InvoiceHeader invoiceHeader, InvoiceLine invoiceLine, GUI gui) {
        this.invoiceHeader = invoiceHeader;
        this.invoiceLine = invoiceLine;
        this.gui = gui;
        fileOperations = new FileOperations(this.gui);

        loadTablesContents = new TablesController();
        
    }

    /**
     *
     * Implement All Listeners
     *
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Creat New Invoice" -> {
                if (gui.getFocusOwner() != null) {
                    InvoicesHeaderController.showCreatNewInvoiceDialog(gui);
                }
            }

            case "Creat New Invoice OK" -> {
                try {
                    InvoicesHeaderController.addNewInvoice(gui, invoices);
                    gui.getCancelButton().setEnabled(isThereIsNotSavedEdit);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }

            case "Creat New Invoice Cancel" -> {
                gui.getNewCustomerName().setText("");
                GUI.getNewInvoiceDialog().setVisible(false);
            }

            case "Delete Invoice" -> {
                if (gui.getFocusOwner() != null) {
                    InvoicesHeaderController.deleteSelectedInvoice(gui, invoices);

                    gui.getCancelButton().setEnabled(isThereIsNotSavedEdit);
                }
            }

            case "Add Item" -> {
                if (gui.getFocusOwner() != null) {
                    InvoicesLineController.showNewItemDialog(gui);
                }
            }

            case "Save Items" -> {
                try {
                    fileOperations.writeFile(Controller.invoices);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (FileOperations.selectedInvoiceHeader != null && FileOperations.selectedInvoiceLine != null) {
                    Controller.invoices = fileOperations.readFile();
                    InvoicesHeaderController.calculateInvoiceTableTotal(Controller.invoices);
                    TablesController.loadInvoicesHeaderTable(gui, Controller.invoices);
                    Controller.isThereIsNotSavedEdit = false;
                    if (Controller.invoices.size() >= 1) {
                        gui.getInvoiceTable().setRowSelectionInterval(0, 0);
                    }
                }
                if (Controller.isThereIsNotSavedEdit) {
                    gui.getCancelButton().setEnabled(Controller.isThereIsNotSavedEdit);
                } else {
                    gui.getCancelButton().setEnabled(Controller.isThereIsNotSavedEdit);
                }
            }

            case "Add Item Dialog OK" -> {
                InvoicesLineController.addNewItem(gui, invoices);
                InvoicesHeaderController.calculateInvoiceTableTotal(invoices);
                InvoicesHeaderController.updateTableTotal(gui, invoices);
                InvoicesLineController.updater(gui, invoices, selectedRow);
                TablesController.loadInvoicesLineTable(gui, invoices);

                int sizeOfinvoicesLinesForTheSelectedInvoice = invoices.get(gui.getInvoiceTable().getSelectedRow()).getInvoicerow().size();
                gui.getInvoicesLineTable().setRowSelectionInterval((sizeOfinvoicesLinesForTheSelectedInvoice - 1), (sizeOfinvoicesLinesForTheSelectedInvoice - 1));
                GUI.getAddItemDialog().setVisible(false);

                gui.getCancelButton().setEnabled(isThereIsNotSavedEdit);
            }

            case "Add Item Dialog Cancel" -> {
                GUI.getAddItemDialog().setVisible(false);
                gui.getNewItemName().setText("");
                gui.getNewItemPrice().setText("");
                gui.getNewItemPriceSpinner().setValue((Object) 1);
            }

            case "Delete Item" -> {
                if (gui.getFocusOwner() != null) {
                    InvoicesLineController.deleteItem(gui, invoices);
                    InvoicesHeaderController.calculateInvoiceTableTotal(invoices);
                    InvoicesHeaderController.updateTableTotal(gui, invoices);
                    InvoicesLineController.updater(gui, invoices, selectedRow);
                    TablesController.loadInvoicesLineTable(gui, invoices);

                    int sizeOfinvoicesLinesForTheSelectedInvoice = invoices.get(gui.getInvoiceTable().getSelectedRow()).getInvoicerow().size();

                    if (sizeOfinvoicesLinesForTheSelectedInvoice > 0) {
                        gui.getInvoicesLineTable().setRowSelectionInterval((sizeOfinvoicesLinesForTheSelectedInvoice - 1), (sizeOfinvoicesLinesForTheSelectedInvoice - 1));
                    }

                    gui.getCancelButton().setEnabled(isThereIsNotSavedEdit);
                }
            }

            case "Cancel Any Changes" -> {
                if ((FileOperations.selectedInvoiceHeader != null) && (FileOperations.selectedInvoiceLine != null)) {
                    invoices = fileOperations.readFile();
                    InvoicesHeaderController.calculateInvoiceTableTotal(invoices);
                    TablesController.loadInvoicesHeaderTable(gui, invoices);

                    maxNumberOfExistedInvoices = 0;

                    isThereIsNotSavedEdit = false;

                    if (invoices.size() >= 1) {
                        gui.getInvoiceTable().setRowSelectionInterval(0, 0);
                    }
                }

                gui.getCancelButton().setEnabled(isThereIsNotSavedEdit);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent evnt) {
        char price = evnt.getKeyChar();
        if (Character.isLetter(price) && !evnt.isAltDown() && evnt.isShiftDown() && evnt.isControlDown()) {
            evnt.consume();
        }
        
        if ((price == 'f') || (price == 'd')) {
            evnt.consume();
        }
        
        try {
            Float.parseFloat(gui.getNewItemPrice().getText() + price);
        } catch (NumberFormatException e) {
            evnt.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
