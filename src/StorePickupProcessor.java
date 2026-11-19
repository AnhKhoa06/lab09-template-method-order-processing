public class StorePickupProcessor extends OrderProcessor {

    @Override
    protected long calculateShippingFee(Order order) {
        return 0;
    }

    @Override
    protected void prepareDelivery(Order order) {
        System.out.println("Soạn hàng và để ở quầy nhận hàng.");
    }

    @Override
    protected void notifyCustomer(Order order) {
        super.notifyCustomer(order);
        System.out.println("Mã nhận hàng: PU-" + Math.abs(order.getCustomerName().hashCode() % 10000));
    }
}