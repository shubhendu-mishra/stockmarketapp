package com.market.company.controllers;

import java.util.List;

import javax.ws.rs.Path;

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

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.*;

@RestController
@Path("/")
@Tag(name = "Company", description = "Operations related to Companies in Market Application")
public class CompanyController {

  @Autowired
  private CompanyService service;

  @Operation(summary = "Add a new company to Market Application")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully added new company"),
      @ApiResponse(responseCode = "401", description = "You are not authorized to add a new company"),
      @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
  })
  @PostMapping("/register")
  public Company addCompany(@RequestBody Company company) {
    return service.saveCompany(company);

  }

  @Operation(summary = "Delete company by using a valid company code")
  @DeleteMapping("/delete/{companyCode}")
  public String deleteCompanyByCompanyCode(@PathVariable String companyCode) {
    return service.deleteCompanyByCompanyCode(companyCode);
  }

  @Operation(summary = "Health Check for Company service")
  public String handshake() {
    return "Company Service is up and running!";
  }

  @Operation(summary = "Get list of all companies registered in Market application")
  @GetMapping("/getAll")
  public List<Company> findAllCompanys() {
    return service.getCompanies();
  }

  @Operation(summary = "Get info of a company by using a valid company code")
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
