package LiquidityAggregator.services;

import java.util.HashMap;
import java.util.Map;

public class InstrumentToPriceBook {
    public Map<String, PriceBook> instrumentToPriceBook;
    private static final InstrumentToPriceBook instance = new InstrumentToPriceBook(new HashMap<>());

    private InstrumentToPriceBook(Map<String, PriceBook> instrumentToPriceBook){
        this.instrumentToPriceBook = instrumentToPriceBook;
    }

    public static InstrumentToPriceBook getInstance(){
        return instance;
    }

    public PriceBook getPriceBook(String instrument){
        instrumentToPriceBook.computeIfAbsent(instrument, V -> new PriceBook());
        return instrumentToPriceBook.get(instrument);
    }
}
