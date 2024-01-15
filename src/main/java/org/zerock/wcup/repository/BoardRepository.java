package org.zerock.wcup.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.wcup.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {


    @Query("select " +
            " b.bno, b.title, count(r) " +
            " from " +
            "   Board b left outer join Reply r on r.board = b " +
            " where b.bno > 0 " +
            " group by b ")
    Page<Object[]> listWithReplyCount(Pageable pageable);

    @Query("select b from Board b where b.bno= :bno")
    Board getBno( @Param("bno") Long bno);

    //bno , Pageable
    @Query("select b from Board b where b.bno > :bno ")
    Page<Board> list1(@Param("bno") Long bno, Pageable pageable);

    @Query("select b from Board b where b.title like concat('%',:title,'%') ")
    Page<Board> listTitle(@Param("title") String title, Pageable pageable);

}
