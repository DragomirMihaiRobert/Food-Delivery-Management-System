package start;

import business.DeliveryService;
import data.Serializator;
import presentation.controller.LogInController;
import presentation.view.LogInView;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Serializator.deserialize();
        DeliveryService ds = new DeliveryService();
        LogInView logInView = new LogInView();
        logInView.setVisible(true);
        LogInController logInController = new LogInController(logInView, ds);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                Serializator.serialize();
            }
        }));
    }
}
