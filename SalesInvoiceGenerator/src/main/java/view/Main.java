package view;

import controller.Controller;
import java.io.FileNotFoundException;
import model.InvoiceHeader;
import model.InvoiceLine;

/**
 *
 * @author Ola Galal
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.setResizable(false);

        new Controller(new InvoiceHeader(), new InvoiceLine(), gui);
    }
}
