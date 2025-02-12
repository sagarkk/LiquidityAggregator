package LiquidityAggregator.model;

public class BuyOrder extends Order implements Comparable<Order> {

    public BuyOrder(double price, int quantity, String source) {
        super(price, quantity, source, Side.BUY);
    }

    @Override
    public int compareTo(Order o) {
        if (this.price != o.price)
            return Double.compare(o.price, this.price);
        else if (this.quantity != o.quantity)
            return Integer.compare(o.quantity, this.quantity);
        return String.CASE_INSENSITIVE_ORDER.compare(this.source, o.source);
    }
}
