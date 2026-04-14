
// OnlineFoodDeliverySystem.java - Main Class with clean, interactive console UI
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OnlineFoodDeliverySystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Restaurant[] restaurants;
    private static int restaurantCount;
    private static Coupon[] availableCoupons;
    private static int couponCount;
    private static OrderHistory orderHistory;

    public static void main(String[] args) {
        initializeSystem();
        showWelcomeBanner();

        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getIntInput("\n  >> Enter your choice (1-5): ");

            switch (choice) {
                case 1:
                    browseRestaurants();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    viewOrderHistory();
                    break;
                case 4:
                    viewAvailableCoupons();
                    break;
                case 5:
                    exit = true;
                    showGoodbyeBanner();
                    break;
                default:
                    System.out.println("\n  [!] Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    // SYSTEM INITIALIZATION

    private static void initializeSystem() {
        restaurants = new Restaurant[10];
        restaurantCount = 0;
        orderHistory = new OrderHistory(20);

        // Restaurant 1: Burger King (2.5 km away)
        Restaurant burgerKing = new Restaurant("Burger King", "Downtown", 10);
        burgerKing.setBaseDistance(2.5);
        burgerKing.addFoodItem(new FoodItem("Classic Burger", 120.00));
        burgerKing.addFoodItem(new FoodItem("Cheese Burger", 150.00));
        burgerKing.addFoodItem(new FoodItem("Double Patty Burger", 200.00));
        burgerKing.addFoodItem(new FoodItem("French Fries", 80.00));
        burgerKing.addFoodItem(new FoodItem("Soft Drink", 50.00));
        restaurants[restaurantCount++] = burgerKing;

        // Restaurant 2: Pizza Haven (1.8 km away)
        Restaurant pizzaHaven = new Restaurant("Pizza Haven", "Main Street", 10);
        pizzaHaven.setBaseDistance(1.8);
        pizzaHaven.addFoodItem(new FoodItem("Margherita Pizza", 250.00));
        pizzaHaven.addFoodItem(new FoodItem("Pepperoni Pizza", 300.00));
        pizzaHaven.addFoodItem(new FoodItem("Veggie Pizza", 280.00));
        pizzaHaven.addFoodItem(new FoodItem("Garlic Bread", 90.00));
        pizzaHaven.addFoodItem(new FoodItem("Pasta", 180.00));
        restaurants[restaurantCount++] = pizzaHaven;

        // Restaurant 3: Sushi Express (4.2 km away)
        Restaurant sushiExpress = new Restaurant("Sushi Express", "Eastside", 10);
        sushiExpress.setBaseDistance(4.2);
        sushiExpress.addFoodItem(new FoodItem("California Roll", 220.00));
        sushiExpress.addFoodItem(new FoodItem("Dragon Roll", 320.00));
        sushiExpress.addFoodItem(new FoodItem("Miso Soup", 80.00));
        sushiExpress.addFoodItem(new FoodItem("Tempura", 200.00));
        restaurants[restaurantCount++] = sushiExpress;

        // Restaurant 4: Taco Fiesta (0.5 km away)
        Restaurant tacoFiesta = new Restaurant("Taco Fiesta", "Westside", 10);
        tacoFiesta.setBaseDistance(0.5);
        tacoFiesta.addFoodItem(new FoodItem("Chicken Taco", 100.00));
        tacoFiesta.addFoodItem(new FoodItem("Paneer Taco", 120.00));
        tacoFiesta.addFoodItem(new FoodItem("Veggie Taco", 90.00));
        tacoFiesta.addFoodItem(new FoodItem("Nachos", 150.00));
        tacoFiesta.addFoodItem(new FoodItem("Quesadilla", 180.00));
        restaurants[restaurantCount++] = tacoFiesta;

        // Restaurant 5: Curry House (3.0 km away)
        Restaurant curryHouse = new Restaurant("Curry House", "Northside", 10);
        curryHouse.setBaseDistance(3.0);
        curryHouse.addFoodItem(new FoodItem("Butter Chicken", 220.00));
        curryHouse.addFoodItem(new FoodItem("Paneer Tikka", 200.00));
        curryHouse.addFoodItem(new FoodItem("Naan", 40.00));
        curryHouse.addFoodItem(new FoodItem("Biryani", 250.00));
        curryHouse.addFoodItem(new FoodItem("Gulab Jamun", 60.00));
        restaurants[restaurantCount++] = curryHouse;

        // Initialize coupons
        availableCoupons = new Coupon[10];
        couponCount = 0;
        availableCoupons[couponCount++] = new Coupon("SAVE10", 10.0, 300.0);
        availableCoupons[couponCount++] = new Coupon("SAVE20", 20.0, 500.0);
        availableCoupons[couponCount++] = new Coupon("WELCOME15", 15.0, 200.0);
        availableCoupons[couponCount++] = new Coupon("FLAT50", 50.0, 1000.0);
        availableCoupons[couponCount++] = new Coupon("FIRSTORDER", 25.0, 150.0);
    }

    // UI BANNERS

    private static void showWelcomeBanner() {
        System.out.println();
        System.out.println("  ==========================================");
        System.out.println("     ONLINE FOOD DELIVERY SYSTEM");
        System.out.println("     Fast. Fresh. Delivered to You!");
        System.out.println("  ==========================================");
        System.out.println();
        System.out.println("  Welcome! Browse restaurants, place orders,");
        System.out.println("  and enjoy your meal at home.");
    }

    private static void showGoodbyeBanner() {
        System.out.println();
        System.out.println("  ==========================================");
        System.out.println("   Thank you for using our service!");
        System.out.println("   See you next time. Goodbye!");
        System.out.println("  ==========================================");
    }

    // MAIN MENU

    private static void displayMainMenu() {
        System.out.println();
        System.out.println("  ========== MAIN MENU ==========");
        System.out.println("   1. Browse Restaurants");
        System.out.println("   2. Place an Order");
        System.out.println("   3. View Order History");
        System.out.println("   4. View Available Coupons");
        System.out.println("   5. Exit");
    }

    // FEATURE 1: BROWSE RESTAURANTS

    private static void browseRestaurants() {
        System.out.println("\n  ========== BROWSE RESTAURANTS ==========\n");
        System.out.printf("   %-3s %-20s %-12s %s%n", "#", "Restaurant", "Location", "Distance");
        System.out.println("  --------------------------------------------------");
        for (int i = 0; i < restaurantCount; i++) {
            System.out.printf("   %-3d %-20s %-12s %.1f km%n",
                    (i + 1),
                    restaurants[i].getName(),
                    restaurants[i].getLocation(),
                    restaurants[i].getBaseDistance());
        }
        System.out.println("  --------------------------------------------------");

        System.out.println("\n  Tip: Select a restaurant number to view its full menu.");
        int choice = getIntInput("  >> Enter restaurant number (0 to go back): ");

        if (choice > 0 && choice <= restaurantCount) {
            restaurants[choice - 1].displayMenu();
            pauseForUser();
        } else if (choice != 0) {
            System.out.println("  [!] Invalid selection. Returning to main menu.");
        }
    }

    // FEATURE 2: PLACE ORDER

    private static void placeOrder() {
        System.out.println("\n  ========== PLACE AN ORDER ==========");

        // Step 1: Select restaurant
        System.out.println("\n  Step 1 of 3: Choose a restaurant\n");
        System.out.printf("   %-3s %-20s %s%n", "#", "Restaurant", "Distance");
        System.out.println("  ------------------------------------");
        for (int i = 0; i < restaurantCount; i++) {
            System.out.printf("   %-3d %-20s %.1f km%n",
                    (i + 1),
                    restaurants[i].getName(),
                    restaurants[i].getBaseDistance());
        }
        System.out.println("  ------------------------------------");

        int restChoice = getIntInput("\n  >> Enter restaurant number (0 to cancel): ");
        if (restChoice == 0) {
            System.out.println("  Order cancelled. Returning to main menu.");
            return;
        }
        if (restChoice < 1 || restChoice > restaurantCount) {
            System.out.println("  [!] Invalid restaurant selection. Returning to main menu.");
            return;
        }

        Restaurant selectedRestaurant = restaurants[restChoice - 1];
        double distance = selectedRestaurant.getBaseDistance();

        // Step 2: Select items
        System.out.println("\n  Step 2 of 3: Add items to your order");
        selectedRestaurant.displayMenu();

        Order order = new Order(10, selectedRestaurant.getName(), distance);

        boolean addingItems = true;
        while (addingItems) {
            System.out.println();
            int itemChoice = getIntInput("  >> Enter item number to add (0 when done): ");

            if (itemChoice == 0) {
                if (order.getItemCount() == 0) {
                    System.out.println("  [!] No items selected. Order cancelled.");
                    return;
                }
                addingItems = false;
            } else if (itemChoice > 0 && itemChoice <= selectedRestaurant.getMenuSize()) {
                FoodItem selectedItem = selectedRestaurant.getFoodItemByIndex(itemChoice - 1);
                int quantity = getIntInput("  >> Quantity for " + selectedItem.getItemName() + ": ");

                if (quantity > 0) {
                    order.addItem(selectedItem, quantity);
                } else {
                    System.out.println("  [!] Quantity must be at least 1.");
                }
            } else {
                System.out.println("  [!] Invalid item number. Check the menu above.");
            }
        }

        // Show subtotal before coupon
        order.calculateSubtotal();
        System.out.printf("%n  Your subtotal so far: Rs.%.2f%n", order.calculateSubtotal());

        // Step 3: Apply coupon (optional)
        System.out.println("\n  Step 3 of 3: Apply a coupon (optional)");
        boolean wantCoupon = getYesNoInput("  >> Do you have a coupon code? (yes/no): ");
        if (wantCoupon) {
            applyCouponToOrder(order);
        }

        // Process and print receipt
        System.out.println("\n  Processing your order...");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
        }
        order.processOrder();

        // Save to order history
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        orderHistory.addOrder(order.getOrderSummary(), order.getTotal(), timestamp);
        System.out.println("\n  [OK] Order saved to your history.");

        pauseForUser();
    }

    private static void applyCouponToOrder(Order order) {
        System.out.println("\n  Available coupons:");
        System.out.println("  ------------------------------------");
        System.out.printf("   %-12s %-10s %s%n", "Code", "Discount", "Min Order");
        System.out.println("  ------------------------------------");
        for (int i = 0; i < couponCount; i++) {
            availableCoupons[i].displayCoupon();
        }
        System.out.println("  ------------------------------------");

        String couponCode = getStringInput("\n  >> Enter coupon code (or 0 to skip): ");
        if (couponCode.equals("0")) {
            System.out.println("  Skipping coupon.");
            return;
        }

        Coupon selectedCoupon = null;
        for (int i = 0; i < couponCount; i++) {
            if (availableCoupons[i].getCode().equalsIgnoreCase(couponCode)) {
                selectedCoupon = availableCoupons[i];
                break;
            }
        }

        if (selectedCoupon != null) {
            order.applyCoupon(selectedCoupon);
        } else {
            System.out.println("  [!] Invalid coupon code. No discount applied.");
        }
    }

    // FEATURE 3: ORDER HISTORY

    private static void viewOrderHistory() {
        System.out.println("\n  ========== ORDER HISTORY ==========");
        orderHistory.displayHistory();

        if (orderHistory.getOrderCount() > 0) {
            System.out.println("\n  Total orders placed: " + orderHistory.getOrderCount());
        }
        pauseForUser();
    }

    // FEATURE 4: VIEW COUPONS

    private static void viewAvailableCoupons() {
        System.out.println("\n  ========== AVAILABLE COUPONS ==========");
        System.out.println("\n  Use these codes when placing an order:\n");
        System.out.println("  ------------------------------------");
        System.out.printf("   %-12s %-10s %s%n", "Code", "Discount", "Min Order");
        System.out.println("  ------------------------------------");
        for (int i = 0; i < couponCount; i++) {
            availableCoupons[i].displayCoupon();
        }
        System.out.println("  ------------------------------------");

        System.out.println("\n  Note: Coupons are valid only when the");
        System.out.println("  minimum order amount is met.");
        pauseForUser();
    }

    // INPUT HELPERS (robust, crash-resistant)

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a valid number.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static boolean getYesNoInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("yes") || input.equals("y");
    }

    private static void pauseForUser() {
        System.out.println("\n  Press Enter to continue...");
        scanner.nextLine();
    }
}
