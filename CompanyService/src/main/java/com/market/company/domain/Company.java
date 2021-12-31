package com.market.company.domain;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("company")
public class Company {
  @Id
  private String id;
  private String companyName;
  private String companyCode;
  private String ceo;
  private BigDecimal turnover;
  private String website;
  private String exchange;

  public String getId() {
    return id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public String getExchange() {
    return exchange;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public BigDecimal getTurnover() {
    return turnover;
  }

  public void setTurnover(BigDecimal turnover) {
    this.turnover = turnover;
  }

  public String getCeo() {
    return ceo;
  }

  public void setCeo(String ceo) {
    this.ceo = ceo;
  }

  public String getCompanyCode() {
    return companyCode;
  }

  public void setCompanyCode(String companyCode) {
    this.companyCode = companyCode;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
}
