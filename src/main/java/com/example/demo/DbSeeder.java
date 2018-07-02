package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ProductPriceRepository;
import com.example.demo.entity.ProductPrice;

@Component
public class DbSeeder implements CommandLineRunner {

    private ProductPriceRepository priceRepository;

    public DbSeeder(ProductPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        ProductPrice current_price = new ProductPrice();
        current_price.setId("13860428");
        current_price.setCurrency_code("USD");
        current_price.setValue("10.00");

        this.priceRepository.deleteAll();
        List<ProductPrice> current_prices = Arrays.asList(current_price);
        this.priceRepository.save(current_price);
    }
}
