package org.commerceproject.ecommerceprodcutservice;


import org.commerceproject.ecommerceprodcutservice.Service.ProductInitalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




// https://docs.google.com/document/d/1Gn2ib5YhhpcFUiWGAUbCpg0ZPh3m_wSA-9IolGMjkIE/edit#heading=h.fi9nsitohs6x
@SpringBootApplication
public class ECommerceProdcutServiceApplication implements CommandLineRunner {
    private final ProductInitalization productInitalization;
    @Autowired
    public ECommerceProdcutServiceApplication(ProductInitalization productInitalization) {
        this.productInitalization = productInitalization;
    }

    @Override
    public void run(String... args) throws Exception {
        productInitalization.initProducts();
    }

    public static void main(String[] args) {
        SpringApplication.run(ECommerceProdcutServiceApplication.class, args);
    }
}

