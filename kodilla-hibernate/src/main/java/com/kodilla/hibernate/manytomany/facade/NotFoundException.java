package com.kodilla.hibernate.manytomany.facade;

public class NotFoundException extends Exception {

    public static String ERR_GET_COMPANIES_ERROR= "Cannot get list of companies";
    public static String ERR_GET_EMPLOYEES_ERROR= "Cannot get list of employees";

    public NotFoundException(String message) {
        super(message);
    }
}