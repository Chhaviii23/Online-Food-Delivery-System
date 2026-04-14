// Order.java - Represents a customer order with items, pricing, and delivery
public class Order {
    private FoodItem[] items;
    private int[] quantities;
    private int itemCount;
    private String restaurantName;
    private double deliveryDistance;
    private double subtotal;
    private double discount;
    private double deliveryFee;
    private double total;
    private String couponCode;

    // Delivery fee rates
    private static final double BASE_DELIVERY_FEE = 20.0;
    private static final double PER_KM_RATE = 10.0;

    public Order(int maxItems, String restaurantName, double deliveryDistance) {
        this.items = new FoodItem[maxItems];
        this.quantities = new int[maxItems];
        this.itemCount = 0;
        this.restaurantName = restaurantName;
        this.deliveryDistance = deliveryDistance;
        this.subtotal = 0;
        this.discount = 0;
        this.deliveryFee = 0;
        this.total = 0;
        this.couponCode = "";
    }

    public void addItem(FoodItem item, int quantity) {
        // Check if item already exists in order - merge quantities
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getItemName().equals(item.getItemName())) {
                quantities[i] += quantity;
                System.out.printf("  [+] Updated: %s x%d added (total: x%d)%n",
                    item.getItemName(), quantity, quantities[i]);
                return;
            }
        }

        if (itemCount < items.length) {
            items[itemCount] = item;
            quantities[itemCount] = quantity;
            itemCount++;
            System.out.printf("  [+] Added: %s x%d  (Rs.%.2f)%n",
                item.getItemName(), quantity, item.getPrice() * quantity);
        } else {
            System.out.println("  [!] Order is full! Cannot add more items.");
        }
    }

    public int getItemCount() {
        return itemCount;
    }

    public double calculateSubtotal() {
        subtotal = 0;
        for (int i = 0; i < itemCount; i++) {
            subtotal += items[i].getPrice() * quantities[i];
        }
        return subtotal;
    }

    public void applyCoupon(Coupon coupon) {
        calculateSubtotal();
        double discountAmt = coupon.applyDiscount(subtotal);
        if (discountAmt > 0) {
            this.discount = discountAmt;
            this.couponCode = coupon.getCode();
            coupon.markUsed();
            System.out.printf("%n  [OK] Coupon \"%s\" applied! You save Rs.%.2f%n",
                coupon.getCode(), discountAmt);
        } else if (coupon.isUsed()) {
            System.out.println("\n  [!] This coupon has already been used.");
        } else {
            System.out.printf("%n  [!] Min order Rs.%.2f required for this coupon.%n",
                coupon.getMinOrderAmount());
            System.out.printf("      Your subtotal: Rs.%.2f%n", subtotal);
        }
    }

    public void processOrder() {
        calculateSubtotal();

        // Calculate delivery fee based on distance
        deliveryFee = BASE_DELIVERY_FEE + (deliveryDistance * PER_KM_RATE);

        // Total
        total = subtotal - discount + deliveryFee;

        // Display receipt
        System.out.println();
        System.out.println("  ============ ORDER RECEIPT ============");
        System.out.println("  Restaurant: " + restaurantName);
        System.out.printf("  Distance:   %.1f km%n", deliveryDistance);
        System.out.println("  --------------------------------------");
        System.out.println("  Items Ordered:");

        for (int i = 0; i < itemCount; i++) {
            double lineTotal = items[i].getPrice() * quantities[i];
            System.out.printf("    %-20s x%-3d Rs.%7.2f%n",
                items[i].getItemName(), quantities[i], lineTotal);
        }

        System.out.println("  --------------------------------------");
        System.out.printf("  Subtotal:                  Rs.%9.2f%n", subtotal);

        if (discount > 0) {
            System.out.printf("  Discount (%s):          -Rs.%9.2f%n", couponCode, discount);
        }

        System.out.printf("  Delivery Fee (%.1f km):     Rs.%9.2f%n", deliveryDistance, deliveryFee);
        System.out.println("  ======================================");
        System.out.printf("  TOTAL:                     Rs.%9.2f%n", total);
        System.out.println("  ======================================");

        // Estimated delivery time
        int estimatedMinutes = (int)(deliveryDistance * 5) + 15;
        System.out.println();
        System.out.println("  Estimated delivery: ~" + estimatedMinutes + " minutes");
        System.out.println("  Order placed successfully!");
    }

    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append(restaurantName).append(" | ");
        for (int i = 0; i < itemCount; i++) {
            if (i > 0) sb.append(", ");
            sb.append(items[i].getItemName()).append(" x").append(quantities[i]);
        }
        return sb.toString();
    }

    public double getTotal() {
        return total;
    }
}
