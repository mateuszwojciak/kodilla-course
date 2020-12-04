package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMastersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNamedQueriesCompany() {
        //Given
        Company company1 = new Company("Microsoft");
        Company company2 = new Company("Microchip");
        Company company3 = new Company("Samsung");

        //When
        companyDao.save(company1);
        int companyOneId = company1.getId();
        companyDao.save(company2);
        int companyTwoId = company2.getId();
        companyDao.save(company3);
        int companyThreeId = company3.getId();

        List<Company> searchListByThreeLetters = companyDao.retrieveByFirstThree("Mic");

        //Then
        try {
            assertEquals(2, searchListByThreeLetters.size());
        } finally {
        //CleanUp
            companyDao.deleteById(companyOneId);
            companyDao.deleteById(companyTwoId);
            companyDao.deleteById(companyThreeId);
        }
    }

    @Test
    void testNamedQueriesEmployee() {
        //Given
        Employee employee1 = new Employee("Janusz", "Kowalski");
        Employee employee2 = new Employee("Michał", "Kowalski");
        Employee employee3 = new Employee("Andrzej", "Nowak");

        //When
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        List<Employee> searchListByLastname = employeeDao.retrieveByLastname("Kowalski");

        //Then
        try {
            assertEquals(2, searchListByLastname.size());
        } finally {
        //CleanUp
            employeeDao.delete(employee1);
            employeeDao.delete(employee2);
            employeeDao.delete(employee3);
        }
    }
}