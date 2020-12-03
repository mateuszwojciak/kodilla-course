package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product productOne = new Product("TV Samsung");
        Product productTwo = new Product("Krzesło");

        Item itemOne = new Item(productOne, new BigDecimal(2499), 1, new BigDecimal(2499));
        Item itemTwo = new Item(productTwo, new BigDecimal(250), 4, new BigDecimal(1000));

        Invoice invoiceTest = new Invoice();

        invoiceTest.getItems().add(itemOne);
        invoiceTest.getItems().add(itemTwo);

        Invoice invoice = new Invoice("125023", invoiceTest.getItems());

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //CleanUp
        invoiceDao.deleteById(invoiceId);

    }
}
