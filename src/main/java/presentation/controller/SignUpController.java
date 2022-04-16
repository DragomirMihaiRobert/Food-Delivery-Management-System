package presentation.controller;

import business.Client;
import business.DeliveryService;
import business.User;
import presentation.view.SignUpView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpController {
    private DeliveryService deliveryService;
    private SignUpView signUpView;

    public SignUpController(SignUpView signUpView){
        this.signUpView = signUpView;
        this.signUpView.addSignUpBttnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = signUpView.getUsername();
                String name = signUpView.getName();
                String password = signUpView.getPassword();
                String role = "CLIENT";
                User newUser = new Client(username, name, password, role);
                DeliveryService.users.add(newUser);
                signUpView.showError("User successfully registered!");
            }
        });
    }
}
