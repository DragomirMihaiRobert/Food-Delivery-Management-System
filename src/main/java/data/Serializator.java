package data;

import business.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Serializator {

    public static void serialize(){
        serializeObject(DeliveryService.users, "userData");
        serializeObject(DeliveryService.orders, "ordersData");
        serializeObject(DeliveryService.menuItems, "menuItemsData");
        serializeObject(Client.clientIDCounter, "clientID");
        serializeObject(Order.orderIDCounter, "orderID");
    }

    public static void deserialize(){
        File file = new File("userData");

        if(file.exists()) {
            DeliveryService.users.clear();
            DeliveryService.users.addAll((ArrayList<User>) deserializeObject("userData"));
        }

        File file1 = new File("ordersData");
        if(file1.exists()) {
            DeliveryService.orders.clear();
            DeliveryService.orders.putAll((HashMap<Order, ArrayList<MenuItem>>) deserializeObject("ordersData"));
        }

        File file2 = new File("menuItemsData");
        if(file2.exists()) {
            DeliveryService.menuItems.clear();
            DeliveryService.menuItems.addAll((TreeSet<MenuItem>) deserializeObject("menuItemsData"));
        }

        File file3 = new File("clientID");
        if(file3.exists()) {
            Client.clientIDCounter = ((Integer) deserializeObject("clientID")).intValue();
        }

        File file4 = new File("orderID");
        if(file4.exists()) {
            Order.orderIDCounter = ((Integer) deserializeObject("orderID")).intValue();
        }

    }

    private static void serializeObject(Object object, String fileName){
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    private static Object deserializeObject(String fileName){
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object retrivedObject = in.readObject();
            in.close();
            fileIn.close();
            return retrivedObject;
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
            return null;
        }
    }
}
