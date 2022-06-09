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

    private InvoiceTableListener invoiceTableListener;
    private InvoicesLineTableListener invoicesLineTableListener;
    private FileMenuItemsListener fileMenuItemsListener;
    private MainFrameWindowListener mainFrameWindowListener;
    private MainFrameMouseMotionListener mainFrameMouseMotionListener;
    private AddItemDialogWindowListener addItemDialogWindowListener;
    private InvoiceDateTextFieldListener invoiceDateTextFieldListener;
    private CustomerNameTextFieldListener customerNameTextFieldListener;

    public Controller(InvoiceHeader invoiceHeader, InvoiceLine invoiceLine, GUI gui) {
        this.invoiceHeader = invoiceHeader;
        this.invoiceLine = invoiceLine;
        this.gui = gui;
        fileOperations = new FileOperations(this.gui);

        invoicesLineTableListener = new InvoicesLineTableListener(gui);
        invoiceTableListener = new InvoiceTableListener(gui, fileOperations, invoicesLineTableListener);

        fileMenuItemsListener = new FileMenuItemsListener(gui, fileOperations, invoiceTableListener);
        mainFrameWindowListener = new MainFrameWindowListener(gui, fileOperations, invoiceTableListener);

        addItemDialogWindowListener = new AddItemDialogWindowListener(gui);
        mainFrameMouseMotionListener = new MainFrameMouseMotionListener(gui);

        invoiceDateTextFieldListener = new InvoiceDateTextFieldListener(gui);
        customerNameTextFieldListener = new CustomerNameTextFieldListener(gui);

        turnOnAllActionListerners(gui);

        loadTablesContents = new TablesController();
        
    }

    private void turnOnAllActionListerners(GUI gui) {
        gui.getLoadFile().addActionListener(fileMenuItemsListener);
        gui.getLoadFile().setActionCommand("Load Files");

        gui.getSaveFile().addActionListener(fileMenuItemsListener);
        gui.getSaveFile().setActionCommand("Save File");

        gui.getQuit().addActionListener(fileMenuItemsListener);
        gui.getQuit().setActionCommand("Quit");

        gui.getFileMenu().addMenuListener(fileMenuItemsListener);
        gui.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);
        gui.getInvoicesLineTable().getSelectionModel().addListSelectionListener(invoicesLineTableListener);

        gui.addWindowListener(mainFrameWindowListener);

        GUI.getAddItemDialog().addWindowListener(addItemDialogWindowListener);

        gui.getInvoiceDateTextField().addActionListener(invoiceDateTextFieldListener);
        gui.getInvoiceDateTextField().addFocusListener(invoiceDateTextFieldListener);

        gui.getCustomerNameTextField().addActionListener(customerNameTextFieldListener);
        gui.getCustomerNameTextField().addFocusListener(customerNameTextFieldListener);

        gui.getRootPane().addMouseMotionListener(mainFrameMouseMotionListener);

        gui.getCreatNewInvoiceButton().addActionListener(this);
        gui.getCreatNewInvoiceButton().setActionCommand("Creat New Invoice");

        gui.getCreatNewInvoiceOK().addActionListener(this);
        gui.getCreatNewInvoiceOK().setActionCommand("Creat New Invoice OK");

        gui.getCreatNewInvoiceCancel().addActionListener(this);
        gui.getCreatNewInvoiceCancel().setActionCommand("Creat New Invoice Cancel");

        gui.getDeleteInvoiceButton().addActionListener(this);
        gui.getDeleteInvoiceButton().setActionCommand("Delete Invoice");

        gui.getAddItemButton().addActionListener(this);
        gui.getAddItemButton().setActionCommand("Add Item");

        gui.getCancelButton().addActionListener(this);
        gui.getCancelButton().setActionCommand("Save Items");

        gui.getNewItemPrice().addKeyListener(this);
        gui.getAddItemDialogCancel().addActionListener(this);
        gui.getAddItemDialogCancel().setActionCommand("Add Item Dialog Cancel");

        gui.getAddItemDialogOK().addActionListener(this);
        gui.getAddItemDialogOK().setActionCommand("Add Item Dialog OK");

        gui.getDeleteItemButton().addActionListener(this);
        gui.getDeleteItemButton().setActionCommand("Delete Item");

        gui.getCancelButton().addActionListener(this);
        gui.getCancelButton().setActionCommand("Cancel Any Changes");
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
                    gui.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTableListener);
                    InvoicesHeaderController.addNewInvoice(gui, invoices);
                    gui.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);
                    
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
                    gui.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTableListener);
                    InvoicesHeaderController.deleteSelectedInvoice(gui, invoices);
                    gui.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);

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
                    gui.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTableListener);
                    Controller.invoices = fileOperations.readFile();
                    InvoicesHeaderController.calculateInvoiceTableTotal(Controller.invoices);
                    TablesController.loadInvoicesHeaderTable(gui, Controller.invoices);
                    Controller.isThereIsNotSavedEdit = false;
                    gui.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);
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
                    gui.getInvoiceTable().getSelectionModel().removeListSelectionListener(invoiceTableListener);
                    invoices = fileOperations.readFile();
                    InvoicesHeaderController.calculateInvoiceTableTotal(invoices);
                    TablesController.loadInvoicesHeaderTable(gui, invoices);

                    maxNumberOfExistedInvoices = 0;
                    fileOperations.getMaxNumberOfExistedInvoices(maxNumberOfExistedInvoices, invoices);

                    isThereIsNotSavedEdit = false;
                    gui.getInvoiceTable().getSelectionModel().addListSelectionListener(invoiceTableListener);

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
