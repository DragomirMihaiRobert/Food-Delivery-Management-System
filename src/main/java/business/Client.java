package business;

public class Client extends User{
    private int clientID;
    private String name;
    public static int clientIDCounter = 0;
    public Client(String username, String name, String password, String role) {
        super(username, password, role);
        this.clientID = ++clientIDCounter;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
}
