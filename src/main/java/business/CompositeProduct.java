package business;
import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem> products;
    private int numberOfProducts;
    public CompositeProduct() {
        super("", 0, 0, 0, 0, 0, 0);
        products = new ArrayList<>();
        numberOfProducts = 0;
    }

    public CompositeProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price) {
        super(title, rating, calories, protein, fat, sodium, price);
        products = new ArrayList<>();
        numberOfProducts = 0;
    }

    @Override
    public String toString() {
        return "CompositeProduct{" +
                "products=" + products.toString() +
                ", numberOfProducts=" + numberOfProducts +
                '}';
    }

    public void addMenuItem(MenuItem menuItem){
        numberOfProducts ++;
        products.add(menuItem);
        setRating(computeRating());
        setPrice(computePrice());
        setCalories(getCalories() + menuItem.getCalories());
        setFat(getFat() + menuItem.getFat());
        setProtein(getProtein() + menuItem.getProtein());
        setSodium(getSodium() + menuItem.getSodium());
    }
    public float computeRating(){
        float totalRaiting = 0;
        for(MenuItem menuItem : products){
            totalRaiting += menuItem.getRating();
        }
        return totalRaiting / numberOfProducts;
    }

    @Override
    public int computePrice() {
        int finalPrice = 0;
        for(MenuItem menuItem : products){
            finalPrice += menuItem.getPrice();
        }
        return finalPrice;
    }
}
