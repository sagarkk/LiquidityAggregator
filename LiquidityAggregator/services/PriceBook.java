package LiquidityAggregator.services;

import LiquidityAggregator.model.*;

public class PriceBook {
    Book bidBook;
    Book offerBook;

    public PriceBook(){
        bidBook = new BidBook();
        offerBook = new OfferBook();
    }

    public void update(MarketData mdata) {
      Enrichment.enrichMarketData(mdata);
      String source = mdata.getSource();
      Order[] orders = mdata.getOrder();
      resetLiquidityProvider(source);
      boolean isBidOrderPresent = false;
      boolean isOfferOrderPresent = false;
      for(Order order: orders){
          if(order instanceof BuyOrder){
              isBidOrderPresent = true;
              bidBook.update(order);
          } else {
              isOfferOrderPresent = true;
              offerBook.update(order);
          }
      }
      if(isBidOrderPresent) {
          bidBook.addLiquidityProvider(source);
      }
      if(isOfferOrderPresent){
          offerBook.addLiquidityProvider(source);
      }
    }

    public void resetLiquidityProvider(String lp) {
          bidBook.resetLiquidityProvider(lp);
          offerBook.resetLiquidityProvider(lp);
    }

    public void reset() {
          bidBook.resetCompleteBook();
          offerBook.resetCompleteBook();
    }

    public int getTotalQuantityForPriceAndSide(double price, Side side) {
        switch (side){
            case BUY:
                return bidBook.getTotalQuantityForPrice(price);
            case SELL:
                return offerBook.getTotalQuantityForPrice(price);
        }
        return -1;
    }

    public double getVwapforQuantityAndSide(Side side) {
        switch (side){
            case BUY:
                return bidBook.getVwapforQuantity();
            case SELL:
                return offerBook.getVwapforQuantity();
        }
        return -1;
    }

    public void print() {
       System.out.println("=====================COMPLETE-BOOK=====================");
       bidBook.print();
       offerBook.print();
    }
}
