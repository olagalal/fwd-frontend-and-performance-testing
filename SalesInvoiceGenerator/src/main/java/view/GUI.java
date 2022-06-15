package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Ola Galal
 */
import java.awt.*;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.FileOperations;
import model.InvoiceHeader;
import model.InvoicesHeaderTableModel;
import model.InvoicesLineTableModel;
import controller.*;

public class GUI extends JFrame {

    javax.swing.JFileChooser chooser;
    javax.swing.JOptionPane jOptionPaneMessage;
    private SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    private FileOperations fileOperations = new FileOperations(this);

    public GUI() {
        initComponents();

        CreatNewInvoiceButton.setEnabled(false);
        DeleteInvoiceButton.setEnabled(false);
        AddItemButton.setEnabled(false);
        DeleteItemButton.setEnabled(false);

        chooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        chooser.setFileFilter(filter);

        jOptionPaneMessage = new JOptionPane();

        CustomerNameTextField.setName("CustomerNameTextField");
        InvoiceDateTextField.setName("InvoiceDateTextField");
        InvoicesLineTable.setName("InvoicesLineTable");
        InvoiceTable.setName("InvoiceTable");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreatNewInvoiceDialog = new javax.swing.JDialog();
        NewCustomerName = new javax.swing.JTextField();
        NewCustomerNameLabel = new javax.swing.JLabel();
        NewInvoiceDateField = new javax.swing.JTextField();
        NewInvoiceDateLabel = new javax.swing.JLabel();
        CreatNewInvoiceOK = new javax.swing.JButton();
        CreatNewInvoiceCancel = new javax.swing.JButton();
        AddItemDialog = new javax.swing.JDialog();
        NewItemName = new javax.swing.JTextField();
        NewItemNameLabel = new javax.swing.JLabel();
        NewItemPriceLabel = new javax.swing.JLabel();
        AddItemDialogOK = new javax.swing.JButton();
        AddItemDialogCancel = new javax.swing.JButton();
        NewItemPrice = new javax.swing.JTextField();
        NewItemPriceSpinner = new javax.swing.JSpinner();
        NewItemCountLabel = new javax.swing.JLabel();
        InvoicesTablePanel = new javax.swing.JPanel();
        InvoicesTableLabel = new javax.swing.JLabel();
        CreatNewInvoiceButton = new javax.swing.JButton();
        DeleteInvoiceButton = new javax.swing.JButton();
        InvoiceTableScrollPane = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoicesItemsPanel = new javax.swing.JPanel();
        InvoiceNumberStaticLabel = new javax.swing.JLabel();
        InvoiceNumberLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        CustomerNameLabel = new javax.swing.JLabel();
        InvoiceTotalStaticLabel = new javax.swing.JLabel();
        InvoicesItemsLabel = new javax.swing.JLabel();
        InvoiceDateTextField = new javax.swing.JTextField();
        CustomerNameTextField = new javax.swing.JTextField();
        InvoiceTotalLabel = new javax.swing.JLabel();
        InvoicesLineTableScrollPane = new javax.swing.JScrollPane();
        InvoicesLineTable = new javax.swing.JTable();
        DeleteItemButton = new javax.swing.JButton();
        AddItemButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        LoadFile = new javax.swing.JMenuItem();
        SaveFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Quit = new javax.swing.JMenuItem();

        CreatNewInvoiceDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        CreatNewInvoiceDialog.setTitle("Creat New Invoice");
        CreatNewInvoiceDialog.setBounds(new java.awt.Rectangle(100, 100, 100, 100));
        CreatNewInvoiceDialog.setMinimumSize(new java.awt.Dimension(400, 200));
        CreatNewInvoiceDialog.setModal(true);
        CreatNewInvoiceDialog.setSize(new java.awt.Dimension(100, 100));
        //Point p=InvoicesTablePanel.getLocationOnScreen();
        //CreatNewInvoiceDialog.setLocation(p.x+10,p.y+10);
        //CreatNewInvoiceDialog.setLocationRelativeTo(InvoiceTable);

        NewCustomerNameLabel.setText("Customer Name:");

        NewInvoiceDateField.setEditable(false);

        NewInvoiceDateLabel.setText("Invoice Date:");

        CreatNewInvoiceOK.setText("OK");

        CreatNewInvoiceCancel.setText("Cancel");

        javax.swing.GroupLayout CreatNewInvoiceDialogLayout = new javax.swing.GroupLayout(CreatNewInvoiceDialog.getContentPane());
        CreatNewInvoiceDialog.getContentPane().setLayout(CreatNewInvoiceDialogLayout);
        CreatNewInvoiceDialogLayout.setHorizontalGroup(
            CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatNewInvoiceDialogLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(CreatNewInvoiceOK, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(CreatNewInvoiceCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreatNewInvoiceDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewCustomerNameLabel)
                    .addComponent(NewInvoiceDateLabel))
                .addGap(35, 35, 35)
                .addGroup(CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NewInvoiceDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(NewCustomerName))
                .addGap(45, 45, 45))
        );
        CreatNewInvoiceDialogLayout.setVerticalGroup(
            CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatNewInvoiceDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewCustomerNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewInvoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewInvoiceDateLabel))
                .addGap(26, 26, 26)
                .addGroup(CreatNewInvoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatNewInvoiceOK)
                    .addComponent(CreatNewInvoiceCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InvoicesTableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        CreatNewInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        DeleteInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));

        AddItemDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        AddItemDialog.setTitle("Add New Item To Invoice Number ");
        AddItemDialog.setAlwaysOnTop(false);
        AddItemDialog.setBounds(new java.awt.Rectangle(100, 100, 100, 100));
        AddItemDialog.setLocation(new java.awt.Point(600, 250));
        AddItemDialog.setMinimumSize(new java.awt.Dimension(400, 200));
        AddItemDialog.setModal(true);
        AddItemDialog.setSize(new java.awt.Dimension(100, 100));

        NewItemNameLabel.setText("Item Name:");

        NewItemPriceLabel.setText("Item Price:");

        AddItemDialogOK.setText("OK");

        AddItemDialogCancel.setText("Cancel");

        NewItemPriceSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));

        NewItemCountLabel.setText("Item Count:");

        javax.swing.GroupLayout AddItemDialogLayout = new javax.swing.GroupLayout(AddItemDialog.getContentPane());
        AddItemDialog.getContentPane().setLayout(AddItemDialogLayout);
        AddItemDialogLayout.setHorizontalGroup(
            AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemDialogLayout.createSequentialGroup()
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddItemDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewItemNameLabel)
                            .addComponent(NewItemPriceLabel)
                            .addComponent(NewItemCountLabel))
                        .addGap(35, 35, 35)
                        .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NewItemName)
                            .addComponent(NewItemPrice)
                            .addGroup(AddItemDialogLayout.createSequentialGroup()
                                .addComponent(NewItemPriceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 45, Short.MAX_VALUE)
                                .addGap(71, 71, 71))))
                    .addGroup(AddItemDialogLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(AddItemDialogOK, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(AddItemDialogCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        AddItemDialogLayout.setVerticalGroup(
            AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddItemDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewItemNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewItemPriceLabel)
                    .addComponent(NewItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewItemCountLabel)
                    .addComponent(NewItemPriceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddItemDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddItemDialogOK)
                    .addComponent(AddItemDialogCancel))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        InvoicesTableLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        CreatNewInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        DeleteInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));
        ((JSpinner.DefaultEditor) NewItemPriceSpinner.getEditor()).getTextField().setEditable(false);
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));

        setTitle("Sales Invoice Generator");
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1200, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InvoicesTablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InvoicesTableLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        InvoicesTableLabel.setText("Invoices Table");
        InvoicesTableLabel.setToolTipText("");
        InvoicesTablePanel.add(InvoicesTableLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        InvoicesTableLabel.setFont(new Font("Arial", Font.BOLD, 12));

        CreatNewInvoiceButton.setText("Creat New Invoice");
        InvoicesTablePanel.add(CreatNewInvoiceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, -1, -1));
        CreatNewInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));

        DeleteInvoiceButton.setText("Delete Invoice");
        InvoicesTablePanel.add(DeleteInvoiceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, -1));
        DeleteInvoiceButton.setFont(new Font("Arial", Font.BOLD, 12));

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ));
        InvoiceTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        InvoiceTableScrollPane.setViewportView(InvoiceTable);
        if (InvoiceTable.getColumnModel().getColumnCount() > 0) {
            InvoiceTable.getColumnModel().getColumn(0).setResizable(false);
        }
        InvoiceTable.getAccessibleContext().setAccessibleName("InvoiceTable");

        InvoicesTablePanel.add(InvoiceTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 69, 540, 480));

        getContentPane().add(InvoicesTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 650));

        InvoicesItemsPanel.setPreferredSize(new java.awt.Dimension(521, 472));
        InvoicesItemsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InvoiceNumberStaticLabel.setText("Invoice Number");
        InvoicesItemsPanel.add(InvoiceNumberStaticLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));
        InvoiceNumberStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));
        InvoicesItemsPanel.add(InvoiceNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 6, -1, -1));
        InvoiceNumberLabel.setFont(new Font("Arial", Font.BOLD, 12));

        InvoiceDateLabel.setText("Invoice Date");
        InvoicesItemsPanel.add(InvoiceDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 44, -1, -1));
        InvoiceDateLabel.setFont(new Font("Arial", Font.BOLD, 12));

        CustomerNameLabel.setText("Customer Name");
        InvoicesItemsPanel.add(CustomerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 85, -1, -1));
        CustomerNameLabel.setFont(new Font("Arial", Font.BOLD, 12));

        InvoiceTotalStaticLabel.setText("Invoice Total");
        InvoicesItemsPanel.add(InvoiceTotalStaticLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 123, -1, -1));
        InvoiceTotalStaticLabel.setFont(new Font("Arial", Font.BOLD, 12));

        InvoicesItemsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        InvoicesItemsLabel.setText("Invoice Itemes");
        InvoicesItemsPanel.add(InvoicesItemsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 180, -1, -1));
        InvoicesItemsLabel.setFont(new Font("Arial", Font.BOLD, 12));

        InvoiceDateTextField.setEditable(false);
        InvoicesItemsPanel.add(InvoiceDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 41, 131, -1));
        InvoiceDateTextField.setFont(new Font("Arial", Font.BOLD, 12));

        CustomerNameTextField.setEditable(false);
        InvoicesItemsPanel.add(CustomerNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 82, 131, -1));
        CustomerNameTextField.setFont(new Font("Arial", Font.BOLD, 12));
        InvoicesItemsPanel.add(InvoiceTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 123, -1, -1));
        InvoiceTotalLabel.setFont(new Font("Arial", Font.BOLD, 12));

        InvoicesLineTableScrollPane.setMinimumSize(new java.awt.Dimension(100, 100));

        InvoicesLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ));
        InvoicesLineTable.setFocusTraversalPolicyProvider(true);
        InvoicesLineTable.setMinimumSize(new java.awt.Dimension(100, 100));
        InvoicesLineTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        InvoicesLineTableScrollPane.setViewportView(InvoicesLineTable);
        InvoicesLineTable.getAccessibleContext().setAccessibleName("InvoicesLineTable");

        InvoicesItemsPanel.add(InvoicesLineTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 203, 590, 350));

        DeleteItemButton.setText("-");
        DeleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemButtonActionPerformed(evt);
            }
        });
        InvoicesItemsPanel.add(DeleteItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 40, -1));
        DeleteItemButton.setFont(new Font("Arial", Font.BOLD, 12));

        AddItemButton.setText("+");
        AddItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemButtonActionPerformed(evt);
            }
        });
        InvoicesItemsPanel.add(AddItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 40, -1));
        AddItemButton.setFont(new Font("Arial", Font.BOLD, 12));

        CancelButton.setText("Cancel");
        CancelButton.setEnabled(false);
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        InvoicesItemsPanel.add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 90, -1));
        getContentPane().add(InvoicesItemsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 620, 620));

        FileMenu.setText("File");

        LoadFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        LoadFile.setText("Load");
        LoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileActionPerformed(evt);
            }
        });
        FileMenu.add(LoadFile);

        SaveFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        SaveFile.setText("Save");
        SaveFile.setEnabled(false);
        FileMenu.add(SaveFile);
        FileMenu.add(jSeparator1);

        Quit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });
        FileMenu.add(Quit);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddItemButtonActionPerformed

    private void DeleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteItemButtonActionPerformed

    private void LoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadFileActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuitActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemButton;
    private static javax.swing.JDialog AddItemDialog;
    private javax.swing.JButton AddItemDialogCancel;
    public javax.swing.JButton AddItemDialogOK;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreatNewInvoiceButton;
    private javax.swing.JButton CreatNewInvoiceCancel;
    private static javax.swing.JDialog CreatNewInvoiceDialog;
    public javax.swing.JButton CreatNewInvoiceOK;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JTextField CustomerNameTextField;
    private javax.swing.JButton DeleteInvoiceButton;
    private javax.swing.JButton DeleteItemButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel InvoiceDateLabel;
    private javax.swing.JTextField InvoiceDateTextField;
    private javax.swing.JLabel InvoiceNumberLabel;
    private javax.swing.JLabel InvoiceNumberStaticLabel;
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JScrollPane InvoiceTableScrollPane;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JLabel InvoiceTotalStaticLabel;
    private javax.swing.JLabel InvoicesItemsLabel;
    private javax.swing.JPanel InvoicesItemsPanel;
    private javax.swing.JTable InvoicesLineTable;
    private javax.swing.JScrollPane InvoicesLineTableScrollPane;
    private javax.swing.JLabel InvoicesTableLabel;
    private javax.swing.JPanel InvoicesTablePanel;
    private javax.swing.JMenuItem LoadFile;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JTextField NewCustomerName;
    private javax.swing.JLabel NewCustomerNameLabel;
    private javax.swing.JTextField NewInvoiceDateField;
    private javax.swing.JLabel NewInvoiceDateLabel;
    private javax.swing.JLabel NewItemCountLabel;
    private javax.swing.JTextField NewItemName;
    private javax.swing.JLabel NewItemNameLabel;
    private javax.swing.JTextField NewItemPrice;
    private javax.swing.JLabel NewItemPriceLabel;
    private javax.swing.JSpinner NewItemPriceSpinner;
    private javax.swing.JMenuItem Quit;
    private javax.swing.JMenuItem SaveFile;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public JMenuItem getLoadFile() {
        return LoadFile;
    }

    public JMenuItem getQuit() {
        return Quit;
    }

    public JMenu getFileMenu() {
        return FileMenu;
    }

    public JTable getInvoiceTable() {
        return InvoiceTable;
    }

    public JTable getInvoicesLineTable() {
        return InvoicesLineTable;
    }

    public JButton getAddItemButton() {
        return AddItemButton;
    }

    public JButton getCancelButton() {
        return CancelButton;
    }

    public JTextField getCustomerNameTextField() {
        return CustomerNameTextField;
    }

    public JButton getDeleteItemButton() {
        return DeleteItemButton;
    }

    public JTextField getInvoiceDateTextField() {
        return InvoiceDateTextField;
    }

    public JLabel getInvoiceTotalLabel() {
        return InvoiceTotalLabel;
    }

    public JMenuItem getSaveFile() {
        return SaveFile;
    }

    public JButton getCreatNewInvoiceButton() {
        return CreatNewInvoiceButton;
    }

    public JButton getDeleteInvoiceButton() {
        return DeleteInvoiceButton;
    }

    public JLabel getInvoiceNumberLabel() {
        return InvoiceNumberLabel;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public JPanel getInvoicesItemsPanel() {
        return InvoicesItemsPanel;
    }

    public JPanel getInvoicesTablePanel() {
        return InvoicesTablePanel;
    }

    public JFileChooser getOpenFileJFileChooser() {
        return chooser;
    }

    @Override
    public JRootPane getRootPane() {
        return rootPane;
    }

    public JTextField getNewInvoiceDateField() {
        return NewInvoiceDateField;
    }

    public static JDialog getNewInvoiceDialog() {
        return CreatNewInvoiceDialog;
    }

    public static JDialog getAddItemDialog() {
        return AddItemDialog;
    }

    public JButton getAddItemDialogCancel() {
        return AddItemDialogCancel;
    }

    public JButton getCreatNewInvoiceOK() {
        return CreatNewInvoiceOK;
    }

    public JTextField getNewCustomerName() {
        return NewCustomerName;
    }

    public JButton getCreatNewInvoiceCancel() {
        return CreatNewInvoiceCancel;
    }

    public JButton getAddItemDialogOK() {
        return AddItemDialogOK;
    }

    public JSpinner getNewItemPriceSpinner() {
        return NewItemPriceSpinner;
    }

    public JTextField getNewItemName() {
        return NewItemName;
    }

    public JTextField getNewItemPrice() {
        return NewItemPrice;
    }

    public JScrollPane getjScrollPane2() {
        return InvoicesLineTableScrollPane;
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public static void setJOptionPaneMessagMessage(Component component, String message, String title, String messageType) {
        int messageTypeInteger = 0;
        switch (messageType) {
            case "ERROR_MESSAGE" ->
                messageTypeInteger = 0;
            case "QUESTION_MESSAGE" ->
                messageTypeInteger = 3;
            case "WARNING_MESSAGE" ->
                messageTypeInteger = 2;
            case "INFORMATION_MESSAGE" ->
                messageTypeInteger = 1;
        }
        JOptionPane.showMessageDialog(component, message, title, messageTypeInteger);
    }

    public int showYesNoCancelDialog(Component component, String message, String title) {
        Object[] yesNoCancel = {"Yes", "No", "Cancel"};
        return JOptionPane.showOptionDialog(component, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, yesNoCancel, yesNoCancel[0]);
    }

    public int showSaveDontSaveCancelDialog(Component component, String message, String title) {
        Object[] saveDontSaveCancel = {"Save", "Don't Save", "Cancel"};
        return JOptionPane.showOptionDialog(component, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, saveDontSaveCancel, saveDontSaveCancel[0]);
    }

    public void setLocations() {
        CreatNewInvoiceDialog.setLocation(InvoiceTable.getLocationOnScreen().x + 50, InvoiceTable.getLocationOnScreen().y + 50);
        AddItemDialog.setLocation(InvoicesLineTable.getLocationOnScreen().x + 100, InvoicesLineTable.getLocationOnScreen().y);
    }

    public void loadFiles() throws FileNotFoundException {
        Controller.isThereIsNotSavedEdit = false;

        while (InvoicesHeaderTableModel.setInvoicesHeaderTableModel(this).getRowCount() > 0) {
            InvoicesHeaderTableModel.setInvoicesHeaderTableModel(this).removeRow(0);
        }

        while (InvoicesLineTableModel.setInvoicesLineTableModel(this).getRowCount() > 0) {
            InvoicesLineTableModel.setInvoicesLineTableModel(this).removeRow(0);
        }

        getInvoiceTotalLabel().setText("");

        ArrayList<InvoiceHeader> invoices = new ArrayList<>();
        Controller.invoices = fileOperations.readFile();

        fileOperations.main(Controller.invoices);

        InvoicesHeaderController.calculateInvoiceTableTotal(Controller.invoices);
        TablesController.loadInvoicesHeaderTable(this, Controller.invoices);
        fileOperations.getMaxNumberOfExistedInvoices(Controller.maxNumberOfExistedInvoices, Controller.invoices);

    }

}
