package org.zerock.wcup.repository;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.wcup.domain.Product;
import org.zerock.wcup.domain.Store;
import org.zerock.wcup.dto.ProductListDTO;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Log4j2
public class StoreProductTests {

    @Autowired
    StoreRepository storeRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void testInsertStores() {

        for (int i = 0; i < 10; i++) {

            Store store = Store.builder().title("가게"+i).build();

            storeRepository.save(store);

        }//end for

    }//end test

    @Test
    public void testInsertProducts(){

        Store store = Store.builder().sno(2L).build();

        for (int i = 0; i < 5; i++) {

            Product product = Product.builder()
                    .pname("가게2 메뉴"+i)
                    .price(2500 + (i * 100))
                    .store(store)
                    .build();

            product.addImage(UUID.randomUUID().toString()+"_test1.jpg");
            product.addImage(UUID.randomUUID().toString()+"_test2.jpg");

            productRepository.save(product);


        }//end for
    }

    @Test
    public void testList() {

        List<ProductListDTO> result = productRepository.listOfStore(1L);

        result.forEach(dto -> log.info(dto));

    }

}











