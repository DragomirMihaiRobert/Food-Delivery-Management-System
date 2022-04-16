package presentation.controller;

import business.DeliveryService;
import business.MenuItem;
import presentation.view.AdminProductsView;
import presentation.view.AdminView;
import presentation.view.GenerateReportsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AdminController {
    private AdminView adminView;
    private DeliveryService deliveryService;
    public AdminController(AdminView adminView, DeliveryService deliveryService){
        this.adminView = adminView;
        this.deliveryService = deliveryService;
        this.adminView.addGenerateReportsBttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerateReportsView generateReportsView = new GenerateReportsView();
                generateReportsView.setVisible(true);
                GenerateReportsController generateReportsController = new GenerateReportsController(generateReportsView, deliveryService);
            }
        });
        this.adminView.addImportProductsBttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deliveryService.importProducts();
                    adminView.showError("Products successfully imported!");

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        this.adminView.addManageProductsBttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminProductsView adminProductsView = new AdminProductsView(getRowData());
                AdminProductsController adminProductsController = new AdminProductsController(adminProductsView, deliveryService);
                adminProductsView.setVisible(true);

            }
        });
    }

    public String[][] getRowData(){
        String[][] data = new String[DeliveryService.menuItems.size()][7];
        int i = 0;
        for(MenuItem menuItem: DeliveryService.menuItems){
            data[i][0] = menuItem.getTitle();
            data[i][1] = menuItem.getRating() + "";
            data[i][2] = menuItem.getCalories() + "";
            data[i][3] = menuItem.getProtein() + "";
            data[i][4] = menuItem.getFat() + "";
            data[i][5] = menuItem.getSodium() + "";
            data[i][6] = menuItem.getPrice() + "";
            i++;
        }
        return data;
    }

}
