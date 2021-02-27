package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class CompanyEmployeeFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotFoundException.class);

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Company> getCompanyByPartialName(String partialName) throws NotFoundException {
        List<Company> companyMatchingList = companyDao.findCompanyByPartOfName(partialName);
        boolean wasError = false;
        LOGGER.info("Searching for a company by it's partial name.");
        if (companyMatchingList.size() <= 0) {
            LOGGER.error(NotFoundException.ERR_GET_COMPANIES_ERROR);
            wasError = true;
            if (wasError)
                LOGGER.info("Errors occured during process.");
            throw new NotFoundException(NotFoundException.ERR_GET_COMPANIES_ERROR);
        } else {
            return companyMatchingList;
        }
    }

    public List<Employee> findEmployeeByPartialLastname(String partialSurname) throws NotFoundException {
        List<Employee> employeesMatchingList = employeeDao.findEmployeeByPartOfName(partialSurname);
        boolean wasError = false;
        LOGGER.info("Searching for a employee by it's partial surname");
        if (employeesMatchingList.size() <= 0) {
            LOGGER.error(NotFoundException.ERR_GET_EMPLOYEES_ERROR);
            if (wasError)
                LOGGER.info("Errors occured during searching for an employee process.");
            throw new NotFoundException(NotFoundException.ERR_GET_COMPANIES_ERROR);
        } else {
            return employeesMatchingList;
        }
    }
}
