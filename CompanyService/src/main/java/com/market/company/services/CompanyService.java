package com.market.company.services;

import java.util.List;

import com.market.company.domain.Company;
import com.market.company.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  @Autowired
  private CompanyRepository companyRepository;

  public Company saveCompany(Company company) {
    return companyRepository.save(company);
  }

  public List<Company> saveCompanies(List<Company> companies) {
    return companyRepository.saveAll(companies);
  }

  public List<Company> getCompanies() {
    return companyRepository.findAll();
  }

  public Company getCompanyByCompanyName(String companyName) {
    return companyRepository.findCompanyByCompanyName(companyName);
  }

  public Company getCompanyByCompanyCode(String companyCode) {
    return companyRepository.findCompanyByCompanyCode(companyCode);
  }

  public String deleteCompanyById(int id) {
    companyRepository.deleteById(id);
    return "Company Deleted " + id;
  }

  public String deleteCompanyByCompanyCode(String companyCode) {
    companyRepository.deleteCompanyByCompanyCode(companyCode);
    return "Company Deleted " + companyCode;

  }

  public Company updateCompany(Company company) {
    Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
    existingCompany.setCeo(company.getCeo());
    existingCompany.setTurnover(company.getTurnover());
    existingCompany.setCompanyCode(company.getCompanyCode());
    existingCompany.setWebsite(company.getWebsite());
    existingCompany.setCompanyName(company.getCompanyName());
    existingCompany.setExchange(company.getExchange());

    return companyRepository.save(existingCompany);
  }

}
