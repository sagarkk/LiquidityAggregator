package LiquidityAggregator.model;

public class SellOrder extends Order implements Comparable<Order> {

    public SellOrder(double price, int quantity, String source) {
        super(price, quantity, source, Side.SELL);
    }

    @Override
    public int compareTo(Order o) {
        if (this.price != o.price)
            return Double.compare(this.price, o.price);
        else if (this.quantity != o.quantity)
            return Integer.compare(o.quantity, this.quantity);
        return String.CASE_INSENSITIVE_ORDER.compare(this.source, o.source);
    }
}
