package org.zerock.wcup.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.wcup.domain.Product;
import org.zerock.wcup.dto.ProductListDTO;
import org.zerock.wcup.dto.ProductRegisterDTO;
import org.zerock.wcup.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public java.util.List<ProductListDTO> listOfStore(Long sno){

        return productRepository.listOfStore(sno);
    }

    public Long register(ProductRegisterDTO productRegisterDTO){

        Product product = modelMapper.map(productRegisterDTO,Product.class);

        log.info("---------ProductService register------------");
        log.info(product);
        log.info(product.getStore());
        log.info(product.getImages());

        //check 생략
        productRegisterDTO.getUploadedFileNames().forEach(fileName -> {
            product.addImage(fileName);
        });

        log.info(product.getImages());

        productRepository.save(product);

        return 1L;
    }

}
