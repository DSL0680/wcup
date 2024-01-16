package org.zerock.wcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.wcup.domain.Reply;
import org.zerock.wcup.dto.ReplyDTO;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {

    //특정 게시물의 모든 댓글 조회용
   // rno, replyText, replyer, bno,  regDate,  modDate
    @Query("select new org.zerock.wcup.dto.ReplyDTO(r.rno, r.replyText, r.replyer, r.board.bno, r.regDate,r.modDate  ) " +
            " from Reply r " +
            " where r.board.bno = :bno order by r.rno desc ")
    List<ReplyDTO> listOfBoard(@Param("bno") Long bno);
}
