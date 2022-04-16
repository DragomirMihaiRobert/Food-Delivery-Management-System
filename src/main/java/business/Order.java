package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order implements Serializable {
    private int orderID;
    private int clientID;
    private LocalDateTime date;
    private int price;
    public static int orderIDCounter = 0;

    public Order(int clientID, LocalDateTime date, int price){
        this.orderID = ++orderIDCounter;
        this.clientID = clientID;
        this.date = date;
        this.price = price;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String dateString = date.format(formatter);
        return "Order ID: " + orderID + "\nClient ID: " + clientID + "\nOrder date: " + dateString + "\nTotal: " + price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && clientID == order.clientID && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, date);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
