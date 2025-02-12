package LiquidityAggregator;

import LiquidityAggregator.model.*;
import LiquidityAggregator.services.InstrumentToPriceBook;
import LiquidityAggregator.services.PriceBook;

public class Driver {
    public static void main(String[] args) {

        InstrumentToPriceBook instrumentToPriceBook = InstrumentToPriceBook.getInstance();

        MarketData mktData = new MarketData("LP1", "USDINR", new Order[]{new Order(82.1500,1000000,Side.BUY), new Order(82.1800, 5000000, Side.SELL)});

        PriceBook pb = instrumentToPriceBook.getPriceBook(mktData.getInstrument());
        pb.update(mktData);

        pb.update(new MarketData("LP2", "USDINR", new Order[]{new Order(83.1500,1000000,Side.BUY), new Order(82.1800, 4000000, Side.SELL), new Order(82.1500,2000000,Side.BUY), new Order(81.1800, 4000000, Side.BUY)}));
        pb.update(new MarketData("LP3", "USDINR", new Order[]{new Order(81.1500,1000000,Side.SELL), new Order(87.1800, 2000000, Side.SELL), new Order(85.1500,1040000,Side.SELL), new Order(90.1800, 2000000, Side.BUY)}));

        pb.print();

        System.out.println(pb.getTotalQuantityForPriceAndSide(82.15,Side.BUY));
        System.out.println(pb.getTotalQuantityForPriceAndSide(82.18,Side.SELL));

        System.out.println(pb.getVwapforQuantityAndSide(Side.BUY));
        System.out.println(pb.getVwapforQuantityAndSide(Side.SELL));

        pb.update(new MarketData("LP3", "USDINR", new Order[]{}));

        pb.print();

        System.out.println(pb.getTotalQuantityForPriceAndSide(82.15,Side.BUY));
        System.out.println(pb.getTotalQuantityForPriceAndSide(82.18,Side.SELL));

        System.out.println(pb.getVwapforQuantityAndSide(Side.BUY));
        System.out.println(pb.getVwapforQuantityAndSide(Side.SELL));

    }
}
