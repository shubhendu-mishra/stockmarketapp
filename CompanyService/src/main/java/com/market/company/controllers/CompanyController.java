package com.market.company.controllers;

import java.util.List;

import com.market.company.domain.Company;
import com.market.company.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@Api(value = "Company", description = "Operations related to Companies in Market Application")
public class CompanyController {

  @Autowired
  private CompanyService service;

  @ApiOperation(value = "Add a new company to Market Application", response = Company.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully added new company"),
      @ApiResponse(code = 401, message = "You are not authorized to add a new company"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  })
  @PostMapping("/register")
  public Company addCompany(@RequestBody Company company) {
    return service.saveCompany(company);

  }

  @ApiOperation(value = "Delete company by using a valid company code", response = String.class)
  @DeleteMapping("/delete/{companyCode}")
  public String deleteCompanyByCompanyCode(@PathVariable String companyCode) {
    return service.deleteCompanyByCompanyCode(companyCode);
  }

  @ApiOperation(value = "Health Check for Company service", response = String.class)
  public String handshake() {
    return "Company Service is up and running!";
  }

  @ApiOperation(value = "Get list of all companies registered in Market application", response = List.class)
  @GetMapping("/getAll")
  public List<Company> findAllCompanys() {
    return service.getCompanies();
  }

  @ApiOperation(value = "Get info of a company by using a valid company code", response = Company.class)
  @GetMapping("/info/{companyCode}")
  public Company findCompanyByCompanyCode(@PathVariable String companyCode) {
    return service.getCompanyByCompanyCode(companyCode);
  }

  // @GetMapping("/companyByCompanyName/{companyName}")
  // public Company findCompanyByCompanyName(@PathVariable String companyName) {
  // return service.getCompanyByCompanyName(companyName);
  // }

  // @PutMapping("/updateCompany")
  // public Company updateCompany(@RequestBody Company company) {
  // return service.updateCompany(company);
  // }

  // @DeleteMapping("/deleteCompany/{id}")
  // public String deleteCompany(@PathVariable String id) {
  // return service.deleteCompanyById(id);
  // }

  // @PostMapping("/addCompanies")
  // public List<Company> addCompanies(@RequestBody List<Company> companies) {
  // return service.saveCompanies(companies);
  // }
}
