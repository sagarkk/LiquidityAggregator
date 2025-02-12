package LiquidityAggregator.model;

public class Order {

    double price;
    int quantity;
    String source;
    Side side;

    public Order(double price, int quantity, Side side) {
        this.price = price;
        this.quantity = quantity;
        this.source = "";
        this.side = side;
    }
    public Order(double price, int quantity, String source, Side side) {
        this(price,quantity,side);
        this.source = source;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSource() {
        return source;
    }

    public Side getSide() {
        return side;
    }
}
