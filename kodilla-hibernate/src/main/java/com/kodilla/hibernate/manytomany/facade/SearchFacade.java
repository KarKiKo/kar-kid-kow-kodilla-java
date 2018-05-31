package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class SearchFacade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> lookingForCompany(String phrase){
        return companyDao.retrieveCompanyWithPhrase("%" + phrase + "%");
    }

    public List<Employee> lookingForEmployees(String phrase){
        return employeeDao.retrieveEmployeesWithPhrase("%" + phrase + "%");
    }

    public void saveCompanyToDB(Company company) {
        companyDao.save(company);
    }

    public void removeCompaniesFromDB() {
        companyDao.deleteAll();
    }

    public void removeEmployeeFromDB(Employee employee) {
        employeeDao.delete(employee);
    }

    public void saveEmployeeToDB(Employee employee) {
        employeeDao.save(employee);
    }

}
