package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class FindCompanyEmployeeTestSuite {

    @Autowired
    CompanyEmployeeFacade companyEmployeeFacade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;


    @Test
    public void testCompanyFacade() {
        Employee employeeOne = new Employee("Karol", "Kowalski");
        Employee employeeTwo = new Employee("Maria", "Kowalska");
        Employee employeeThree = new Employee("Marcin", "Nowak");

        Company biedronka = new Company("Biedronka");
        Company lidl = new Company("Lidl");

        biedronka.getEmployees().add(employeeOne);
        biedronka.getEmployees().add(employeeTwo);
        lidl.getEmployees().add(employeeThree);

        employeeOne.getCompanies().add(biedronka);
        employeeTwo.getCompanies().add(biedronka);
        employeeThree.getCompanies().add(lidl);

        companyDao.save(biedronka);
        companyDao.save(lidl);

        try {
            companyEmployeeFacade.getCompanyByPartialName("dron");
        } catch (NotFoundException e) {

        }
    }

    @Test
    public void testEmployeeFacade() {
        Employee employeeOne = new Employee("Karol", "Kowalski");
        Employee employeeTwo = new Employee("Maria", "Kowalska");
        Employee employeeThree = new Employee("Marcin", "Nowak");

        Company biedronka = new Company("Biedronka");
        Company lidl = new Company("Lidl");

        biedronka.getEmployees().add(employeeOne);
        biedronka.getEmployees().add(employeeTwo);
        lidl.getEmployees().add(employeeThree);

        employeeOne.getCompanies().add(biedronka);
        employeeTwo.getCompanies().add(biedronka);
        employeeThree.getCompanies().add(lidl);

        companyDao.save(biedronka);
        companyDao.save(lidl);

        try {
            companyEmployeeFacade.findEmployeeByPartialLastname("owal");
        } catch (NotFoundException e) {

        }
    }
}
