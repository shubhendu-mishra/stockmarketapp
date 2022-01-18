package com.market.company.repository;

import java.util.List;

import com.market.company.domain.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

  Company findCompanyByCompanyCode(String companyCode);

  Company findCompanyByCompanyName(String companyName);

  List<Company> findAll();

  public Company deleteCompanyByCompanyCode(String companyCode);

}