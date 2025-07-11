package com.example.quickstart.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<Company> getAllCompanies();

    Company getCompanyId(Long Id);

    Boolean deleteCompany(Long id);

    Company updateCompany(Long id, Company company);

    Company saveCompany(Company company);

}
