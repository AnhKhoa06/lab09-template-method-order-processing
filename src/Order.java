import java.util.ArrayList;
import java.util.List;

public class Order {

    private final String customerName;
    private final List<OrderItem> items = new ArrayList<>();

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}