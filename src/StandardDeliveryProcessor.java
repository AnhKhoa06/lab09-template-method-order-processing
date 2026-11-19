public class StandardDeliveryProcessor extends OrderProcessor {

    @Override
    protected long calculateShippingFee(Order order) {
        return 20000;
    }

    @Override
    protected void prepareDelivery(Order order) {
        System.out.println("Gom đơn vào chuyến xe giao hàng, dự kiến giao sau 3 đến 5 ngày.");
    }
}