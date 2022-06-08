package controller;

import java.util.ArrayList;

import model.*;
import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class TablesController {

    public static void loadInvoicesHeaderTable(GUI gui, ArrayList<InvoiceHeader> invoices) {
        
        while (InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).getRowCount() > 0)
            InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).removeRow(0);
        
        Object data[] = new Object[4];
        for (int i = 0; i < invoices.size(); i++) {
            data[0] = invoices.get(i).getInoviceNumber();
            data[1] = invoices.get(i).getInoviceDate();
            data[2] = invoices.get(i).getInoviceCustomerName();
            data[3] = invoices.get(i).getInoviceTotal();
            InvoicesHeaderTableModel.setInvoicesHeaderTableModel(gui).addRow(data);
        }
    }

    public static void loadInvoicesLineTable(GUI gui, ArrayList<InvoiceHeader> invoices) {
        float total;
        Object data[] = new Object[5];
        int selectedRow = gui.getInvoiceTable().getSelectedRow();

        if (selectedRow == -1) {
            InvoicesLineController.disable(gui);
            
            while (InvoicesLineTableModel.setInvoicesLineTableModel(gui).getRowCount() > 0)
                InvoicesLineTableModel.setInvoicesLineTableModel(gui).removeRow(0);
            gui.getDeleteInvoiceButton().setEnabled(false);
        
        } else {
            InvoicesLineController.enable(gui);
            gui.getDeleteInvoiceButton().setEnabled(true);
            
            while (InvoicesLineTableModel.setInvoicesLineTableModel(gui).getRowCount() > 0) {
                InvoicesLineTableModel.setInvoicesLineTableModel(gui).removeRow(0);
            }
            
            InvoicesLineTableModel.setInvoicesLineTableModel(gui).setRowCount(0);
            for (int j = 0; j < invoices.get(selectedRow).getInvoicerow().size(); j++) {
                total = ((invoices.get(selectedRow).getInvoicerow().get(j).getItemPrice()) * (invoices.get(selectedRow).getInvoicerow().get(j).getItemCount()));
                invoices.get(selectedRow).getInvoicerow().get(j).setItemTotal(total);
                data[0] = invoices.get(selectedRow).getInvoicerow().get(j).getMainInvoice().getInoviceNumber();
                data[1] = invoices.get(selectedRow).getInvoicerow().get(j).getItemName();
                data[2] = invoices.get(selectedRow).getInvoicerow().get(j).getItemPrice();
                data[3] = invoices.get(selectedRow).getInvoicerow().get(j).getItemCount();
                data[4] = invoices.get(selectedRow).getInvoicerow().get(j).getItemTotal();
                InvoicesLineTableModel.setInvoicesLineTableModel(gui).addRow(data);
                InvoicesLineController.updater(gui, invoices, selectedRow);
            }
        }
    }
}
