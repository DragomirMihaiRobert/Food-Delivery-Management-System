package business;

public class BaseProduct extends MenuItem{
    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price) {
        super(title, rating, calories, protein, fat, sodium, price);
    }

    @Override
    public int computePrice() {
        return getPrice();
    }
}
