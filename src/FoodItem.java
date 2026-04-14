// FoodItem.java - Represents a single food item on a restaurant menu
public class FoodItem {
    private String itemName;
    private double price;

    public FoodItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void displayItem(int index) {
        System.out.printf("   %-3d %-22s Rs.%7.2f%n", index, itemName, price);
    }

    @Override
    public String toString() {
        return itemName + " - Rs." + String.format("%.2f", price);
    }
}
