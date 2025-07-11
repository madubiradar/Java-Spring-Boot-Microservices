package com.example.quickstart.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyId(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            return company.get();
        }
        return null;

    }

    @Override
    public Boolean deleteCompany(Long id) {

        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()){
            Company updatedCompany = optionalCompany.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setDescription(company.getDescription());
            updatedCompany.setJobs(company.getJobs());
            companyRepository.save(updatedCompany);
            return updatedCompany;
        } else {
            return null;
        }
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
}
