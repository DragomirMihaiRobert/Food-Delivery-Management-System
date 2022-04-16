package presentation.controller;

import business.Client;
import business.DeliveryService;
import business.MenuItem;
import business.User;
import presentation.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;

public class LogInController {
    private LogInView logInView;
    private DeliveryService deliveryService;
    private OrderView orderView = new OrderView();
    public LogInController(LogInView logInView, DeliveryService deliveryService){
        this.logInView = logInView;
        this.deliveryService = deliveryService;
        this.deliveryService.addObserver(orderView);
        this.logInView.addsignInBttnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = logInView.getUsername();
                String password = logInView.getPassword();
                String role = verifyLoginData(username, password);
                if(role.equals("ADMIN")){
                    AdminView adminView = new AdminView();
                    adminView.setVisible(true);
                    AdminController adminController = new AdminController(adminView, deliveryService);
                }
                else if (role.equals("EMPLOYEE")){
                    orderView.setVisible(true);
                }
                else if (role.equals("CLIENT")){
                    int clientID = 0;
                    ClientProductsView  clientProductsView = new ClientProductsView(getRowData(DeliveryService.menuItems));
                    clientProductsView.setVisible(true);
                    for(User user : deliveryService.users)
                        if(user.getUsername().equals(username)){
                            clientID = ((Client)user).getClientID();
                        }
                    ClientController clientController = new ClientController(clientProductsView, deliveryService, clientID);
                }
            }
        });
        this.logInView.addSignUpBttnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpView signUpView = new SignUpView();
                signUpView.setVisible(true);
                SignUpController signUpController = new SignUpController(signUpView);
            }
        });

    }
    public String verifyLoginData(String username, String password){
        for(User user : deliveryService.users){
            if(username.equals(user.getUsername())){
                if(password.equals(user.getPassword())){
                    return user.getRole().toString();
                }
                logInView.showError("Invalid password!");
                return "UNKNOWN";

            }
        }
        logInView.showError("Invalid username!");
        return "UNKONWN";
    }
    public static String[][] getRowData(TreeSet<MenuItem> menuItems){
        String[][] data = new String[menuItems.size()][7];
        int i = 0;
        for(MenuItem menuItem: menuItems){
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
