public class OrderItem {

    private final String name;
    private final long unitPrice;
    private final int quantity;

    public OrderItem(String name, long unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getTotal() {
        return unitPrice * quantity;
    }
}