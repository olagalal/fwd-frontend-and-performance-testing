package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;
import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class InvoicesHeaderController {

    TablesController loadTablesContents = new TablesController();

    static void updateTableDate(GUI gui, ArrayList<InvoiceHeader> invoices) {
        InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui)
                .setValueAt(invoices.get(gui.getInvoiceTable().getSelectedRow()).getInoviceDate(), gui.getInvoiceTable().getSelectedRow(), 1);
    }

    static void updateTableCustomerName(GUI gui, ArrayList<InvoiceHeader> invoices) {
        InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui)
                .setValueAt(invoices.get(gui.getInvoiceTable().getSelectedRow()).getInoviceCustomerName(), gui.getInvoiceTable().getSelectedRow(), 2);
    }

    static void updateTableTotal(GUI gui, ArrayList<InvoiceHeader> invoices) {
        InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui)
                .setValueAt(invoices.get(gui.getInvoiceTable().getSelectedRow()).getInoviceTotal(), gui.getInvoiceTable().getSelectedRow(), 3);
    }

    static void showCreatNewInvoiceDialog(GUI gui) {
        gui.setLocations();
        gui.getNewInvoiceDateField().setText("");
        GUI.getNewInvoiceDialog().setVisible(true);
    }

    static void addNewInvoice(GUI gui, ArrayList<InvoiceHeader> invoices) {
        if (gui.getNewCustomerName().getText().equalsIgnoreCase("")) {
            GUI.getNewInvoiceDialog().setModal(false);
            GUI.setJOptionPaneMessagMessage(gui.getInvoicesTablePanel(), "Please Enter A Name For The Customer", "Empty Name Entered", "ERROR_MESSAGE");
            GUI.getNewInvoiceDialog().setModal(true);
            showCreatNewInvoiceDialog(gui);
        } else {
            try {
                Controller.maxNumberOfExistedInvoices++;

                InvoiceHeader newRow = new InvoiceHeader((Controller.maxNumberOfExistedInvoices), (gui.getDate().parse(gui.getNewInvoiceDateField().getText())), (gui.getNewCustomerName().getText()));
                invoices.add(newRow);
                TablesController.loadInvoicesHeaderTable(gui, invoices);
                GUI.getNewInvoiceDialog().setVisible(false);
                gui.getInvoiceTable().setRowSelectionInterval((invoices.size() - 1), (invoices.size() - 1));
                gui.getNewCustomerName().setText("");
                gui.getNewInvoiceDateField().setText("");
                InvoicesLineController.updater(gui, invoices, invoices.size() - 1);
                TablesController.loadInvoicesLineTable(gui, invoices);
            } catch (ParseException ex) {
                GUI.getNewInvoiceDialog().setModal(false);
                GUI.setJOptionPaneMessagMessage(gui.getInvoicesTablePanel(), "Please Enter A Valid Date", "Invalid Date Entered", "ERROR_MESSAGE");
                GUI.getNewInvoiceDialog().setModal(true);
                showCreatNewInvoiceDialog(gui);
            }

        }
    }

    static void deleteSelectedInvoice(GUI gui, ArrayList<InvoiceHeader> invoices) {
        int invoiceToBeDeleted = gui.getInvoiceTable().getSelectedRow();

        if (invoiceToBeDeleted == -1) {
            GUI.setJOptionPaneMessagMessage(gui.getInvoicesTablePanel(), "Select Invoice Row First", "Error", "ERROR_MESSAGE");
        } else {
            invoices.remove(invoiceToBeDeleted);
            TablesController.loadInvoicesHeaderTable(gui, invoices);
            if (!invoices.isEmpty()) {
                gui.getInvoiceTable().setRowSelectionInterval((invoices.size() - 1), (invoices.size() - 1));
                InvoicesLineController.updater(gui, invoices, invoices.size() - 1);
                TablesController.loadInvoicesLineTable(gui, invoices);
            } else {
                while (InvoicesLineTableModel.setInvoicesLineTableModel(gui).getRowCount() > 0) {
                    InvoicesLineTableModel.setInvoicesLineTableModel(gui).removeRow(0);
                }
            }
        }
    }

    public static void calculateInvoiceTableTotal(ArrayList<InvoiceHeader> invoices) {
        float total;
        for (int i = 0; i < invoices.size(); i++) {
            total = 0;
            for (int j = 0; j < invoices.get(i).getInvoicerow().size(); j++) {
                total = total + ((invoices.get(i).getInvoicerow().get(j).getItemPrice()) * (invoices.get(i).getInvoicerow().get(j).getItemCount()));
            }
            invoices.get(i).setInoviceTotal(total);
        }
    }
}
