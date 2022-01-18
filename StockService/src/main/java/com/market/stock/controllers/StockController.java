package com.market.stock.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import javax.ws.rs.Path;

import com.market.stock.domain.Stock;
import com.market.stock.services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;

@RestController
@Path("/")
public class StockController {
  @Autowired
  private StockService stockService;

  @Operation(summary = "Add a stock price for a company")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully added new stock price"),
      @ApiResponse(responseCode = "401", description = "You are not authorized to add a new stock price"),
      @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
  })
  @PostMapping("/add")
  public Stock addStock(@RequestBody Stock stock) {
    return stockService.saveStock(stock);
  }

  @Operation(summary = "Fetch stock prices for a company between 2 dates in yyyy-MM-dd format")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully fetched stock prices between the given dates"),
      @ApiResponse(responseCode = "401", description = "You are not authorized to fetch the stock prices"),
      @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
  })
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
