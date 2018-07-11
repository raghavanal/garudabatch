package com.garudaone.nfo.mappers;

import com.garudaone.nfo.model.StockList;
import org.joda.time.LocalDate;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

import java.util.Date;

public class StockEODMapper implements FieldSetMapper<StockList> {

    public StockList mapFieldSet(FieldSet fieldSet) {
        StockList stockList = new StockList();
        stockList.setSymbol(fieldSet.readString(0));
        stockList.setTradeDate(new LocalDate(fieldSet.readDate(1,"yyyyMMdd")));
        stockList.setOpenPrice(fieldSet.readDouble(2));
        stockList.setHighPrice(fieldSet.readDouble(3));
        stockList.setLowPrice(fieldSet.readDouble(4));
        stockList.setClosePrice(fieldSet.readDouble(5));
        stockList.setVolume(fieldSet.readInt(6));
        stockList.setOpenInterest(fieldSet.readInt(7));
    return  stockList;
    }
}
