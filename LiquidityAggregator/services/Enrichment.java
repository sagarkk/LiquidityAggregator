package LiquidityAggregator.services;

import LiquidityAggregator.model.*;

public class Enrichment {
    public static void enrichMarketData(MarketData mktData){
        Order[] recievedOrders = mktData.getOrder();
        String source = mktData.getSource();
        Order[] enrichedOrders = new Order[recievedOrders.length];
        int index = 0;
        for(Order order: recievedOrders){
            if(order.getSide() == Side.BUY) {
                enrichedOrders[index++] = new BuyOrder(order.getPrice(), order.getQuantity(), source);
            } else {
                enrichedOrders[index++] = new SellOrder(order.getPrice(), order.getQuantity(), source);
            }
        }
        mktData.setOrder(enrichedOrders);
    }
}
