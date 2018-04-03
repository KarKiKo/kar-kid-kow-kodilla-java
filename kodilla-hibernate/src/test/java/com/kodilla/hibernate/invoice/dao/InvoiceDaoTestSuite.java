package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    ProductDao productDao;
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product apple = new Product("apple");
        Product banana = new Product("banana");
        Product pear = new Product("pear");
        Item appleItem1 = new Item(new BigDecimal("2.50"), 4);
        Item appleItem2 = new Item(new BigDecimal("1.80"), 3);
        Item bananaItem1 = new Item(new BigDecimal("3.20"), 2);
        Item bananaItem2 = new Item(new BigDecimal("3.50"), 3);
        Item pearItem1 = new Item(new BigDecimal("4.00"), 1);
        Item pearItem2 = new Item(new BigDecimal("4.50"), 2);
        Invoice invoice1 = new Invoice("mar_30_2018_nr_001");
        Invoice invoice2 = new Invoice("mar_30_2018_nr_002");

        invoice1.getItems().add(appleItem1);
        invoice1.getItems().add(bananaItem1);
        invoice1.getItems().add(pearItem1);
        invoice2.getItems().add(appleItem2);
        invoice2.getItems().add(bananaItem2);
        invoice2.getItems().add(pearItem2);
        appleItem1.setInvoice(invoice1);
        appleItem2.setInvoice(invoice2);
        bananaItem1.setInvoice(invoice1);
        bananaItem2.setInvoice(invoice2);
        pearItem1.setInvoice(invoice1);
        pearItem2.setInvoice(invoice2);

        apple.getItems().add(appleItem1);
        apple.getItems().add(appleItem2);
        banana.getItems().add(bananaItem1);
        banana.getItems().add(bananaItem2);
        pear.getItems().add(pearItem1);
        pear.getItems().add(pearItem2);

        appleItem1.setProduct(apple);
        appleItem2.setProduct(apple);
        bananaItem1.setProduct(banana);
        bananaItem2.setProduct(banana);
        pearItem1.setProduct(pear);
        pearItem2.setProduct(pear);

        //When
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        long numberOfInvoices = invoiceDao.count();
        long numberOfProducts = productDao.count();

        //Then
        Assert.assertEquals(2, numberOfInvoices);
        Assert.assertEquals(3, numberOfProducts);

        //Clean-up
        invoiceDao.delete(invoice1.getId());
        invoiceDao.delete(invoice2.getId());
        productDao.delete(apple.getId());
        productDao.delete(banana.getId());
        productDao.delete(pear.getId());
    }
}
