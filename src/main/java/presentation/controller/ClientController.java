package presentation.controller;

import business.Client;
import business.DeliveryService;
import business.MenuItem;
import presentation.view.ClientProductsView;
import presentation.view.SearchView;

import javax.naming.directory.SearchControls;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClientController {
    private DeliveryService deliveryService;
    private ClientProductsView clientProductsView;
    private ArrayList<MenuItem> menuItems = null;
    private int clientID;
    public ClientController(ClientProductsView clientProductsView, DeliveryService deliveryService, int clientID){
        this.clientProductsView = clientProductsView;
        this.deliveryService = deliveryService;
        this.clientID = clientID;

        this.clientProductsView.addSearchForProductActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchView searchView = new SearchView();
                searchView.setVisible(true);
                SearchController searchController = new SearchController(searchView, deliveryService);

            }
        });

        this.clientProductsView.addPlaceOrderActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    deliveryService.createOrder(clientID, LocalDateTime.now(), menuItems);
                    menuItems = null;
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });

        this.clientProductsView.addAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menuItems == null)
                    menuItems = new ArrayList<>();
                menuItems.add(clientProductsView.getCurrentMenuItem());

            }
        });

    }

}
