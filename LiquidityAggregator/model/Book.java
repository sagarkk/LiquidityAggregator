package LiquidityAggregator.model;

public interface Book {

    public void update(Order order);
    public void addLiquidityProvider(String lp);
    public void resetLiquidityProvider(String lp);
    public void resetCompleteBook();
    public int getTotalQuantityForPrice(double price);
    public double getVwapforQuantity();
    public void print();

}
