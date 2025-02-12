package LiquidityAggregator.model;

public class MarketData {
    String source; //LP
    String instrument;
    Order[] order;

    public MarketData(String source, String instrument, Order[] order) {
        this.source = source;
        this.instrument = instrument;
        this.order = order;
    }

    public String getSource() {
        return source;
    }

    public String getInstrument() {
        return instrument;
    }

    public Order[] getOrder() {
        return order;
    }

    public void setOrder(Order[] order) {
        this.order = order;
    }

}
