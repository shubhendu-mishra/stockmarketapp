package com.market.stock.services;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.market.stock.domain.Stock;
import com.market.stock.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
  @Autowired
  private StockRepository stockRepository;

  public Stock saveStock(Stock stock) {
    return stockRepository.save(stock);
  }

  public List<Stock> saveStocks(List<Stock> stocks) {
    return stockRepository.saveAll(stocks);

  }

  public List<Stock> getStocksBetweenDates(String companyCode, Instant from, Instant to) {
    return stockRepository.findByCreatedDateBetween(companyCode, from, to);
  }
}
