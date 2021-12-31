package com.market.stock.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import com.market.stock.domain.Stock;
import com.market.stock.services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class StockController {
  @Autowired
  private StockService stockService;

  @PostMapping("/add")
  public Stock addStock(@RequestBody Stock stock) {
    return stockService.saveStock(stock);
  }

  @GetMapping("/get/{companyCode}/{startDate}/{endDate}")
  public List<Stock> getStocksBetweenDates(@PathVariable String companyCode,
      @PathVariable String startDate,
      @PathVariable String endDate) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return stockService.getStocksBetweenDates(companyCode, dateFormat.parse(startDate).toInstant(),
        dateFormat.parse(endDate).toInstant());
  }
}
