package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.wcup.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
