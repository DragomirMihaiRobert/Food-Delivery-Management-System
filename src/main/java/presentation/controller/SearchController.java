package presentation.controller;

import business.DeliveryService;
import business.MenuItem;
import presentation.view.ClientProductsView;
import presentation.view.SearchView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TreeSet;

public class SearchController {
    private SearchView searchView;
    private DeliveryService deliveryService;
    private TreeSet<MenuItem> menuItemsFound;
    public SearchController(SearchView searchView, DeliveryService deliveryService) {
        this.searchView = searchView;
        this.deliveryService = deliveryService;
        this.searchView.addSearchBttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float rating = searchView.getRaiting();
                int proteins = searchView.getProteins();
                int fat = searchView.getFat();
                int calories = searchView.getCalories();
                int sodium = searchView.getSodium();
                int price = searchView.getPrice();
                String keyword = searchView.getKeyword();
                menuItemsFound = deliveryService.searchForProduct(keyword, rating, price, calories, proteins, fat, sodium);
                ClientProductsView.updateTable(LogInController.getRowData(menuItemsFound));
            }
        });
    }
}
