public class ExpressDeliveryProcessor extends OrderProcessor {

    @Override
    protected long calculateShippingFee(Order order) {
        return 40000;
    }

    @Override
    protected void prepareDelivery(Order order) {
        System.out.println("Gọi shipper lấy hàng, giao trong 2 giờ.");
    }
}