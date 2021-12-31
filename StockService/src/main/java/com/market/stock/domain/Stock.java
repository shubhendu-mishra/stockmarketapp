package com.market.stock.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document("stock")
public class Stock {
  @Id
  private String id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date createdDate = new Date();

  private String companyCode;

  private double fractionalPrice;

  public Date getCreatedDate() {
    return createdDate;
  }

  public String getId() {
    return id;
  }

  public double getFractionalPrice() {
    return fractionalPrice;
  }

  public void setFractionalPrice(double fractionalPrice) {
    this.fractionalPrice = fractionalPrice;
  }

  public String getCompanyCode() {
    return companyCode;
  }

  public void setCompanyCode(String companyCode) {
    this.companyCode = companyCode;
  }

}
