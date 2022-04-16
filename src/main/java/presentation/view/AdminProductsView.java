package presentation.view;

import business.BaseProduct;
import business.CompositeProduct;
import business.DeliveryService;
import business.MenuItem;
import presentation.controller.TableController;

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
public class AdminProductsView extends JFrame{

    private JTable table;
    private DefaultTableModel tableModel;
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    //private JMenuItem menuItemSaveAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemEdit;
    private JMenuItem menuItemSaveEdit;
    private JMenuItem menuItemAddToComposedProduct;
    private JMenuItem menuItemProcessComposedProduct;

    public AdminProductsView(String[][] rowData) {

        String[] columnNames = new String[]{"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        // constructs the table with sample data
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);
        // constructs the popup menu
        popupMenu = new JPopupMenu();
        menuItemAdd = new JMenuItem("Add New Product");
        menuItemRemove = new JMenuItem("Remove Current Product");
        menuItemSaveEdit = new JMenuItem("Save Edited Product");
        menuItemAddToComposedProduct = new JMenuItem("Add Current Product to a Composed One");
        menuItemProcessComposedProduct = new JMenuItem("Process the Composed Product");


        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemSaveEdit);
        popupMenu.add(menuItemAddToComposedProduct);
        popupMenu.add(menuItemProcessComposedProduct);

        // sets the popup menu for the table
        table.setComponentPopupMenu(popupMenu);

        table.addMouseListener(new TableController(table));

        // adds the table to the frame
        add(new JScrollPane(table));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 150);
        setLocationRelativeTo(null);
    }

    public String removeCurrentRow() {
        int selectedRow = table.getSelectedRow();
        String menuTitle = getSelectedTitle();
        tableModel.removeRow(selectedRow);
        return menuTitle;
    }

    public String getSelectedTitle(){
        int selectedRow = table.getSelectedRow();
        String menuTitle = (String)table.getValueAt(selectedRow, 0);
        return menuTitle;
    }

    public MenuItem getEditedMenuItem(){
        int selectedRow = table.getSelectedRow();
        float newRating = Float.parseFloat((String)table.getValueAt(selectedRow, 1));
        int newCalories = Integer.parseInt((String) table.getValueAt(selectedRow, 2));
        int newProteins = Integer.parseInt((String) table.getValueAt(selectedRow, 3));
        int newFat = Integer.parseInt((String) table.getValueAt(selectedRow, 4));
        int newSodium = Integer.parseInt((String) table.getValueAt(selectedRow, 5));
        int newPrice = Integer.parseInt((String) table.getValueAt(selectedRow, 6));
        for(MenuItem menuItem: DeliveryService.menuItems){
            if(menuItem.getTitle().equals(getSelectedTitle())){
                if(menuItem instanceof BaseProduct){
                    return new BaseProduct(menuItem.getTitle(), newRating, newCalories, newProteins, newFat, newSodium, newPrice);
                }
                if(menuItem instanceof CompositeProduct){
                    return new CompositeProduct(menuItem.getTitle(), newRating, newCalories, newProteins, newFat, newSodium, newPrice);
                }
            }
        }
        return null;
    }

    public JTable getTable(){
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void addAddActionListener(ActionListener actionListener){
        menuItemAdd.addActionListener(actionListener);
    }

    public void addRemoveActionListener(ActionListener actionListener){
        menuItemRemove.addActionListener(actionListener);
    }

    public void addSaveEditActionListener(ActionListener actionListener){
        menuItemSaveEdit.addActionListener(actionListener);
    }
    public void addAddToComposedItemActionListener(ActionListener actionListener){
        menuItemAddToComposedProduct.addActionListener(actionListener);
    }
    public void addProcessComposedProductActionListener(ActionListener actionListener){
        menuItemProcessComposedProduct.addActionListener(actionListener);
    }
}