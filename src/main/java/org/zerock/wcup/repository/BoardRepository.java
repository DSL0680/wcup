package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.wcup.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
