package presentation.view;

import business.BaseProduct;
import business.CompositeProduct;
import business.DeliveryService;
import business.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * A Swing program that demonstrates how to create a popup menu
 * for a JTable component.
 * @author www.codejava.net
 *
 */
public class ClientProductsView extends JFrame {

    private static DefaultTableModel tableModel;
    private JTable table;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemSearchForProduct;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemPlaceOrder;
    private static String[] columnNames = new String[]{"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};

    public ClientProductsView(String[][] rowData) {


        // constructs the table with sample data
        tableModel = new DefaultTableModel(rowData, columnNames);


        // constructs the table with sample data
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);

        // constructs the popup menu
        popupMenu = new JPopupMenu();
        menuItemSearchForProduct = new JMenuItem("Search for Product");
        menuItemAdd = new JMenuItem("Add Current Product to Order");
        menuItemPlaceOrder = new JMenuItem("Place Order");


        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemSearchForProduct);
        popupMenu.add(menuItemPlaceOrder);

        // sets the popup menu for the table
        table.setComponentPopupMenu(popupMenu);

        //table.addMouseListener(new TableMouseListener(table));

        // adds the table to the frame
        add(new JScrollPane(table));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 150);
        setLocationRelativeTo(null);
    }

    public static void updateTable(String[][] newData){
        tableModel.setDataVector(newData, columnNames);
    }

    public void addSearchForProductActionListener(ActionListener actionListener){
        menuItemSearchForProduct.addActionListener(actionListener);
    }
    public void addAddActionListener(ActionListener actionListener){
        menuItemAdd.addActionListener(actionListener);
    }
    public void addPlaceOrderActionListener(ActionListener actionListener){
        menuItemPlaceOrder.addActionListener(actionListener);
    }
    public MenuItem getCurrentMenuItem(){
        int selectedRow = table.getSelectedRow();
        String title = (String)table.getValueAt(selectedRow, 0);
        float newRating = Float.parseFloat((String)table.getValueAt(selectedRow, 1));
        int newCalories = Integer.parseInt((String) table.getValueAt(selectedRow, 2));
        int newProteins = Integer.parseInt((String) table.getValueAt(selectedRow, 3));
        int newFat = Integer.parseInt((String) table.getValueAt(selectedRow, 4));
        int newSodium = Integer.parseInt((String) table.getValueAt(selectedRow, 5));
        int newPrice = Integer.parseInt((String) table.getValueAt(selectedRow, 6));
        for(MenuItem menuItem: DeliveryService.menuItems){
                if(menuItem instanceof BaseProduct){
                    return new BaseProduct(title, newRating, newCalories, newProteins, newFat, newSodium, newPrice);
                }
                if(menuItem instanceof CompositeProduct){
                    return new CompositeProduct(title, newRating, newCalories, newProteins, newFat, newSodium, newPrice);
                }
        }
        return null;
    }

}