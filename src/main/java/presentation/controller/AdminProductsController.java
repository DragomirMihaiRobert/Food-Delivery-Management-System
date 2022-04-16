package presentation.controller;

import business.CompositeProduct;
import business.DeliveryService;
import business.MenuItem;
import presentation.view.AddProductView;
import presentation.view.AdminProductsView;
import presentation.view.CreateCompositeItemView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProductsController {
    private DeliveryService deliveryService;
    private AdminProductsView adminProductsView;
    private CompositeProduct compositeProduct = null;
    public AdminProductsController(AdminProductsView adminProductsView, DeliveryService deliveryService){
        this.deliveryService = deliveryService;
        this.adminProductsView = adminProductsView;
        this.adminProductsView.addAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddProductView addProductView = new AddProductView();
                addProductView.setVisible(true);
                AddProductController addProductController = new AddProductController(addProductView, deliveryService, adminProductsView.getTableModel());
            }
        });

        this.adminProductsView.addRemoveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.deleteProductFromMenu(adminProductsView.removeCurrentRow());
            }
        });

        this.adminProductsView.addSaveEditActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deliveryService.editProductFromMenu(adminProductsView.getSelectedTitle(), adminProductsView.getEditedMenuItem());
            }
        });

        this.adminProductsView.addAddToComposedItemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(compositeProduct == null){
                    compositeProduct = new CompositeProduct();
                }
                compositeProduct.addMenuItem(adminProductsView.getEditedMenuItem());
            }
        });

        this.adminProductsView.addProcessComposedProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateCompositeItemView createCompositeItemView = new CreateCompositeItemView();
                createCompositeItemView.setVisible(true);
                CreateCompositeItemController createCompositeItemController = new CreateCompositeItemController(createCompositeItemView, compositeProduct, deliveryService, adminProductsView.getTableModel());
                compositeProduct = null;
            }
        });

    }
}
