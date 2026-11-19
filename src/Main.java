public class Main {

    public static void main(String[] args) {
        // Ca 1: giao nhanh
        Order order1 = new Order("Nguyễn Văn A");
        order1.addItem(new OrderItem("Bàn phím", 350000, 1));
        order1.addItem(new OrderItem("Chuột", 150000, 2));
        run("Ca 1: Giao nhanh", new ExpressDeliveryProcessor(), order1);

        // Ca 2: giao tiêu chuẩn
        Order order2 = new Order("Trần Thị B");
        order2.addItem(new OrderItem("Sách Java", 90000, 3));
        run("Ca 2: Giao tiêu chuẩn", new StandardDeliveryProcessor(), order2);

        // Ca 3: nhận tại cửa hàng
        Order order3 = new Order("Lê Văn C");
        order3.addItem(new OrderItem("Tai nghe", 500000, 1));
        run("Ca 3: Nhận tại cửa hàng", new StorePickupProcessor(), order3);

        // Ca 4: đơn không hợp lệ (không có sản phẩm)
        Order order4 = new Order("Phạm Văn D");
        run("Ca 4: Đơn không hợp lệ", new ExpressDeliveryProcessor(), order4);
    }

    private static void run(String title, OrderProcessor processor, Order order) {
        System.out.println("===== " + title + " =====");
        processor.process(order);
        System.out.println();
    }
}