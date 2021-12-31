package com.market.company.repository;

import java.util.List;

import com.market.company.domain.Company;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

  @Query("{companyCode:'?0'}")
  Company findCompanyByCompanyCode(String companyCode);

  @Query("{companyName:'?0'}")
  Company findCompanyByCompanyName(String companyName);

  @Query(value = "{companyName:'?0'}")
  List<Company> findAll(String companyName);

  public Company deleteCompanyByCompanyCode(String companyCode);

  public long count();

}