package org.zerock.wcup.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.wcup.dto.ProductListDTO;
import org.zerock.wcup.repository.ProductRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public java.util.List<ProductListDTO> listOfStore(Long sno){

        return productRepository.listOfStore(sno);
    }

}
