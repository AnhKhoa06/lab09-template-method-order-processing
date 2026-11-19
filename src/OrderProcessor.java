public abstract class OrderProcessor {

    // Template method: khung xử lý chung, lớp con không được ghi đè
    public final void process(Order order) {
        if (!validate(order)) {
            System.out.println("Đơn hàng không hợp lệ, dừng xử lý.");
            return;
        }
        long subtotal = calculateSubtotal(order);
        long shippingFee = calculateShippingFee(order);
        long total = subtotal + shippingFee;

        prepareDelivery(order);
        notifyCustomer(order);
        printSummary(order, subtotal, shippingFee, total);
    }

    // Các bước giống nhau ở mọi hình thức giao
    protected boolean validate(Order order) {
        if (order == null || order.getItems().isEmpty()) {
            return false;
        }
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() <= 0) {
                return false;
            }
        }
        return true;
    }

    protected long calculateSubtotal(Order order) {
        long sum = 0;
        for (OrderItem item : order.getItems()) {
            sum += item.getTotal();
        }
        return sum;
    }

    protected void printSummary(Order order, long subtotal, long shippingFee, long total) {
        System.out.println("Khách hàng: " + order.getCustomerName());
        System.out.println("Tiền hàng: " + subtotal);
        System.out.println("Phí giao: " + shippingFee);
        System.out.println("Tổng tiền: " + total);
    }

    // Các bước thay đổi, lớp con bắt buộc phải cài
    protected abstract long calculateShippingFee(Order order);

    protected abstract void prepareDelivery(Order order);

    // Hook: có cách làm mặc định, lớp con muốn thì ghi đè
    protected void notifyCustomer(Order order) {
        System.out.println("Đã gửi email xác nhận cho " + order.getCustomerName());
    }
}