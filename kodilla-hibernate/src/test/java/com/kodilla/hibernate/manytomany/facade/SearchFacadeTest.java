package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTest {

    @Autowired
    private SearchFacade searchFacade;

    @Test
    public void testRetrievingCompaniesFromPhrase() {
        //Given
        Company abcdef = new Company("ABCDEF");
        Company fghijk = new Company("FGHIJK");
        Company klmnop = new Company("KLMNOP");

        searchFacade.saveCompanyToDB(abcdef);
        searchFacade.saveCompanyToDB(fghijk);
        searchFacade.saveCompanyToDB(klmnop);
        //When
        List<Company> retrievedCompanies = searchFacade.lookingForCompany("JK");
        //Then
        Assert.assertEquals(1,retrievedCompanies.size());
        //CleanUp
        searchFacade.removeCompaniesFromDB();
    }

    @Test
    public void testRetrievingEmployeesFromPhrase() {
        //Given
        Employee employee1 = new Employee("Jan", "Kowalski");
        Employee employee2 = new Employee("Tomasz", "Nowak");
        Employee employee3 = new Employee("Antoni", "Antoni");

        searchFacade.saveEmployeeToDB(employee1);
        searchFacade.saveEmployeeToDB(employee2);
        searchFacade.saveEmployeeToDB(employee3);
        //When
        List<Employee> retrievedEmployees = searchFacade.lookingForEmployees("ant");
        //Then
        Assert.assertEquals(1,retrievedEmployees.size());
        //CleanUp
        searchFacade.removeEmployeeFromDB(employee1);
        searchFacade.removeEmployeeFromDB(employee2);
        searchFacade.removeEmployeeFromDB(employee3);
    }
}

