// Restaurant.java - Represents a restaurant with its menu
public class Restaurant {
    private String name;
    private String location;
    private FoodItem[] menu;
    private int menuSize;
    private double baseDistance;

    public Restaurant(String name, String location, int maxMenuItems) {
        this.name = name;
        this.location = location;
        this.menu = new FoodItem[maxMenuItems];
        this.menuSize = 0;
        this.baseDistance = 0.0;
    }

    public void addFoodItem(FoodItem item) {
        if (menuSize < menu.length) {
            menu[menuSize++] = item;
        }
    }

    public void setBaseDistance(double distance) {
        this.baseDistance = distance;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getMenuSize() {
        return menuSize;
    }

    public double getBaseDistance() {
        return baseDistance;
    }

    public FoodItem getFoodItemByIndex(int index) {
        if (index >= 0 && index < menuSize) {
            return menu[index];
        }
        return null;
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("  ===== " + name + " - Menu =====");
        System.out.println("  Location: " + location + " | Distance: " + baseDistance + " km");
        System.out.println("  ------------------------------------");
        System.out.printf("   %-3s %-22s %s%n", "#", "Item", "Price");
        System.out.println("  ------------------------------------");
        for (int i = 0; i < menuSize; i++) {
            menu[i].displayItem(i + 1);
        }
        System.out.println("  ------------------------------------");
    }
}
