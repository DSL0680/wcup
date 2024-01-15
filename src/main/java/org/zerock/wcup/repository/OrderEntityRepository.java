package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.wcup.domain.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {

    @Query("select o.onum, o.regDate, od.odnum, od.pno, od.qty " +
            "from " +
            "  OrderEntity o inner join OrderDetail od on od.orderEntity = o " +
            "where " +
            "  o.buyer = :buyer " +
            "order by o.onum, od.odnum ")
    java.util.List<Object[]> getDataOfBuyer( @Param("buyer") String buyer);

}
