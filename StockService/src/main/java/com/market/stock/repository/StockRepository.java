package com.market.stock.repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.market.stock.domain.Stock;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends MongoRepository<Stock, String> {

  @Query("{'companyCode': '?0'}, {'createdDate' : { $gte: ?1, $lte: ?2 } }")
  public List<Stock> findByCreatedDateBetween(String companyCode, Instant from, Instant to);
}
