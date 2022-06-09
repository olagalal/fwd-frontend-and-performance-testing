package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.GUI;
import controller.Controller;


/**
 *
 * @author Ola Galal
 */
public class FileOperations {
    
    public static File selectedInvoiceHeader = new File(System.getProperty("user.dir")+"/InvoiceHeader.csv");
    public static File selectedInvoiceLine = new File(System.getProperty("user.dir")+"/InvoiceLine.csv");

    public static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
    private GUI gui;

    public FileOperations(GUI gui) {
        this.gui = gui;
    }

    public void getFilesPaths() {

        boolean extensionFlag = false;
        boolean cancelButton = false;
        int click;
        String fileName;
        String fileExtension;

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        gui.getOpenFileJFileChooser().setCurrentDirectory(new File(System.getProperty("user.dir")));

        GUI.setJOptionPaneMessagMessage(gui, "Select Invoice Header File", "Invoice Header", "WARNING_MESSAGE");
        do {
            click = gui.getOpenFileJFileChooser().showOpenDialog(gui);

            if (click == JFileChooser.APPROVE_OPTION) {
                cancelButton = false;
                fileName = gui.getOpenFileJFileChooser().getSelectedFile().getName();
                fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

                if (fileExtension.equalsIgnoreCase("csv")) {
                    extensionFlag = false;
                    selectedInvoiceHeader = gui.getOpenFileJFileChooser().getSelectedFile();
                } else {
                    extensionFlag = true;
                    GUI.setJOptionPaneMessagMessage(gui, "Choose file with .csv extension", "Wrong File", "ERROR_MESSAGE");
                }
            } else {
                cancelButton = true;
            }
        } while (extensionFlag == true && cancelButton == false);

        extensionFlag = true;

        if (selectedInvoiceHeader != null) {
            GUI.setJOptionPaneMessagMessage(gui, "Select Invoice Line File", "Invoice Line", "WARNING_MESSAGE");
        }

        while (extensionFlag == true && cancelButton == false) {
            click = gui.getOpenFileJFileChooser().showOpenDialog(gui);

            if (click == JFileChooser.APPROVE_OPTION) {
                cancelButton = false;
                fileName = gui.getOpenFileJFileChooser().getSelectedFile().getName();
                fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());

                if (fileExtension.equalsIgnoreCase("csv")) {
                    extensionFlag = false;
                    selectedInvoiceLine = gui.getOpenFileJFileChooser().getSelectedFile();
                } else {
                    extensionFlag = true;
                    GUI.setJOptionPaneMessagMessage(gui, "Choose file with .csv extension", "Wrong File", "ERROR_MESSAGE");
                }
            } else {
                cancelButton = true;
            }
        }

    }

    public ArrayList<InvoiceHeader> readFile() {
        String inoviceLine;
        String[] invoicesHeader;
        String invoiceNumberStr;
        String invoiceDateStr;
        String invoiceCustomerName;
        int invoiceNumber;
        Date invoiceDate;
        InvoiceHeader header;
        InvoiceLine line;
        String[] invoicesLine;
        String invoiceItemName;
        String itemPriceStr;
        String itemCountStr;
        float itemPrice;
        int itemCount;
        InvoiceHeader temporary;
        ArrayList<InvoiceHeader> invoices = null;

        try {
            if (selectedInvoiceHeader != null && selectedInvoiceLine != null) {
                invoices = new ArrayList<>();
                FileReader file = new FileReader(selectedInvoiceHeader);
                BufferedReader bufferReader = new BufferedReader(file);
                inoviceLine = bufferReader.readLine();

                while (inoviceLine != null) {
                    invoicesHeader = inoviceLine.split(",");
                    if (invoicesHeader.length != 3) {
                        throw new Exception("wrong csv format");
                    }

                    invoiceNumberStr = invoicesHeader[0];
                    if (!invoiceNumberStr.matches("^\\d+$")) {
                        throw new Exception("wrong csv format");
                    }

                    invoiceDateStr = invoicesHeader[1];
                    if (!invoiceDateStr.matches("^\\d{2}\\-\\d{2}\\-\\d{4}$")) {
                        throw new Exception("wrong csv format");
                    }

                    invoiceCustomerName = invoicesHeader[2];
                    gui.getDate().setLenient(false);
                    invoiceDate = gui.getDate().parse(invoiceDateStr);
                    invoiceNumber = Integer.parseInt(invoiceNumberStr);
                    header = new InvoiceHeader(invoiceNumber, invoiceDate, invoiceCustomerName);
                    invoices.add(header);

                    inoviceLine = bufferReader.readLine();
                }

                bufferReader.close();
                file.close();
            }
        } catch (Exception e) {
            selectedInvoiceHeader = null;
            selectedInvoiceLine = null;

            invoices.clear();
            gui.getCreatNewInvoiceButton().setEnabled(false);

            GUI.setJOptionPaneMessagMessage(gui, "wrong csv format", "Error", "ERROR_MESSAGE");
        }

        try {
            if (selectedInvoiceHeader != null && selectedInvoiceLine != null) {
                FileReader file = new FileReader(selectedInvoiceLine);
                BufferedReader bufferReader = new BufferedReader(file);
                inoviceLine = bufferReader.readLine();
//                System.out.println(inoviceLine);

                while (inoviceLine != null) {
                    
                    invoicesLine = inoviceLine.split(",");
                    if (invoicesLine.length != 4) {
                        throw new Exception("wrong csv format");
                    }

                    invoiceNumberStr = invoicesLine[0];
                    if (!invoiceNumberStr.matches("^\\d+$")) {
                        throw new Exception("wrong csv format");
                    }

                    invoiceItemName = invoicesLine[1];
                    itemPriceStr = invoicesLine[2];
                    itemCountStr = invoicesLine[3];
                    if (!(itemCountStr.matches("^\\d+$")) || Integer.parseInt(itemCountStr) < 1) {
                        throw new Exception("wrong csv format");
                    }

                    invoiceNumber = Integer.parseInt(invoiceNumberStr);
                    itemPrice = Float.parseFloat(itemPriceStr);
                    itemCount = Integer.parseInt(itemCountStr);

                    temporary = findParentHeader(invoiceNumber, invoices);
                    line = new InvoiceLine(invoiceItemName, itemPrice, itemCount, temporary);
                    temporary.getInvoicerow().add(line);
                    
                    inoviceLine = bufferReader.readLine();
                    System.out.println(inoviceLine);
                }

                bufferReader.close();
                file.close();
            }
        } catch (Exception e) {
            selectedInvoiceHeader = null;
            selectedInvoiceLine = null;

            invoices.clear();
            gui.getCreatNewInvoiceButton().setEnabled(false);

            GUI.setJOptionPaneMessagMessage(gui, "wrong csv format", "Error", "ERROR_MESSAGE");
        }
        return invoices;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoices) throws IOException {
        Controller.isThereIsNotSavedEdit = false;

        int invoiceLinelines;
        int totalInvoiceLinelines = 0;
        int actualLine = 0;
        FileWriter fileWriter = new FileWriter(selectedInvoiceHeader);

        for (int i = 0; i < invoices.size(); i++) {
            String inoviceLine = invoices.get(i).getInoviceNumber() + "," + date.format(invoices.get(i).getInoviceDate()) + "," + invoices.get(i).getInoviceCustomerName();
            if (i != invoices.size() - 1) inoviceLine += "\n";
            fileWriter.write(inoviceLine);
        }
        
        fileWriter.close();
        fileWriter = new FileWriter(selectedInvoiceLine);

        for (int i = 0; i < invoices.size(); i++)
            totalInvoiceLinelines += invoices.get(i).getInvoicerow().size();
        
        for (int i = 0; i < invoices.size(); i++) {
            invoiceLinelines = invoices.get(i).getInvoicerow().size();
            
            for (int j = 0; j < invoiceLinelines; j++) {
                String inoviceLine = Integer.toString(invoices.get(i).getInvoicerow().get(j).getMainInvoice().getInoviceNumber()) + ",";
                inoviceLine += invoices.get(i).getInvoicerow().get(j).getItemName() + ",";
                inoviceLine += Float.toString(invoices.get(i).getInvoicerow().get(j).getItemPrice()) + ",";
                inoviceLine += Integer.toString(invoices.get(i).getInvoicerow().get(j).getItemCount());
                actualLine++;

                if (totalInvoiceLinelines != actualLine) {
                    inoviceLine += "\n";
                } else {
                    fileWriter.write(inoviceLine);
                }
            }
        }
        
        GUI.setJOptionPaneMessagMessage(gui, "New data is saved", "Saved", "INFORMATION_MESSAGE");
        fileWriter.close();
    }

    public void main(ArrayList<InvoiceHeader> invoices) {
        if (selectedInvoiceHeader != null && selectedInvoiceLine != null) {
            for (int i = 0; i < invoices.size(); i++) {
                System.out.println("INVOICE " + invoices.get(i).getInoviceNumber() + " : ");
                System.out.print(invoices.get(i).getInoviceDate() + ", " + invoices.get(i).getInoviceCustomerName());
                
                for (int j = 0; j < invoices.get(i).getInvoicerow().size(); j++) {
                    System.out.println(invoices.get(i).getInvoicerow().get(j).getItemName() + ", "
                            + invoices.get(i).getInvoicerow().get(j).getItemPrice() + ", "
                            + invoices.get(i).getInvoicerow().get(j).getItemCount());
                }
                
                System.out.println("");
            }
        }
    }

    private InvoiceHeader findParentHeader(int invoiceNumber, ArrayList<InvoiceHeader> invoices) {
        InvoiceHeader returnElement = null;
        for (int i = 0; i < invoices.size(); i++)
            if (invoices.get(i).getInoviceNumber() == invoiceNumber)
                returnElement = invoices.get(i);
        return returnElement;
    }

    public void getMaxNumberOfExistedInvoices(int maxNumberOfExistedInvoices, ArrayList<InvoiceHeader> invoices) {
        for (int i = 0; i < invoices.size(); i++)
            if ((invoices.get(i).getInoviceNumber()) > Controller.maxNumberOfExistedInvoices)
                Controller.maxNumberOfExistedInvoices = invoices.get(i).getInoviceNumber();
    }
}
