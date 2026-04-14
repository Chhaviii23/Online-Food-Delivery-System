// Coupon.java - Represents a discount coupon
public class Coupon {
    private String code;
    private double discountPercent;
    private double minOrderAmount;
    private boolean used;

    public Coupon(String code, double discountPercent, double minOrderAmount) {
        this.code = code;
        this.discountPercent = discountPercent;
        this.minOrderAmount = minOrderAmount;
        this.used = false;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public double getMinOrderAmount() {
        return minOrderAmount;
    }

    public boolean isUsed() {
        return used;
    }

    public void markUsed() {
        this.used = true;
    }

    public double applyDiscount(double orderAmount) {
        if (orderAmount >= minOrderAmount && !used) {
            return orderAmount * (discountPercent / 100.0);
        }
        return 0;
    }

    public void displayCoupon() {
        String status = used ? " [USED]" : "";
        System.out.printf("   %-12s %4.0f%% off   Min: Rs.%.2f%s%n",
            code, discountPercent, minOrderAmount, status);
    }
}
