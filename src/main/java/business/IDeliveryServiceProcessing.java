package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Dragomir Mihai-Robert
 * @date 23.05.2021
 */
public interface IDeliveryServiceProcessing{
    /**
     * Functia de importare a fisierului .csv in vederea popularii meniului restaurantului
     * @throws FileNotFoundException
     * @pre fisierul .csv exista
     * @post !menuItems.isEmpty()
     */
    void importProducts() throws FileNotFoundException;

    /**
     * Functia de adaugare a unui produs in meniul restaurantului
     * @param menuItem produsul ce se doreste a fi adaugat
     * @pre menuItem != null
     * @post menuItems.contains(menuItem)
     */
    void addProductsToMenu(MenuItem menuItem);

    /**
     * Functia de stergere a unui produs din meniul restaurantului
     * @param menuTitle numele produsului ce se doreste a fi sters
     * @pre !menuTitle.isEmpty()
     * @post newSize = oldSize - 1
     */
    void deleteProductFromMenu(String menuTitle);

    /**
     * Functia de editare a unui produs din meniul restaurantului
     * @param oldMenuItem numele produsului ce se doreste a fi editat
     * @param newMenuItem noile atribute ale produsului
     * @pre !oldMenuItem.isEmpty()
     * @post orders.contains(newMenuItem)
     */
    void editProductFromMenu(String oldMenuItem, MenuItem newMenuItem);

    /**
     * Functia de generare a raportului cu acele comenzi date intr-un anumit interval orar
     * @param startHour ora minima la care a fost depusa comanda
     * @param endHour ora maxima la care a fost depusa comanda
     * @throws IOException
     * @pre startHour <= endHour
     * @post fisierul de scriete a raportului a fost inchis
     */
    void generateTimeReport(int startHour, int endHour) throws IOException;

    /**
     * Functia de generare a raportului cu produsele comandate de cel putin un numar dat de ori
     * @param numberOfTimesOrdered numarul minim de comenzi date pentru un produs
     * @throws IOException
     * @pre numberOfTimesOrdered >= 0
     * @post fisierul de scriete a raportului a fost inchis
     */
    void generateFrequencyReport(int numberOfTimesOrdered) throws IOException;

    /**
     * Functia de generare a raportului cu clientii care au depus comenzi cu o valoare mai mare decat o valoare data
     * si numarul minim de ori de care trebuiau sa comande
     * @param numberOfTimesOrdered numarul minim de ori de care clientii trebuie sa comande
     * @param amount valoarea minima pe care trebuie sa le aiba comenzile
     * @throws IOException
     * @pre numberOfTimesOrdered >= 0 && amount >= 0
     * @post fisierul de scriete a raportului a fost inchis
     */
    void generateFrequencyAndValueReport(int numberOfTimesOrdered, int amount) throws IOException;

    /**
     * Functia de generare a raporului cu produsele comandate intr-o anumita zi si frecventa lor in comenzi
     * @param localDate data in care au fost depuse comenzile
     * @throws IOException
     * @pre localDate != null
     * @post fisierul de scriete a raportului a fost inchis
     */
    void generateDateReport(LocalDate localDate) throws IOException;

    /**
     * Functia de creare a unei comenzi depuse de un client
     * @param clientID id-ul clientului care a depus comanda
     * @param date data la care a fost depusa comanda
     * @param menuItems produsele care au fost comandate
     * @throws IOException
     * @pre menuItems != null
     * @post orders != null
     */
    void createOrder(int clientID, LocalDateTime date, ArrayList<MenuItem> menuItems) throws IOException;

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
    TreeSet<MenuItem> searchForProduct(String keyword, float rating, int calories, int protein, int fat, int sodium, int price);

}
