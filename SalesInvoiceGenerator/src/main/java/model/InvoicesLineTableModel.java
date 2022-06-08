package model;

import javax.swing.table.DefaultTableModel;

import view.GUI;

/**
 *
 * @author Ola Galal
 */
public class InvoicesLineTableModel {

    public static DefaultTableModel setInvoicesLineTableModel(GUI gui) {
        DefaultTableModel newTable = new DefaultTableModel() {};
        newTable = (DefaultTableModel) gui.getInvoicesLineTable().getModel();
        gui.getInvoicesLineTable().setDefaultEditor(Object.class, null);
        return newTable;
    }
}
