package LiquidityAggregator.model;

import LiquidityAggregator.exception.InvalidOrderException;

import java.util.*;

public class BidBook implements Book{
    // Sorted map of order and liquidity provider
    TreeSet<BuyOrder> buyOrders;
    Set<String> liquidityProviders;
    Map<Double, Integer> priceToQuantityMap;
    long priceQuantity;
    long totalQuantity;

    public BidBook() {
        buyOrders = new TreeSet<>();
        liquidityProviders = new HashSet<>();
        priceToQuantityMap = new HashMap<>();
        priceQuantity = 0;
        totalQuantity = 0;
    }

    @Override
    public void update(Order order) {
        if (!(order instanceof BuyOrder)) {
            throw new InvalidOrderException();
        }
            buyOrders.add((BuyOrder) order);
            priceToQuantityMap.put(order.price, priceToQuantityMap.getOrDefault(order.price, 0) + order.quantity);
            priceQuantity += (order.price * order.quantity);
            totalQuantity += order.quantity;

    }

    @Override
    public void addLiquidityProvider(String lp) {
        liquidityProviders.add(lp);
    }

    @Override
    public void resetLiquidityProvider(String lp) {
        if (liquidityProviders.contains(lp)) {
            liquidityProviders.remove(lp);
            for (Order order : buyOrders) {
                if (order.source.equals(lp)) {
                    priceToQuantityMap.put(order.price, priceToQuantityMap.get(order.price) - order.quantity);
                    priceQuantity -= (order.price * order.quantity);
                    totalQuantity -= order.quantity;
                }
                if (priceToQuantityMap.get(order.price) == 0) {
                    priceToQuantityMap.remove(order.price);
                }
            }
            buyOrders.removeIf(order -> order.source.equals(lp));
        }
    }

    @Override
    public void resetCompleteBook() {
        buyOrders.clear();
        liquidityProviders.clear();
        priceToQuantityMap.clear();
        priceQuantity = 0L;
        totalQuantity = 0L;
    }

    @Override
    public int getTotalQuantityForPrice(double price) {
        return priceToQuantityMap.get(price);
    }

    @Override
    public double getVwapforQuantity() {
        return ((double) priceQuantity)/((double)totalQuantity) ;
    }

    @Override
    public void print() {
        System.out.println("-------------------------BID-BOOK-------------------------");
        System.out.println(" PRICE        | QUANTITY       | LIQUIDITY PROVIDER       ");
        for(Order order: buyOrders){
            System.out.println(order.price+"        | "+order.quantity+"        | "+order.source);
        }
    }
}
