package business;
import data.FileWriter;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Dragomir Mihai-Robert
 * @date 23.05.2021
 */

public class DeliveryService extends Observable implements IDeliveryServiceProcessing{
    public static TreeSet<MenuItem> menuItems = new TreeSet<>();
    public static HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<>();
    public static ArrayList<User> users = new ArrayList<>();
    private static final String adminUsername = "admin";
    private static final String employeeUsername = "employee";
    private static final String employeePassword = "employee";
    private static final String adminPassword = "admin";

    static{
        User admin = new User(adminUsername, adminPassword, "ADMIN");
        User employee = new User(employeeUsername, employeePassword, "EMPLOYEE");
        users.add(admin);
        users.add(employee);
    }


    public static Function<String, BaseProduct> mapToProduct = (line) -> {
        String[] p = line.split(",");
        return new BaseProduct(p[0].replace("\"", ""), Float.parseFloat(p[1]), Integer.parseInt(p[2]), Integer.parseInt(p[3]),
                                    Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]));
    };

    /**
     * Functia de importare a fisierului .csv in vederea popularii meniului restaurantului
     * @throws FileNotFoundException
     * @pre fisierul .csv exista
     * @post !menuItems.isEmpty()
     */
    @Override
    public void importProducts() throws FileNotFoundException {
        InputStream is = new FileInputStream(new File("products.csv"));
        assert is != null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        TreeSet<BaseProduct> baseProducts= br.lines()
                .skip(1)
                .map(mapToProduct)
                .collect(Collectors.toCollection(TreeSet::new));
        menuItems.addAll(baseProducts);
        assert !menuItems.isEmpty();
        assert isWellFormed();
    }

    /**
     * Functia de adaugare a unui produs in meniul restaurantului
     * @param menuItem produsul ce se doreste a fi adaugat
     * @pre menuItem != null
     * @post menuItems.contains(menuItem)
     */
    @Override
    public void addProductsToMenu(MenuItem menuItem) {
        assert menuItem != null;
        menuItems.add(menuItem);
        assert menuItems.contains(menuItem);
        assert isWellFormed();
    }

    /**
     * Functia de stergere a unui produs din meniul restaurantului
     * @param menuTitle numele produsului ce se doreste a fi sters
     * @pre !menuTitle.isEmpty()
     * @post newSize = oldSize - 1
     */
    @Override
    public void deleteProductFromMenu(String menuTitle) {
        assert !menuTitle.isEmpty();
        int oldSize = menuItems.size();
        for(MenuItem menuItem: menuItems){
            if(menuItem.getTitle().equals(menuTitle)){
                menuItems.remove(menuItem);
                break;
            }
        }
        assert menuItems.size() == (oldSize - 1);
        assert isWellFormed();
    }

    /**
     * Functia de editare a unui produs din meniul restaurantului
     * @param oldMenuItem numele produsului ce se doreste a fi editat
     * @param newMenuItem noile atribute ale produsului
     * @pre !oldMenuItem.isEmpty()
     * @post menuItems.contains(newMenuItem)
     */
    @Override
    public void editProductFromMenu(String oldMenuItem, MenuItem newMenuItem) {
        assert !oldMenuItem.isEmpty();
        for(MenuItem menuItem : menuItems){
            if(menuItem.getTitle().equals(oldMenuItem)) {
                menuItems.remove(menuItem);
                menuItems.add(newMenuItem);
                break;
            }
        }
        assert menuItems.contains(newMenuItem);
        assert isWellFormed();
    }

    /**
     * Functia de generare a raportului cu acele comenzi date intr-un anumit interval orar
     * @param startHour ora minima la care a fost depusa comanda
     * @param endHour ora maxima la care a fost depusa comanda
     * @throws IOException
     * @pre startHour <= endHour
     * @post fisierul de scriete a raportului a fost inchis
     */
    @Override
    public void generateTimeReport(int startHour, int endHour) throws IOException {
        assert startHour <= endHour;
        FileWriter fileWriter = new FileWriter("AdminReport1.txt");
        String text = orders
                .keySet()
                .stream()
                .filter(p -> p.getDate().getHour() <  endHour)
                .filter(p -> p.getDate().getHour() >= startHour)
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
        fileWriter.write(text);
        fileWriter.close();

        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    /**
     * Functia de generare a raportului cu produsele comandate de cel putin un numar dat de ori
     * @param numberOfTimesOrdered numarul minim de comenzi date pentru un produs
     * @throws IOException
     * @pre numberOfTimesOrdered >= 0
     * @post fisierul de scriete a raportului a fost inchis
     */
    @Override
    public void generateFrequencyReport(int numberOfTimesOrdered) throws IOException {
        assert numberOfTimesOrdered >= 0;
        FileWriter fileWriter = new FileWriter("AdminReport2.txt");
        ArrayList<MenuItem> products = new ArrayList<>();
        orders
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .forEach(products::addAll);

        filterProductsByFrequency(numberOfTimesOrdered, fileWriter, products);
        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    /**
     * Functia de generare a raportului cu clientii care au depus comenzi cu o valoare mai mare decat o valoare data
     * si numarul minim de ori de care trebuiau sa comande
     * @param numberOfTimesOrdered numarul minim de ori de care clientii trebuie sa comande
     * @param amount valoarea minima pe care trebuie sa le aiba comenzile
     * @throws IOException
     * @pre numberOfTimesOrdered >= 0 && amount >= 0
     * @post fisierul de scriete a raportului a fost inchis
     */
    @Override
    public void generateFrequencyAndValueReport(int numberOfTimesOrdered, int amount) throws IOException {
        assert numberOfTimesOrdered >= 0 && amount >= 0;
        FileWriter fileWriter = new FileWriter("AdminReport3.txt");
        ArrayList<Integer> clients = new ArrayList<>();
        orders
                .keySet()
                .stream()
                .filter(items -> items.getPrice() > amount)
                .forEach(c -> clients.add(c.getClientID()));

        filterClientsByFrequency(numberOfTimesOrdered, fileWriter, clients);
        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    private void filterClientsByFrequency(int numberOfTimesOrdered, FileWriter fileWriter, ArrayList<Integer> clients) throws IOException {
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        AtomicReference<String> text = new AtomicReference<>("");
        clients
                .stream()
                .forEach(c -> frequency.put(c, Collections.frequency(clients, c)));

        frequency
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > numberOfTimesOrdered)
                .forEach(p -> {
                    text.getAndSet(text.get() + "Client with ID " + p.getKey() + " ordered " + p.getValue() + " times.\n");
                });

        fileWriter.write(text.get());
        fileWriter.close();
    }

    private void filterProductsByFrequency(int numberOfTimesOrdered, FileWriter fileWriter, ArrayList<MenuItem> products) throws IOException {
        TreeMap<MenuItem, Integer> frequency = new TreeMap<>();
        AtomicReference<String> text = new AtomicReference<>("");
        products
                .stream()
                .forEach(p -> frequency.put(p, Collections.frequency(products, p)));

        frequency
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > numberOfTimesOrdered)
                .forEach(p -> {
                    text.getAndSet(text.get() + p.getKey().getTitle() + " appears " + p.getValue() + " times.\n");
                });

        fileWriter.write(text.get());
        fileWriter.close();
    }

    /**
     * Functia de generare a raporului cu produsele comandate intr-o anumita zi si frecventa lor in comenzi
     * @param localDate data in care au fost depuse comenzile
     * @throws IOException
     * @pre localDate != null
     * @post fisierul de scriete a raportului a fost inchis
     */
    @Override
    public void generateDateReport(LocalDate localDate) throws IOException {
        assert localDate != null;
        FileWriter fileWriter = new FileWriter("AdminReport4.txt");
        ArrayList<MenuItem> products = new ArrayList<>();
        orders
                .entrySet()
                .stream()
                .filter(p -> p.getKey().getDate().toLocalDate().equals(localDate))
                .map(Map.Entry::getValue)
                .forEach(products::addAll);

        filterProductsByFrequency(0, fileWriter, products);
        assert fileWriter.isClosed();
        assert isWellFormed();
    }

    /**
     * Functia de creare a unei comenzi depuse de un client
     * @param clientID id-ul clientului care a depus comanda
     * @param date data la care a fost depusa comanda
     * @param menuItems produsele care au fost comandate
     * @throws IOException
     * @pre !menuItems.isEmpty()
     * @post !orders.isEmpty()
     */
    @Override
    public void createOrder(int clientID, LocalDateTime date, ArrayList<MenuItem> menuItems) throws IOException {
        assert !menuItems.isEmpty();
        int orderValue = 0;
        for(MenuItem menuItem : menuItems)
            orderValue += menuItem.getPrice();
        Order newOrder = new Order(clientID, date, orderValue);
        orders.put(newOrder, menuItems);
        FileWriter fileWriter = new FileWriter("order" + newOrder.getOrderID() + ".txt");
        String text = newOrder + "\n" + "Products ordered:\n";
        for(MenuItem menuItem : menuItems)
            text += menuItem.getTitle() + "\n";
        fileWriter.write(text);
        fileWriter.close();

        String ordersText = "";
        for(Order order: orders.keySet()){
            ordersText += order + "\nItems ordered:\n";
            for(MenuItem menuItem: orders.get(order)){
                ordersText += menuItem + "\n";
            }
            ordersText += "\n";
        }
        setChanged();
        notifyObservers(ordersText);

        assert !orders.isEmpty();
        assert isWellFormed();
    }

    /**
     * Functia de cautare in lista de produse a restaurantului, in functie de anumite criterii
     * @param keyword subsirul pe care trebuie sa il contina numele produsului
     * @param rating valoarea fata de care ratingul produsului trebuie sa fie mai mare
     * @param calories valoarea fata de care numarul de calorii al produsului trebuie sa fie mai mic
     * @param protein valoarea fata de care numarul de proteine al produsului trebuie sa fie mai mare
     * @param fat valoarea fata de care numarul de grasimi al produsului trebuie sa fie mai mic
     * @param sodium valoarea fata de care cantitatea de sodiu a produsului trebuie sa fie mai mica
     * @param price valoarea fata de care pretul produsului trebuie sa fie mai mic
     * @return lista de produse, filtrata
     * @pre price >= 0
     * @post lista != null
     */
    @Override
    public TreeSet<MenuItem> searchForProduct(String keyword, float rating, int price, int calories, int protein, int fat, int sodium) {
        assert price >= 0;
        TreeSet<MenuItem> productsFound = menuItems
                .stream()
                .filter(p -> p.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .filter(p -> p.getRating() >= rating)
                .filter(p -> p.getProtein() >= protein)
                .filter(p -> p.getPrice() <= price)
                .filter(p -> p.getSodium() <= sodium)
                .filter(p -> p.getFat() <= fat)
                .collect(Collectors.toCollection(TreeSet::new));
        assert !productsFound.isEmpty();
        assert isWellFormed();
        return productsFound;
    }

    private boolean isWellFormed(){
        return !users.isEmpty();
    }
}
