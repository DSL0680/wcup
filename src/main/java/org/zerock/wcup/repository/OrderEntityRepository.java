package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.wcup.domain.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
}
