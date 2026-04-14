// OrderHistory.java - Stores and displays past orders
public class OrderHistory {
    private String[] orderSummaries;
    private double[] orderTotals;
    private String[] timestamps;
    private int orderCount;
    private int maxOrders;

    public OrderHistory(int maxOrders) {
        this.maxOrders = maxOrders;
        this.orderSummaries = new String[maxOrders];
        this.orderTotals = new double[maxOrders];
        this.timestamps = new String[maxOrders];
        this.orderCount = 0;
    }

    public void addOrder(String summary, double total, String timestamp) {
        if (orderCount < maxOrders) {
            orderSummaries[orderCount] = summary;
            orderTotals[orderCount] = total;
            timestamps[orderCount] = timestamp;
            orderCount++;
        } else {
            // Shift orders and add the new one at the end (remove oldest)
            for (int i = 1; i < maxOrders; i++) {
                orderSummaries[i - 1] = orderSummaries[i];
                orderTotals[i - 1] = orderTotals[i];
                timestamps[i - 1] = timestamps[i];
            }
            orderSummaries[maxOrders - 1] = summary;
            orderTotals[maxOrders - 1] = total;
            timestamps[maxOrders - 1] = timestamp;
        }
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void displayHistory() {
        if (orderCount == 0) {
            System.out.println("\n  No orders yet!");
            System.out.println("  Place your first order from the menu.");
            return;
        }

        System.out.println("\n  ===== YOUR PAST ORDERS =====");

        for (int i = orderCount - 1; i >= 0; i--) {
            System.out.println();
            System.out.println("  --- Order #" + (i + 1) + " ---");
            System.out.println("  Time:  " + timestamps[i]);
            System.out.println("  Items: " + truncate(orderSummaries[i], 45));
            System.out.printf("  Total: Rs.%.2f%n", orderTotals[i]);
        }
    }

    private String truncate(String text, int maxLen) {
        if (text.length() <= maxLen)
            return text;
        return text.substring(0, maxLen - 3) + "...";
    }
}
