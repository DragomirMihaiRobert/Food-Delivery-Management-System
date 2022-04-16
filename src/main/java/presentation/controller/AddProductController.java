package presentation.controller;

import business.DeliveryService;
import presentation.view.AddProductView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductController {
    private AddProductView addProductView;
    private DeliveryService deliveryService;
    private DefaultTableModel table;
    public AddProductController(AddProductView addProductView, DeliveryService deliveryService, DefaultTableModel table) {
        this.addProductView = addProductView;
        this.deliveryService = deliveryService;
        this.table = table;
        this.addProductView.addAddButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.addProductsToMenu(addProductView.getNewMenuItem());
                table.addRow(addProductView.newRow());
            }
        });
    }
}
