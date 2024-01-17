package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.wcup.domain.Product;
import org.zerock.wcup.dto.ProductListDTO;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(" select " +
            " new org.zerock.wcup.dto.ProductListDTO( p.pno, p.pname, p.price, pi.fileName )" +
            " from Product p inner join p.images pi " +
            " where pi.ord = 0 and p.store.sno = :sno  ")
    List<ProductListDTO> listOfStore(@Param("sno") Long sno);
}











